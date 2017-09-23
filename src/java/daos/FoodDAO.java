/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daos;

import db.MyConnection;
import dtos.FoodDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author justdoit
 */
public class FoodDAO {

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
    
    public List<FoodDTO> loadMenu() {
        ArrayList<FoodDTO> res = new ArrayList();
        try {
            String sql = "SELECT * FROM food";
            conn = MyConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                res.add(new FoodDTO(id, name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        if (res.isEmpty())
            res = null;
        return res;
    }
    
    public boolean addFood(String id, String name, int price) {
        boolean res = false;
        try {
            String sql = "INSERT INTO food VALUES(?,?,?)";
            conn = MyConnection.getConnection();
            PreparedStatement preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, name);
            preStm.setInt(3, price);
            int t = preStm.executeUpdate();
            if (t>0) res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return res;
    }
}