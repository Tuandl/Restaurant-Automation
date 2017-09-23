/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import db.MyConnection;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
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
public class OrderDetailDAO {
    
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

    public int insertOD(OrderDetailDTO dto) {
        int res = 0;
        try {
            String sql = "INSERT INTO orderdetail(code, orderid, foodid, quantity, chefid) "
                    + "VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getCode());
            preStm.setString(2, dto.getOrderId());
            preStm.setString(3, dto.getFoodId());
            preStm.setInt(4, dto.getQuantity());
            preStm.setString(5, dto.getChefId());
            res = preStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }    
    
    public int update(OrderDetailDTO dto) {
        int res = 0;
        try {
            String sql = "UPDATE orderdetail SET orderid = ?, foodid = ?, quantity = ?,"
                    + " chefid = ? where code = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getOrderId());
            preStm.setString(2, dto.getFoodId());
            preStm.setInt(3, dto.getQuantity());
            preStm.setString(4, dto.getChefId());
            preStm.setString(5, dto.getCode());
            res = preStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public int count() {
        int res = 0;
        try {
            String sql = "SELECT * FROM orderdetail";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                res++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public List<OrderDetailDTO> loadAll() {
        List<OrderDetailDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orderdetail";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String orderId = rs.getString("orderid");
                String foodId = rs.getString("foodid");
                int quantity = rs.getInt("quantity");
                String chefId = rs.getString("chefid");
                String status = rs.getString("status");
                res.add(new OrderDetailDTO(code, orderId, foodId, quantity, chefId, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
     public List<OrderDetailDTO> findByOrderID(String orderID) {
        List<OrderDetailDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orderdetail where orderid = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String orderId = rs.getString("orderid");
                String foodId = rs.getString("foodid");
                int quantity = rs.getInt("quantity");
                String chefId = rs.getString("chefid");
                String status = rs.getString("status");
                res.add(new OrderDetailDTO(code, orderId, foodId, quantity, chefId, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
     public List<OrderDetailDTO> findByOrderStatus(String status) {
        List<OrderDetailDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orderdetail where status = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, status);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String orderId = rs.getString("orderid");
                String foodId = rs.getString("foodid");
                int quantity = rs.getInt("quantity");
                String chefId = rs.getString("chefid");
                res.add(new OrderDetailDTO(code, orderId, foodId, quantity, chefId, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
     
     //-new
    public List<OrderDetailDTO> FindByTime(Timestamp start, Timestamp end) {
        List<OrderDetailDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT orderdetail.* FROM orderdetail INNER JOIN [order] ON [order].id = orderdetail.orderid \n"
                    + "WHERE [order].starttime BETWEEN ? AND ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String orderId = rs.getString("orderid");
                String foodId = rs.getString("foodid");
                int quantity = rs.getInt("quantity");
                String chefId = rs.getString("chefid");
                String status = rs.getString("status");
                res.add(new OrderDetailDTO(code, orderId, foodId, quantity, chefId, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    //-new
    public List<OrderDetailDTO> FindByTimeAndChefID(Timestamp start, Timestamp end, String chefID) {
        List<OrderDetailDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT orderdetail.* FROM orderdetail INNER JOIN [order] ON [order].id = orderdetail.orderid \n"
                    + "WHERE [order].starttime BETWEEN ? AND ? and chefid = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            preStm.setString(3, chefID);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String code = rs.getString("code");
                String orderId = rs.getString("orderid");
                String foodId = rs.getString("foodid");
                int quantity = rs.getInt("quantity");
                String chefId = rs.getString("chefid");
                String status = rs.getString("status");
                res.add(new OrderDetailDTO(code, orderId, foodId, quantity, chefId, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
}