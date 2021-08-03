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
public class Movie {

    private ObjectProperty<Integer> movieid;
    public StringProperty title;
    public StringProperty director;
    public StringProperty nation;
    public StringProperty year;
    public ObjectProperty<Integer> views;
    public StringProperty status;
    public ObjectProperty<ImageView> cover;
    public StringProperty covername;

    public Movie() {
        movieid = new SimpleObjectProperty<>(null);
        title = new SimpleStringProperty();
        director = new SimpleStringProperty();
        nation = new SimpleStringProperty();
        year = new SimpleStringProperty();
        views = new SimpleObjectProperty<>();
        status = new SimpleStringProperty();
        cover = new SimpleObjectProperty<>();
        covername = new SimpleStringProperty();
    }

    public Integer getMovieID() {
        return movieid.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getDirector() {
        return director.get();
    }

    public String getNation() {
        return nation.get();
    }

    public String getYear() {
        return year.get();
    }

    public Integer getViews() {
        return views.get();
    }

    public String getStatus() {
        return status.get();
    }

    public ImageView getCover() {
        return cover.get();
    }

    public String getCoverName() {
        return covername.get();
    }

    public void setMovieID(int id) {
        this.movieid.set(id);
    }

    public void setTitle(String value) {
        this.title.set(value);
    }

    public void setDirector(String value) {
        this.director.set(value);
    }

    public void setNation(String value) {
        this.nation.set(value);
    }

    public void setYear(String value) {
        this.year.set(value);
    }

    public void setViews(int value) {
        this.views.set(value);
    }

    public void setStatus(String value) {
        this.status.set(value);
    }

    public void setCover(ImageView value) {
        this.cover.set(value);
    }

    public void setCoverName(String value) {
        this.covername.set(value);
    }

    public ObjectProperty<Integer> getMovieIDProperty() {
        return this.movieid;
    }

    public StringProperty getTitleProperty() {
        return this.title;
    }

    public StringProperty getDirectorProperty() {
        return this.director;
    }

    public StringProperty getNationProperty() {
        return this.nation;
    }

    public StringProperty getYearProperty() {
        return this.year;
    }

    public ObjectProperty<Integer> getViewsProperty() {
        return this.views;
    }

    public StringProperty getStatusProperty() {
        return this.status;
    }

    public ObjectProperty<ImageView> getCoverProperty() {
        return this.cover;
    }

    public static ObservableList<Movie> selectAllMovie() {
        ObservableList<Movie> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movie");) {

            while (rs.next()) {
                Movie m = new Movie();
                int id = rs.getInt("movieid");
                m.setMovieID(id);
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setNation(rs.getString("nation"));
                m.setYear(rs.getString("year"));
                m.setViews(rs.getInt("views"));
                m.setStatus(rs.getString("status"));
                ImageView imgv = new ImageView(new Image("movieticket/img/" + rs.getString("cover")));
                imgv.setFitWidth(100);
                imgv.setFitHeight(140);
                m.setCover(imgv);
                m.setCoverName(rs.getString("cover"));
                movies.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    public static ObservableList<String> selectAllTitleMovie() {
        ObservableList<String> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT title FROM movie");) {

            while (rs.next()) {
                movies.add(rs.getString("title"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }
    
     public static ObservableList<String> selectAllNationMovie() {
        ObservableList<String> list
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT nation FROM movie GROUP BY nation");) {

            while (rs.next()) {
                list.add(rs.getString("nation"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return list;
    }
     
     

    public static ObservableList<String> selectAllTitleMovieActived() {
        ObservableList<String> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT title FROM movie WHERE status= 'Đang chiếu' ");) {

            while (rs.next()) {
                movies.add(rs.getString("title"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    public static ObservableList<Movie> selectAllMovieActived() {
        ObservableList<Movie> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE status = 'Đang chiếu'");) {

            while (rs.next()) {
                Movie m = new Movie();
                int id = rs.getInt("movieid");
                m.setMovieID(id);
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setNation(rs.getString("nation"));
                m.setYear(rs.getString("year"));
                m.setViews(rs.getInt("views"));
                m.setStatus(rs.getString("status"));
                ImageView imgv = new ImageView(new Image("movieticket/img/" + rs.getString("cover")));
                imgv.setFitWidth(100);
                imgv.setFitHeight(140);
                m.setCover(imgv);
                m.setCoverName(rs.getString("cover"));
                movies.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    public static ObservableList<Movie> selectAllMovieDC() {
        ObservableList<Movie> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE status = 'Đang chiếu' ORDER BY views DESC LIMIT 4 ");) {

            while (rs.next()) {
                Movie m = new Movie();
                int id = rs.getInt("movieid");
                m.setMovieID(id);
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setNation(rs.getString("nation"));
                m.setYear(rs.getString("year"));
                m.setViews(rs.getInt("views"));
                m.setStatus(rs.getString("status"));
                ImageView imgv = new ImageView(new Image("movieticket/img/" + rs.getString("cover")));
                imgv.setFitWidth(100);
                imgv.setFitHeight(140);
                m.setCover(imgv);
                m.setCoverName(rs.getString("cover"));
                movies.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return movies;
    }

    public static ObservableList<Movie> selectAllMovieSC() {
        ObservableList<Movie> movies
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM movie WHERE status = 'Sắp chiếu'");) {

            while (rs.next()) {
                Movie m = new Movie();
                int id = rs.getInt("movieid");
                m.setMovieID(id);
                m.setTitle(rs.getString("title"));
                m.setDirector(rs.getString("director"));
                m.setNation(rs.getString("nation"));
                m.setYear(rs.getString("year"));
                m.setViews(rs.getInt("views"));
                m.setStatus(rs.getString("status"));
                ImageView imgv = new ImageView(new Image("movieticket/img/" + rs.getString("cover")));
                imgv.setFitWidth(100);
                imgv.setFitHeight(140);
                m.setCover(imgv);
                m.setCoverName(rs.getString("cover"));
                movies.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return movies;
    }

    public static Movie insert(Movie m) throws SQLException {
        String sql = "INSERT INTO `movie` ( title, director, nation, year, views, status, cover )"
                + "VALUES ( ?, ? , ? , ? , ? , ? , ? )";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            stmt.setString(1, m.getTitle());
            stmt.setString(2, m.getDirector());
            stmt.setString(3, m.getNation());
            stmt.setString(4, m.getYear());
            stmt.setInt(5, m.getViews());
            stmt.setString(6, m.getStatus());
            stmt.setString(7, m.getCoverName());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                m.setMovieID(newKey);
                return m;
            } else {
                System.err.println("No movie inserted");
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

    public static boolean delete(Movie m) throws SQLException {
        String sql = "DELETE FROM `movie` WHERE movieid = ? ";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, m.getMovieID());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No movie deleted");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static Movie getMovieByID(int id) throws SQLException {
        Movie moive = new Movie();
        String sql = "SELECT * FROM `movie` WHERE `movieid` = ' " + id + " ' ";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement prep = conn.prepareStatement(sql);
                ResultSet rs = prep.executeQuery();) {
            if (rs.next()) {
                moive.setMovieID(rs.getInt("movieid"));
                moive.setTitle(rs.getString("title"));
                moive.setDirector(rs.getString("director"));
                moive.setNation(rs.getString("nation"));
                moive.setYear(rs.getString("year"));
                moive.setViews(rs.getInt("views"));
                moive.setStatus(rs.getString("status"));
                ImageView imgv = new ImageView(new Image("movieticket/img/" + rs.getString("cover")));
                imgv.setFitWidth(100);
                imgv.setFitHeight(140);
                moive.setCover(imgv);
                moive.setCoverName(rs.getString("cover"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return moive;
    }

    public static boolean update(Movie updateMovie) {
        String sql = "UPDATE movie SET "
                + "title = ?, "
                + "director = ?, "
                + "nation = ?, "
                + "year = ?, "
                + "views = ?, "
                + "status = ?, "
                + "cover = ? "
                + "WHERE movieid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, updateMovie.getTitle());
            stmt.setString(2, updateMovie.getDirector());
            stmt.setString(3, updateMovie.getNation());
            stmt.setString(4, updateMovie.getYear());
            stmt.setInt(5, updateMovie.getViews());
            stmt.setString(6, updateMovie.getStatus());
            stmt.setString(7, updateMovie.getCoverName());
            stmt.setInt(8, updateMovie.getMovieID());

            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No movie updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
