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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import movieticket.DbConnection.DbConection;

/**
 *
 * @author Pham Huu Duong
 */
public class Room {
        private ObjectProperty<Integer> roomid;
    public StringProperty roomname;

    public Room() {
        roomid = new SimpleObjectProperty<>(null);
        roomname = new SimpleStringProperty();
    }

    public Integer getRoomID() {
        return roomid.get();
    }

    public String getRoomName() {
        return roomname.get();
    }

    
    public void setRoomID(int id) {
        this.roomid.set(id);
    }

    public void setRoomName(String value) {
        this.roomname.set(value);
    }


    
    public ObjectProperty<Integer> getRoomIDProperty() {
        return this.roomid;
    }
    
    public StringProperty getRoomNameProperty(){
        return this.roomname;
    }
    

    
    public static ObservableList<Room> selectAllRoom() {
        ObservableList<Room> rooms
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM room");) {

            while (rs.next()) {
                Room s = new Room();
                s.setRoomID(rs.getInt("roomid"));
                s.setRoomName(rs.getString("roomname"));

                rooms.add(s);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rooms;
    }
    
        public static ObservableList<String> selectAllRoomName() {
        ObservableList<String> rooms
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT roomname FROM room");) {

            while (rs.next()) {

                rooms.add(rs.getString("roomname"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rooms;
    }
}
