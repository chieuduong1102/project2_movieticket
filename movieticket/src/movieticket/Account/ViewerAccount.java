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
public class ViewerAccount {

    private ObjectProperty<Integer> viewerid;
    private StringProperty username;
    private StringProperty password;
    private StringProperty fullname;
    private StringProperty dob;
    private StringProperty email;
    private StringProperty phonenumber;
    private StringProperty address;

    public ViewerAccount() {
        viewerid = new SimpleObjectProperty<>(null);
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        fullname = new SimpleStringProperty();
        dob = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phonenumber = new SimpleStringProperty();
        address = new SimpleStringProperty();
    }

    //get set value
    public Integer getViewID() {
        return viewerid.get();
    }

    public String getUsernameV() {
        return username.get();
    }

    public String getPasswordV() {
        return password.get();
    }

    public String getFullnameV() {
        return fullname.get();
    }

    public String getDobV() {
        return dob.get();
    }

    public String getEmailV() {
        return email.get();
    }

    public String getPhonenumberV() {
        return phonenumber.get();
    }

    public String getAdderssV() {
        return address.get();
    }

    public void setViewerID(int id) {
        this.viewerid.set(id);
    }

    public void setUsernameV(String un) {
        this.username.set(un);
    }

    public void setPasswordV(String pass) {
        this.password.set(pass);
    }

    public void setFullnameV(String name) {
        this.fullname.set(name);
    }

    public void setDobV(String dob) {
        this.dob.set(dob);
    }

    public void setEmailV(String em) {
        this.email.set(em);
    }

    public void setPhonenumberV(String phone) {
        this.phonenumber.set(phone);
    }

    public void setAdderssV(String ad) {
        this.address.set(ad);
    }

    //get Property
    public ObjectProperty<Integer> getViewerIDProperty() {
        return this.viewerid;
    }

    public StringProperty getUsernameVProperty() {
        return this.username;
    }

    public StringProperty getPasswordVProperty() {
        return this.password;
    }

    public StringProperty getFullnameVProperty() {
        return this.fullname;
    }

    public StringProperty getDobVProperty() {
        return this.dob;
    }

    public StringProperty getAdderssVProperty() {
        return this.address;
    }

    public StringProperty getPhoneVProperty() {
        return this.phonenumber;
    }

    public static ViewerAccount getViewerAccount(String username) throws SQLException {
        ViewerAccount view = new ViewerAccount();
        String sql = "SELECT * FROM `viewer` WHERE `username` = '" + username + "'";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                view.setViewerID(rs.getInt("viewerid"));
                view.setUsernameV(rs.getString("username"));
                view.setPasswordV(rs.getString("password"));
                view.setPhonenumberV(rs.getString("phonenumber"));
                view.setFullnameV(rs.getString("fullname"));
                view.setDobV(rs.getString("dob"));
                view.setEmailV(rs.getString("email"));
                view.setAdderssV(rs.getString("address"));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return view;
    }

    public static ViewerAccount getViewerAccountbyFullName(String fullname) throws SQLException {
        ViewerAccount view = new ViewerAccount();
        String sql = "SELECT * FROM `viewer` WHERE `fullname` = '" + fullname + "'";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                view.setViewerID(rs.getInt("viewerid"));
                view.setUsernameV(rs.getString("username"));
                view.setPasswordV(rs.getString("password"));
                view.setPhonenumberV(rs.getString("phonenumber"));
                view.setFullnameV(rs.getString("fullname"));
                view.setDobV(rs.getString("dob"));
                view.setEmailV(rs.getString("email"));
                view.setAdderssV(rs.getString("address"));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return view;
    }

    public static ObservableList<ViewerAccount> selectAllViewAccount() {
        ObservableList<ViewerAccount> Vieweracc
                = FXCollections.observableArrayList();

        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM viewer");) {

            while (rs.next()) {
                ViewerAccount accv = new ViewerAccount();
                accv.setViewerID(rs.getInt("viewerid"));
                accv.setUsernameV(rs.getString("username"));
                accv.setPasswordV(rs.getString("password"));
                accv.setPhonenumberV(rs.getString("phonenumber"));
                accv.setFullnameV(rs.getString("fullname"));
                accv.setDobV(rs.getString("dob"));
                accv.setEmailV(rs.getString("email"));
                accv.setAdderssV(rs.getString("address"));

                Vieweracc.add(accv);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return Vieweracc;
    }

    public static boolean delete(ViewerAccount deleteViewerAccount) throws SQLException {
        String sql = "DELETE FROM `viewer` WHERE viewerid = ?";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteViewerAccount.getViewID());

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

    public static ViewerAccount insert(ViewerAccount newv) throws SQLException {
        String sql = "INSERT INTO  `viewer` (fullname, dob, username, password, email, phonenumber, address)"
                + "VALUES (? , ? , ? , ? , ? , ? , ?)";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newv.getFullnameV());
            stmt.setString(2, newv.getDobV());
            stmt.setString(3, newv.getUsernameV());
            stmt.setString(4, newv.getPasswordV());
            stmt.setString(5, newv.getEmailV());
            stmt.setString(6, newv.getPhonenumberV());
            stmt.setString(7, newv.getAdderssV());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newv.setViewerID(newKey);
                return newv;
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

    public static boolean update(ViewerAccount updateViewerAccount) {
        String sql = "UPDATE viewer SET "
                + "fullname = ?, "
                + "dob = ?, "
                + "username = ?, "
                + "password = ?, "
                + "email = ?, "
                + "phonenumber = ?, "
                + "address = ? "
                + "WHERE viewerid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, updateViewerAccount.getFullnameV());
            stmt.setString(2, updateViewerAccount.getDobV());
            stmt.setString(3, updateViewerAccount.getUsernameV());
            stmt.setString(4, updateViewerAccount.getPasswordV());
            stmt.setString(5, updateViewerAccount.getEmailV());
            stmt.setString(6, updateViewerAccount.getPhonenumberV());
            stmt.setString(7, updateViewerAccount.getAdderssV());
            stmt.setInt(8, updateViewerAccount.getViewID());
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
