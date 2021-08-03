/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket.Movie;

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
 * @author FPT SHOP
 */
public class Category {

    private ObjectProperty<Integer> categoryid;
    private StringProperty categoryname;

    public Category() {
        categoryid = new SimpleObjectProperty<>(null);
        categoryname = new SimpleStringProperty();
    }

    public Integer getCategoryID() {
        return categoryid.get();
    }

    public String getCategoryName() {
        return categoryname.get();
    }

    public void setCategoryID(int id) {
        this.categoryid.set(id);
    }

    public void setCategoryName(String cn) {
        this.categoryname.set(cn);
    }

    public ObjectProperty<Integer> getCategoryIDProperty() {
        return this.categoryid;
    }

    public StringProperty getCategoryNameProperty() {
        return this.categoryname;
    }

    public static Category getCategory(String category) throws SQLException {
        Category cate = new Category();
        String sql = "SELECT * FROM `category` WHERE `categoryname` = '" + category + "'";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                cate.setCategoryID(rs.getInt("categoryid"));
                cate.setCategoryName(rs.getString("categoryname"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cate;
    }

    public static ObservableList<Category> selectAllCategory() {
        ObservableList<Category> cate
                = FXCollections.observableArrayList();

        // database lay category
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM category");) {

            while (rs.next()) {
                Category acc = new Category();
                int cId = rs.getInt("categoryid");
                acc.setCategoryID(cId);
                acc.setCategoryName(rs.getString("categoryname"));
                cate.add(acc);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return cate;
    }

    public static ObservableList<String> selectAllNameCategory() {
        ObservableList<String> cate
                = FXCollections.observableArrayList();

        // database lay category
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT categoryname FROM category");) {

            while (rs.next()) {
                cate.add(rs.getString("categoryname"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return cate;
    }

    public static boolean delete(Category deleteCategory) throws SQLException {
        String sql = "DELETE FROM `category` WHERE categoryid = ?";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, deleteCategory.getCategoryID());

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

    public static Category insert(Category newaa) throws SQLException {
        String sql = "INSERT INTO  `category` (categoryname)"
                + "VALUES (? )";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, newaa.getCategoryName());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newaa.setCategoryID(newKey);
                return newaa;
            } else {
                System.err.println("No category inserted");
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

    public static boolean update(Category updateCategory) {
        String sql = "UPDATE category SET "
                + "categoryname = ? "
                + "WHERE categoryid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, updateCategory.getCategoryName());
            stmt.setInt(2, updateCategory.getCategoryID());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No category updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
