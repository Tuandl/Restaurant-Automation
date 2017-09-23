/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author justdoit
 */
public class MyConnection {
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456789";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "database = restaurant;",USERNAME,PASSWORD);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}