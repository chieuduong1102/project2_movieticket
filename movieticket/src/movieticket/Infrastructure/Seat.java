/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket.Infrastructure;

import movieticket.DbConnection.DbConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author GearVn
 */
public class Seat {

    private ObjectProperty<Integer> seatid;
    public StringProperty seatcode;
    public ObjectProperty<AnchorPane> seatAP;

    public Seat() {
        seatid = new SimpleObjectProperty<>(null);
        seatcode = new SimpleStringProperty();
        seatAP = new SimpleObjectProperty<>();
    }

    public Integer getSeatID() {
        return seatid.get();
    }

    public String getSeatCode() {
        return seatcode.get();
    }

    public AnchorPane getSearAP() {
        return seatAP.get();
    }

    public void setSeatID(int id) {
        this.seatid.set(id);
    }

    public void setSeatCode(String value) {
        this.seatcode.set(value);
    }

    public void setSeatAP(AnchorPane s) {
        this.seatAP.set(s);
    }

    public ObjectProperty<Integer> getSeatIDProperty() {
        return this.seatid;
    }

    public StringProperty getSeatCodeProperty() {
        return this.seatcode;
    }

    public ObjectProperty<AnchorPane> getSeatAPProperty() {
        return this.seatAP;
    }

    public static ObservableList<Seat> selectAllSeat() {
        ObservableList<Seat> seats
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM seat");) {

            while (rs.next()) {
                Seat s = new Seat();
                s.setSeatID(rs.getInt("seatid"));
                s.setSeatCode(rs.getString("seatcode"));

                AnchorPane seatAP = new AnchorPane();
                Text code = new Text(s.getSeatCode());
                seatAP.getChildren().add(code);

                seats.add(s);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return seats;
    }

    public static ObservableList<String> selectAllSeatCode() {
        ObservableList<String> rooms
                = FXCollections.observableArrayList();

        // database lay admin account 
        try (
                Connection conn = DbConection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT seatcode FROM seat");) {

            while (rs.next()) {

                rooms.add(rs.getString("seatcode"));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return rooms;
    }

}
