/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import db.MyConnection;
import dtos.ManageBusboyDTO;
import dtos.ManageChefDTO;
import dtos.ManageFoodDTO;
import dtos.ManageHostDTO;
import dtos.ManageOrderDTO;
import dtos.ManageWaiterDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author justdoit
 */
public class ManageDAO {
    
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<ManageBusboyDTO> reportBusboy(Timestamp start, Timestamp end, int top, String order) {
        List<ManageBusboyDTO> res = new ArrayList<>();
        try {
            String sql = "WITH T AS( " +
            "	SELECT staffid AS id, COUNT(*) AS [action] " +
            "	FROM tablestatuschange " +
            "	WHERE [time] BETWEEN ? AND ? " +
            "	GROUP BY staffid " +
            ") " +
            "SELECT top " + top + " staff.id AS id, staff.name AS name, ISNULL([action],0) AS [action] " +
            "FROM staff LEFT OUTER JOIN T ON staff.id = T.id " +
            "WHERE staff.[role] = 'Bus Boy' " +
            "ORDER BY [action] " + order;
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int action = rs.getInt("action");
                res.add(new ManageBusboyDTO(id, name, action));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public List<ManageChefDTO> reportChef(Timestamp start, Timestamp end, int top, String order) {
        List<ManageChefDTO> res = new ArrayList<>();
        try {
            String sql = "WITH T AS (\n" +
                    "	SELECT orderdetail.chefid AS chefid, COUNT(*) AS [action]\n" +
                    "	FROM orderdetail INNER JOIN [order] ON orderdetail.orderid = [order].id\n" +
                    "	WHERE [order].starttime BETWEEN ? AND ?\n" +
                    "	GROUP BY orderdetail.chefid\n" +
                    ")\n" +
                    "SELECT TOP " + top + " staff.id AS id, staff.name AS name, ISNULL(T.[action],0) as [action]\n" +
                    "FROM T RIGHT OUTER JOIN staff ON T.chefid = staff.id\n" +
                    "WHERE staff.role = 'Chef' \n" + 
                    "ORDER BY [action] " + order;
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int action = rs.getInt("action");
                res.add(new ManageChefDTO(id, name, action));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public ManageOrderDTO reportOrder(Timestamp start, Timestamp end) {
        ManageOrderDTO res = null;
        try {
            String sql = "WITH T AS (\n" +
                    "	SELECT orderdetail.orderid AS orderid, SUM(orderdetail.quantity * food.price) AS income\n" +
                    "	FROM orderdetail INNER JOIN food ON orderdetail.foodid = food.id\n" +
                    "	GROUP BY orderdetail.orderid\n" +
                    ")\n" +
                    "SELECT COUNT(*) AS [count], ISNULL(AVG(CAST(DATEDIFF(SECOND,starttime,endtime) AS FLOAT)),0) AS [avgtime],\n" +
                    "			SUM(T.income) AS income\n" +
                    "FROM [order] INNER JOIN T ON [order].id = T.orderid\n" +
                    "WHERE ? <= [order].starttime AND [order].starttime <= ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                float avgTime = rs.getFloat("avgtime");
                int income = rs.getInt("income");
                res = new ManageOrderDTO(count, avgTime, income);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public List<ManageWaiterDTO> reportWaiter(Timestamp start, Timestamp end, int top, String order) {
        List<ManageWaiterDTO> res = new ArrayList<>();
        try {
            String sql = "WITH T AS (\n" +
                    "	SELECT [order].id AS orderid, [order].waiterid AS waiterid, SUM(orderdetail.quantity*food.price) AS income, 1 AS q\n" +
                    "	FROM [order] INNER JOIN orderdetail ON [order].id = orderdetail.orderid\n" +
                    "		INNER JOIN food ON orderdetail.foodid = food.id\n" +
                    "	WHERE [order].starttime BETWEEN ? AND ?\n" +
                    "	GROUP BY [order].id, [order].waiterid\n" +
                    ")\n" +
                    "SELECT TOP " + top + " staff.id AS id, staff.name as name, ISNULL(COUNT(q),0) AS cntOrder, ISNULL(SUM(income),0) AS income\n" +
                    "FROM staff LEFT OUTER JOIN T ON staff.id = T.waiterid\n" +
                    "WHERE staff.role = 'Waiter'\n" +
                    "GROUP BY staff.id, staff.name\n" +
                    "ORDER BY cntOrder " + order;
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int cntOrder = rs.getInt("cntOrder");
                int income = rs.getInt("income");
                res.add(new ManageWaiterDTO(id, name, cntOrder, income));
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public List<ManageFoodDTO> reportFood(Timestamp start, Timestamp end, int top, String order) {
        List<ManageFoodDTO> res = new ArrayList<>();
        try {
            String sql = "WITH T AS (\n" +
                    "	SELECT orderdetail.foodid AS foodid, orderdetail.quantity AS quantity\n" +
                    "	FROM orderdetail INNER JOIN [order] ON orderdetail.orderid = [order].id\n" +
                    "	WHERE ? <= [order].starttime AND [order].starttime <= ?	\n" +
                    ")\n" +
                    "SELECT TOP " + top + " food.id AS id, food.name as name, food.price as price, ISNULL(SUM(quantity),0) as quantity, \n" +
                    "	ISNULL(food.price * SUM(quantity),0) as income\n" +
                    "FROM food LEFT OUTER JOIN T \n" +
                    "	ON food.id = T.foodid\n" +
                    "GROUP BY [food].id, name, price, quantity\n" +
                    "ORDER BY quantity " + order;
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery(); 
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int income = rs.getInt("income");
                res.add(new ManageFoodDTO(id, name, price, quantity, income));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
        public List<ManageHostDTO> reportHost(Timestamp start, Timestamp end, int top, String order) {
        List<ManageHostDTO> res = new ArrayList<>();
        try {
            String sql = "WITH T AS( " +
            "	SELECT staffid AS id, COUNT(*) AS [action] " +
            "	FROM tablestatuschange " +
            "	WHERE [time] BETWEEN ? AND ? " +
            "	GROUP BY staffid " +
            ") " +
            "SELECT top " + top + " staff.id AS id, staff.name AS name, ISNULL([action],0) AS [action] " +
            "FROM staff LEFT OUTER JOIN T ON staff.id = T.id " +
            "WHERE staff.[role] = 'Host' " +
            "ORDER BY [action] " + order;
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int action = rs.getInt("action");
                res.add(new ManageHostDTO(id, name, action));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
}