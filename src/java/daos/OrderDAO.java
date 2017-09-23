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
public class OrderDAO {

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

    public int insertOrder(OrderDTO dto) {
        int res = 0;
        try {
            String sql = "INSERT INTO [order] (id, tableid, waiterid, status, starttime, endtime)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getTableId());
            preStm.setString(3, dto.getWaiterId());
            preStm.setString(4, dto.getStatus());
            preStm.setTimestamp(5, dto.getStartTime());
            preStm.setTimestamp(6, dto.getEndTime());
            res = preStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }

    public int updateOrder(OrderDTO dto) {
        int res = 0;
        try {
            String sql = "UPDATE [order] SET tableid = ?, waiterid = ?, status = ?,"
                    + " starttime = ?, endtime = ? WHERE id = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getTableId());
            preStm.setString(2, dto.getWaiterId());
            preStm.setString(3, dto.getStatus());
            preStm.setTimestamp(4, dto.getStartTime());
            preStm.setTimestamp(5, dto.getEndTime());
            preStm.setString(6, dto.getId());
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
            String sql = "SELECT * FROM [order]";
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

    public List<OrderDTO> loadAll() {
        List<OrderDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [order]";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String tableId = rs.getString("tableid");
                String waiterId = rs.getString("waiterid");
                String status = rs.getString("status");
                Timestamp startTime = rs.getTimestamp("starttime");
                Timestamp endTime = rs.getTimestamp("endtime");
                res.add(new OrderDTO(id, tableId, waiterId, status, startTime, endTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }

    //NEW
    public List<OrderDTO> findByTime(Timestamp start, Timestamp end) {
        List<OrderDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [order] WHERE starttime BETWEEN ? AND ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setTimestamp(1, start);
            preStm.setTimestamp(2, end);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String tableId = rs.getString("tableid");
                String waiterId = rs.getString("waiterid");
                String status = rs.getString("status");
                Timestamp startTime = rs.getTimestamp("starttime");
                Timestamp endTime = rs.getTimestamp("endtime");
                res.add(new OrderDTO(id, tableId, waiterId, status, startTime, endTime));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    //New
    public OrderDTO findByID(String id) {
        OrderDTO res = null;
        try {
            String sql = "SELECT * FROM [order] WHERE id = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                res = new OrderDTO();
                String tableId = rs.getString("tableid");
                String waiterId = rs.getString("waiterid");
                String status = rs.getString("status");
                Timestamp startTime = rs.getTimestamp("starttime");
                Timestamp endTime = rs.getTimestamp("endtime");
                res = new OrderDTO(id, tableId, waiterId, status, startTime, endTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    //New
    public OrderDTO findByIDInTime(String id, Timestamp start, Timestamp end) {
        OrderDTO res = null;
        try {
            String sql = "SELECT * FROM [order] WHERE (waiterid = ?) AND (starttime BETWEEN ? AND ?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setTimestamp(2, start);
            preStm.setTimestamp(3, end);
            rs = preStm.executeQuery();
            if (rs.next()) {
                res = new OrderDTO();
                String tableId = rs.getString("tableid");
                String waiterId = rs.getString("waiterid");
                String status = rs.getString("status");
                Timestamp startTime = rs.getTimestamp("starttime");
                Timestamp endTime = rs.getTimestamp("endtime");
                res = new OrderDTO(id, tableId, waiterId, status, startTime, endTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public List<OrderDTO> findByWaiterIDInTime(String id, Timestamp start, Timestamp end) {
        List<OrderDTO> res = null;
        try {
            String sql = "SELECT * FROM [order] WHERE (waiterid = ?) AND (starttime BETWEEN ? AND ?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setTimestamp(2, start);
            preStm.setTimestamp(3, end);
            rs = preStm.executeQuery();
            res = new ArrayList<>();
            while (rs.next()) {
                OrderDTO dto;
                String tableId = rs.getString("tableid");
                String waiterId = rs.getString("waiterid");
                String status = rs.getString("status");
                String orderId = rs.getString("id");
                Timestamp startTime = rs.getTimestamp("starttime");
                Timestamp endTime = rs.getTimestamp("endtime");
                dto = new OrderDTO(orderId, tableId, waiterId, status, startTime, endTime);
                res.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }

}
