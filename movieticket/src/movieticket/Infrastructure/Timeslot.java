/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket.Infrastructure;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class Timeslot {
    private ObjectProperty<Integer> timeid;
    public StringProperty time;

    public Timeslot() {
        timeid = new SimpleObjectProperty<>(null);
        time = new SimpleStringProperty();
    }

    public Integer getTimeID() {
        return timeid.get();
    }

    public String getTimeSlot() {
        return time.get();
    }

    
    public void setTimeID(int id) {
        this.timeid.set(id);
    }

    public void setTimeSlot(String value) {
        this.time.set(value);
    }


    
    public ObjectProperty<Integer> getTimeIDProperty() {
        return this.timeid;
    }
    
    public StringProperty getTimeSlotProperty(){
        return this.time;
    }
    

    
    public static ObservableList<Timeslot> selectAllTimeslot() {
        ObservableList<Timeslot> times
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM timeslot");) {

            while (rs.next()) {
                Timeslot s = new Timeslot();
                s.setTimeID(rs.getInt("timeid"));
                s.setTimeSlot(rs.getString("time"));

                times.add(s);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return times;
    }
    
    public static ObservableList<String> selectAllTime() {
        ObservableList<String> rooms
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT `time` FROM timeslot");) {

            while (rs.next()) {

                rooms.add(rs.getString("time"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rooms;
    }
}

