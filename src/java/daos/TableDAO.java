/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import db.MyConnection;
import dtos.TableDTO;
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
public class TableDAO {
    

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
    
    public List<TableDTO> loadAll() {
        List<TableDTO> res = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [table]";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String status = rs.getString("status");
                res.add(new TableDTO(id, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public int update(TableDTO dto) {
        int res = 0;
        try {
            String sql = "UPDATE [table] SET status = ? WHERE id = ?";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getStatus());
            preStm.setString(2, dto.getId());
            res = preStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public void changeTableStatus(String empid,String tableid,String status,Timestamp time){
        try {
            String sql = "INSERT INTO [tablestatuschange] VALUES (?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, empid);
            preStm.setString(2, tableid);
            preStm.setString(3, status);
            preStm.setTimestamp(4, time);
            preStm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
    }
}