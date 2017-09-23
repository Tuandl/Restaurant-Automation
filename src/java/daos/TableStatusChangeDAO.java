/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import db.MyConnection;
import dtos.TableStatusChangeDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author justdoit
 */
public class TableStatusChangeDAO {

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
    
    public int insertChange(TableStatusChangeDTO dto) {
        System.out.println(dto.getId());
        int res = -1;
        try {
            String sql = "INSERT INTO tablestatuschange VALUES(?,?,?,?,?)";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getStaffID());
            preStm.setString(3, dto.getTableID());
            preStm.setString(4, dto.getStatus());
            preStm.setTimestamp(5, dto.getTime());
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
            String sql = "SELECT * FROM tablestatuschange";
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
        System.out.println(res);
        return res;
    }
}