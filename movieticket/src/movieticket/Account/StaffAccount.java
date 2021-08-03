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
 * @author Pham Huu Duong
 */
public class StaffAccount {

    private ObjectProperty<Integer> staffid;
    private StringProperty username;
    private StringProperty password;
    private StringProperty fullname;
    private StringProperty dob;
    private StringProperty email;
    private StringProperty phonenumber;
    private StringProperty address;

    public StaffAccount() {
        staffid = new SimpleObjectProperty<>(null);
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        fullname = new SimpleStringProperty();
        dob = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phonenumber = new SimpleStringProperty();
        address = new SimpleStringProperty();
    }

    //get set value
    public Integer getStaffID() {
        return staffid.get();
    }

    public String getUsername() {
        return username.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getFullname() {
        return fullname.get();
    }

    public String getDob() {
        return dob.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public String getAdderss() {
        return address.get();
    }

    public void setStaffID(int id) {
        this.staffid.set(id);
    }

    public void setUsername(String un) {
        this.username.set(un);
    }

    public void setPassword(String pass) {
        this.password.set(pass);
    }

    public void setFullname(String name) {
        this.fullname.set(name);
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public void setEmail(String em) {
        this.email.set(em);
    }

    public void setPhonenumber(String phone) {
        this.phonenumber.set(phone);
    }

    public void setAdderss(String ad) {
        this.address.set(ad);
    }

    //get Property
    public ObjectProperty<Integer> getStaffIDProperty() {
        return this.staffid;
    }

    public StringProperty getUsernameProperty() {
        return this.username;
    }

    public StringProperty getPasswordProperty() {
        return this.password;
    }

    public StringProperty getFullnameProperty() {
        return this.fullname;
    }

    public StringProperty getDobProperty() {
        return this.dob;
    }

    public StringProperty getAdderssProperty() {
        return this.address;
    }

    public StringProperty getPhoneProperty() {
        return this.phonenumber;
    }

    public static StaffAccount getStaffAccount(String username) throws SQLException {
        StaffAccount admin = new StaffAccount();
        String sql = "SELECT * FROM `staff` WHERE `username` = '" + username + "'";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                admin.setStaffID(rs.getInt("staffid"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setPhonenumber(rs.getString("phonenumber"));
                admin.setFullname(rs.getString("fullname"));
                admin.setDob(rs.getString("dob"));
                admin.setEmail(rs.getString("email"));
                admin.setAdderss(rs.getString("address"));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return admin;
    }

    public static ObservableList<StaffAccount> selectAllStaffAccount() {
        ObservableList<StaffAccount> staffacc
                = FXCollections.observableArrayList();

        // database lay Staff account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM staff");) {

            while (rs.next()) {
                StaffAccount accs = new StaffAccount();
                accs.setStaffID(rs.getInt("staffid"));
                accs.setUsername(rs.getString("username"));
                accs.setPassword(rs.getString("password"));
                accs.setPhonenumber(rs.getString("phonenumber"));
                accs.setFullname(rs.getString("fullname"));
                accs.setDob(rs.getString("dob"));
                accs.setEmail(rs.getString("email"));
                accs.setAdderss(rs.getString("address"));

                staffacc.add(accs);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return staffacc;
    }

    public static boolean delete(StaffAccount deleteStaffAccount) throws SQLException {
        String sql = "DELETE FROM `staff` WHERE staffid = ?";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteStaffAccount.getStaffID());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No account deleted");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static StaffAccount insert(StaffAccount newas) throws SQLException {
        String sql = "INSERT INTO  `staff` (fullname, dob, username, password, email, phonenumber, address)"
                + "VALUES (? , ? , ? , ? , ? , ? , ?)";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newas.getFullname());
            stmt.setString(2, newas.getDob());
            stmt.setString(3, newas.getUsername());
            stmt.setString(4, newas.getPassword());
            stmt.setString(5, newas.getEmail());
            stmt.setString(6, newas.getPhonenumber());
            stmt.setString(7, newas.getAdderss());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newas.setStaffID(newKey);
                return newas;
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

    public static boolean update(StaffAccount updateStaffAccount) {
        String sql = "UPDATE staff SET "
                + "fullname = ?, "
                + "dob = ?, "
                + "username = ?, "
                + "password = ?, "
                + "email = ?, "
                + "phonenumber = ?, "
                + "address = ? "
                + "WHERE staffid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, updateStaffAccount.getFullname());
            stmt.setString(2, updateStaffAccount.getDob());
            stmt.setString(3, updateStaffAccount.getUsername());
            stmt.setString(4, updateStaffAccount.getPassword());
            stmt.setString(5, updateStaffAccount.getEmail());
            stmt.setString(6, updateStaffAccount.getPhonenumber());
            stmt.setString(7, updateStaffAccount.getAdderss());
            stmt.setInt(8, updateStaffAccount.getStaffID());
            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No account updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

}
