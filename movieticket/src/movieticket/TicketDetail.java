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
import movieticket.Movie.Movie;

/**
 *
 * @author Pham Huu Duong
 */
public class TicketDetail {

    private ObjectProperty<Integer> ticketid;
    public StringProperty customer;
    public StringProperty phonenumber;
    public StringProperty moviename;
    public StringProperty room;
    public StringProperty timeslot;
    public StringProperty seat;
    public ObjectProperty<Integer> price;
    public ObjectProperty<Integer> numberticket;
    public ObjectProperty<Integer> totalPrice;

    public TicketDetail() {
        ticketid = new SimpleObjectProperty<>(null);
        customer = new SimpleStringProperty();
        phonenumber = new SimpleStringProperty();
        moviename = new SimpleStringProperty();
        room = new SimpleStringProperty();
        timeslot = new SimpleStringProperty();
        seat = new SimpleStringProperty();
        price = new SimpleObjectProperty<>();
        numberticket = new SimpleObjectProperty<>();
        totalPrice = new SimpleObjectProperty<>();
    }

    public Integer getTicketID() {
        return ticketid.get();
    }

    public String getCustomer() {
        return customer.get();
    }

    public String getPhoneNumber() {
        return phonenumber.get();
    }

    public String getMovieName() {
        return moviename.get();
    }

    public String getRoom() {
        return room.get();
    }

    public String getTimeSlot() {
        return timeslot.get();
    }

    public String getSeat() {
        return seat.get();
    }

    public Integer getPrice() {
        return 75000;
    }

    public Integer getNumberTicket() {
        return numberticket.get();
    }

    public Integer getTotalPrice() {
        return price.get()*numberticket.get();
    }

    public void setTicketID(int id) {
        this.ticketid.set(id);
    }

    public void setCustomer(String value) {
        this.customer.set(value);
    }

    public void setPhoneNumber(String value) {
        this.phonenumber.set(value);
    }

    public void setMovieName(String value) {
        this.moviename.set(value);
    }

    public void setRoom(String value) {
        this.room.set(value);
    }

    public void setTimeSlot(String value) {
        this.timeslot.set(value);
    }

    public void setSeat(String value) {
        this.seat.set(value);
    }

    public void setPrice(int s) {
        s = 75000;
        this.price.set(s);
    }

    public void setNumberTicket(int s) {
        this.numberticket.set(s);
    }

    public void setTotalPrice(int t) {
        this.totalPrice.set(t);
    }

    public ObjectProperty<Integer> getTicketIDProperty() {
        return this.ticketid;
    }

    public StringProperty getCustomerProperty() {
        return this.customer;
    }

    public StringProperty getPhoneNumberProperty() {
        return this.phonenumber;
    }

    public StringProperty getMovieNameProperty() {
        return this.moviename;
    }

    public StringProperty getTimeSlotProperty() {
        return this.timeslot;
    }

    public StringProperty getRoomProperty() {
        return this.room;
    }

    public StringProperty getSeatProperty() {
        return this.seat;
    }

    public ObjectProperty<Integer> getPriceProperty() {
        return this.price;
    }

    public ObjectProperty<Integer> getNumberTicketProperty() {
        return this.numberticket;
    }

    public ObjectProperty<Integer> getTotalPriceProperty() {
        return this.totalPrice;
    }

    public static ObservableList<TicketDetail> selectAllTicketDetail() {
        ObservableList<TicketDetail> td
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ticketdetail");) {

            while (rs.next()) {
                TicketDetail m = new TicketDetail();
                int id = rs.getInt("ticketid");
                m.setTicketID(id);
                m.setCustomer(rs.getString("customer"));
                m.setPhoneNumber(rs.getString("phonenumber"));
                m.setMovieName(rs.getString("moviename"));
                m.setRoom(rs.getString("room"));
                m.setTimeSlot(rs.getString("timeslot"));
                m.setSeat(rs.getString("seat"));
                m.setPrice(rs.getInt("price"));
                m.setNumberTicket(rs.getInt("numberticket"));
                m.setTotalPrice(rs.getInt("price") * rs.getInt("numberticket"));

                td.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return td;
    }

    public static ObservableList<TicketDetail> selectAllTicketDetailOrdered(int s) {
        ObservableList<TicketDetail> td
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM ticketdetail ORDER BY ticketid DESC LIMIT " + s);) {

            while (rs.next()) {
                TicketDetail m = new TicketDetail();
                int id = rs.getInt("ticketid");
                m.setTicketID(id);
                m.setCustomer(rs.getString("customer"));
                m.setPhoneNumber(rs.getString("phonenumber"));
                m.setMovieName(rs.getString("moviename"));
                m.setRoom(rs.getString("room"));
                m.setTimeSlot(rs.getString("timeslot"));
                m.setSeat(rs.getString("seat"));
                m.setPrice(rs.getInt("price"));
                m.setNumberTicket(rs.getInt("numberticket"));
                m.setTotalPrice(rs.getInt("price") * rs.getInt("numberticket"));

                td.add(m);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return td;
    }
    
    public static TicketDetail insert(TicketDetail m) throws SQLException {
        String sql = "INSERT INTO `ticketdetail` ( customer, phonenumber, moviename, room, timeslot, seat, price, numberticket, totalprice )"
                + "VALUES ( ?, ? , ? , ?, ?, ? , ?, ?, ? )";

        ResultSet key = null;
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt
                = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            stmt.setString(1, m.getCustomer());
            stmt.setString(2, m.getPhoneNumber());
            stmt.setString(3, m.getMovieName());
            stmt.setString(4, m.getRoom());
            stmt.setString(5, m.getTimeSlot());
            stmt.setString(6, m.getSeat());
            stmt.setInt(7, m.getPrice());
            stmt.setInt(8, m.getNumberTicket());
            stmt.setInt(9, m.getTotalPrice());

            int rowInserted = stmt.executeUpdate();
            if (rowInserted == 1) {
                key = stmt.getGeneratedKeys();
                key.next();
                int newKey = key.getInt(1);
                m.setTicketID(newKey);
                return m;
            } else {
                System.err.println("No item inserted");
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

    public static boolean delete(TicketDetail m) throws SQLException {
        String sql = "DELETE FROM `ticketdetail` WHERE ticketid = ? ";

        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, m.getTicketID());

            int rowDeleted = stmt.executeUpdate();

            if (rowDeleted == 1) {
                return true;
            } else {
                System.err.println("No item deleted");
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean update(TicketDetail m) {
        String sql = "UPDATE ticketdetail SET "
                + "customer = ?, "
                + "phonenumber = ?, "
                + "moviename = ?, "
                + "room = ?, "
                + "timeslot = ?, "
                + "seat = ?, "
                + "price = ?, "
                + "numberticket = ?, "
                + "totalprice = ? "
                + "WHERE ticketid = ?";
        try (
                Connection conn = DbConection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, m.getCustomer());
            stmt.setString(2, m.getPhoneNumber());
            stmt.setString(3, m.getMovieName());
            stmt.setString(4, m.getRoom());
            stmt.setString(5, m.getTimeSlot());
            stmt.setString(6, m.getSeat());
            stmt.setInt(7, m.getPrice());
            stmt.setInt(8, m.getNumberTicket());
            stmt.setInt(9, m.getTotalPrice());
            stmt.setInt(10, m.getTicketID());
            
            int rowUpdated = stmt.executeUpdate();

            if (rowUpdated == 1) {
                return true;
            } else {
                System.err.println("No item updated");
                return false;
            }

        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
