/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pham Huu Duong
 */
public class DbConection {
    private static final String username = "root";
    private static final String password = "";
    private static final String connection_string = "jdbc:mysql://localhost/movieticket?serverTimezone=UTC";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(connection_string, username, password);
    }
}
