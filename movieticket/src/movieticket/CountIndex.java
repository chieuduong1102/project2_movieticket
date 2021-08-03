/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.ObjectProperty;
import movieticket.Account.AdminAccount;
import movieticket.DbConnection.DbConection;

/**
 *
 * @author Pham Huu Duong
 */
public class CountIndex {

    private ObjectProperty<Integer> id;
    private ObjectProperty<Integer> count;

    public Integer getID() {
        return id.get();
    }

    public Integer getCountValue() {
        return count.get();
    }

    public void setID(int id) {
        this.id.set(id);
    }

    public void setCountValue(int s) {
        this.count.set(s);
    }

    public static Integer getCountValueDB() throws SQLException {
        int count = 0;
        String sql = "SELECT `count` FROM `countticket` WHERE `id` = 1";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
    
        public static boolean update(int c) {
        String sql = "UPDATE countticket SET " +
                "`count` = ? " +
                "WHERE id = 1";
        try (
            Connection conn = DbConection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ) {
            
            stmt.setInt(1, c);
                        
            int rowUpdated = stmt.executeUpdate();
            
            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No  updated");
                return false;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
}
