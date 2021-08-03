/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movieticket.DbConnection.DbConection;

/**
 *
 * @author Pham Huu Duong //maitrongdat
 */
public class AdminAccount {

    private ObjectProperty<Integer> adminid;
    private StringProperty username;
    private StringProperty password;

    public AdminAccount() {
        adminid = new SimpleObjectProperty<>(null);
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    //get set value
    public Integer getAdminID() {
        return adminid.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public void setAdminID(int id) {
        this.adminid.set(id);
    }

    public void setUsername(String un) {
        this.username.set(un);
    }

    public void setPassword(String pass) {
        this.password.set(pass);
    }

    //get Property
    public ObjectProperty<Integer> getAdminIDProperty() {
        return this.adminid;
    }

    public StringProperty getUsernameProperty() {
        return this.username;
    }

    public StringProperty getPasswordProperty() {
        return this.password;
    }

    public static AdminAccount getAdminAccount(String username) throws SQLException {
        AdminAccount admin = new AdminAccount();
        String sql = "SELECT * FROM `admin` WHERE `username` = '" + username + "'";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                admin.setAdminID(rs.getInt("adminid"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return admin;
    }

    public static ObservableList<AdminAccount> selectAllAdminAccount() {
        ObservableList<AdminAccount> accounts
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM admin");) {

            while (rs.next()) {
                AdminAccount acc = new AdminAccount();
                int adId = rs.getInt("adminid");
                acc.setAdminID(adId);
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));

                accounts.add(acc);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return accounts;
    }

    public static boolean delete(AdminAccount deleteAdminAccount) throws SQLException {
           String sql = "DELETE FROM `admin` WHERE adminid = ?";
           
           try (
                   Connection conn = DbConection.getConnection();
                   PreparedStatement stmt = conn.prepareStatement(sql);
                   ){
               stmt.setInt(1, deleteAdminAccount.getAdminID());
               
               int rowDeleted = stmt.executeUpdate();
               
               if(rowDeleted == 1){
                   return true;
               }
               else {
                   System.err.println("No account deleted");
                   return false;
               }
           } catch (Exception e){
               System.err.println(e);
               return false;
           }
    }

    public static AdminAccount insert(AdminAccount newaa) throws SQLException {
        String sql = "INSERT INTO  `admin` (username, password)"
                + "VALUES (? , ?)";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newaa.getUsername());
            stmt.setString(2, newaa.getPassword());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newaa.setAdminID(newKey);
                return newaa;
            } else {
                System.err.println("No account inserted");
                return null;
            }
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (key != null) {
                key.close();
            }
        }
    }
    
    public static boolean update(AdminAccount updateAdminAccount) {
        String sql = "UPDATE admin SET " +
                "username = ?, " +
                "password = ? " +
                "WHERE adminid = ?";
        try (
            Connection conn = DbConection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
                ) {
            
            stmt.setString(1, updateAdminAccount.getUsername());
            stmt.setString(2, updateAdminAccount.getPassword());
            stmt.setInt(3, updateAdminAccount.getAdminID());
                        
            int rowUpdated = stmt.executeUpdate();
            
            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No account  updated");
                return false;
            }
            
            
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
    
}
