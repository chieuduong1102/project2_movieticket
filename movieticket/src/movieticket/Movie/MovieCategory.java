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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import movieticket.DbConnection.DbConection;

/**
 *
 * @author GearVn
 */
public class MovieCategory {

    private ObjectProperty<Integer> mcid;
    private ObjectProperty<Integer> movieid;
    private ObjectProperty<Integer> categoryid;
    public StringProperty titlemovie;
    public StringProperty namecategory;

    public MovieCategory() {
        mcid = new SimpleObjectProperty<>(null);
        movieid = new SimpleObjectProperty<>(null);
        categoryid = new SimpleObjectProperty<>(null);
        titlemovie = new SimpleStringProperty();
        namecategory = new SimpleStringProperty();
    }

    public Integer getMCID() {
        return mcid.get();
    }

    public Integer getMovieIDMC() {
        return movieid.get();
    }

    public Integer getCategoryIDMC() {
        return categoryid.get();
    }

    public String getTitleMovie() {
        return titlemovie.get();
    }

    public String getNameCategory() {
        return namecategory.get();
    }

    public void setMCID(int id) {
        this.mcid.set(id);
    }

    public void setMovieIDMC(int id) {
        this.movieid.set(id);
    }

    public void setCatetoryIDMC(int id) {
        this.categoryid.set(id);
    }

    public void setTitleMovie(String value) {
        this.titlemovie.set(value);
    }

    public void setNameCategory(String value) {
        this.namecategory.set(value);
    }

    public ObjectProperty<Integer> getMCIDProperty() {
        return this.mcid;
    }

    public ObjectProperty<Integer> getMovieIDMCProperty() {
        return this.movieid;
    }

    public ObjectProperty<Integer> getCategoryIDMCProperty() {
        return this.categoryid;
    }

    public StringProperty getTitleMovieProperty() {
        return this.titlemovie;
    }

    public StringProperty getNameCategoryProperty() {
        return this.namecategory;
    }

    public static ObservableList<MovieCategory> selectAllCategoryMovie() {
        ObservableList<MovieCategory> mcs
                = FXCollections.observableArrayList();

        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `moviecategory` "
                        + "JOIN movie ON moviecategory.movieid = movie.movieid "
                        + "JOIN category ON moviecategory.categoryid = category.categoryid  ");) {

            while (rs.next()) {
                MovieCategory mc = new MovieCategory();
                int id = rs.getInt("movieid");
                mc.setMovieIDMC(id);
                mc.setCatetoryIDMC(rs.getInt("categoryid"));
                mc.setTitleMovie(rs.getString("title"));
                mc.setNameCategory(rs.getString("categoryname"));

                mcs.add(mc);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return mcs;
    }

    public static MovieCategory insert(MovieCategory newaa) throws SQLException {
        String sql = "INSERT INTO  `moviecategory` (movieid, categoryid)"
                + "VALUES (? , ?)";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setInt(1, newaa.getMovieIDMC());
            stmt.setInt(2, newaa.getCategoryIDMC());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                newaa.setMCID(newKey);
                return newaa;
            } else {
                System.err.println("No moviecategory inserted");
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

    public static boolean delete(MovieCategory m) throws SQLException {
        String sql = "DELETE FROM moviecategory WHERE mcid = ? ";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, m.getMCID());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No one deleted");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean update(MovieCategory um) {
        String sql = "UPDATE moviecategory SET "
                + "movieid = ?, "
                + "categoryid = ? "
                + "WHERE mcid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setInt(1, um.getMovieIDMC());
            stmt.setInt(2, um.getCategoryIDMC());
            stmt.setInt(3, um.getMCID());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                System.out.println(um.getMCID());
                System.out.println(um.getMovieIDMC());
                System.out.println(um.getCategoryIDMC());
                return true;
            } else {
                System.err.println("No one updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

}
