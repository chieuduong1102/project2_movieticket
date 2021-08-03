/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import movieticket.Account.ViewerAccount;
import movieticket.Infrastructure.Room;
import movieticket.Infrastructure.Timeslot;
import movieticket.Movie.Movie;

public class OrderMovieController implements Initializable {

    private int idm;
    private String seatOrdered = "";
    TicketDetail to = new TicketDetail();

    @FXML
    private Label lbTitleMovie;

    @FXML
    private Label lbCustomerName;

    @FXML
    private ComboBox<String> cbTime;

    @FXML
    private ComboBox<String> cbRoom;

    @FXML
    private Label lbPhone;

    @FXML
    private TextField tfQuantity;

    @FXML
    private Pane paneSeat;

    @FXML
    private Button btnA1;

    @FXML
    private Button btnA2;

    @FXML
    private Button btnA3;

    @FXML
    private Button btnA4;

    @FXML
    private Button btnA5;

    @FXML
    private Button btnB1;

    @FXML
    private Button btnC1;

    @FXML
    private Button btnD1;

    @FXML
    private Button btnB2;

    @FXML
    private Button btnB3;

    @FXML
    private Button btnB4;

    @FXML
    private Button btnB5;

    @FXML
    private Button btnC2;

    @FXML
    private Button btnC3;

    @FXML
    private Button btnC4;

    @FXML
    private Button btnC5;

    @FXML
    private Button btnD2;

    @FXML
    private Button btnD3;

    @FXML
    private Button btnD4;

    @FXML
    private Button btnD5;

    @FXML
    private Button btnDatve;

    @FXML
    private TextField tfSeat;

    @FXML
    void btnA1Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnA1.getText() + ", ";
        btnA1.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnA2Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnA2.getText() + ", ";
        btnA2.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnA3Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnA3.getText() + ", ";
        btnA3.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnA4Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnA4.getText() + ", ";
        btnA4.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnA5Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnA5.getText() + ", ";
        btnA5.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnB1Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnB1.getText() + ", ";
        btnB1.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnB2Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnB2.getText() + ", ";
        btnB2.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnB3Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnB3.getText() + ", ";
        btnB3.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnB4Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnB4.getText() + ", ";
        btnB4.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnB5Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnB5.getText() + ", ";
        btnB5.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnC1Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnC1.getText() + ", ";
        btnC1.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnC2Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnC2.getText() + ", ";
        btnC2.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnC3Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnC3.getText() + ", ";
        btnC3.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnC4Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnC4.getText() + ", ";
        btnC4.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnC5Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnC5.getText() + ", ";
        btnC5.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnD1Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnD1.getText() + ", ";
        btnD1.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnD2Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnD2.getText() + ", ";
        btnD2.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnD3Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnD3.getText() + ", ";
        btnD3.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnD4Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnD4.getText() + ", ";
        btnD4.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    @FXML
    void btnD5Click(ActionEvent event) {
        seatOrdered = seatOrdered + btnD5.getText() + ", ";
        btnD5.setStyle("-fx-background-color: #32ff7e;");
        tfSeat.setText(seatOrdered);
    }

    public TicketDetail setValueOrderFromFeild() {
        TicketDetail t = new TicketDetail();

        t.setCustomer(lbCustomerName.getText());
        t.setPhoneNumber(lbPhone.getText());
        t.setMovieName(lbTitleMovie.getText());
        t.setRoom(cbRoom.getValue());
        t.setTimeSlot(cbTime.getValue());
        t.setSeat(tfSeat.getText());
        t.setPrice(75000);
        t.setNumberTicket(Integer.parseInt(tfQuantity.getText()));
        t.setPrice(75000 * Integer.parseInt(tfQuantity.getText()));

        return t;
    }

    @FXML
    void btnDatveClick(ActionEvent event) throws SQLException, IOException {
        to = setValueOrderFromFeild();
        to = TicketDetail.insert(to);
        int count = CountIndex.getCountValueDB() + 1;
        CountIndex.update(count);
        Navigator.getInstance().goToCart(to, count);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void initialize(int id, ViewerAccount accv) throws IOException, SQLException {
        Movie m = Movie.getMovieByID(id);

        lbTitleMovie.setText(m.getTitle());
        lbCustomerName.setText(accv.getFullnameV());
        lbPhone.setText(accv.getPhonenumberV());
//        System.out.println(accv.getFullnameV());

        ObservableList<String> rooms = Room.selectAllRoomName();
        cbRoom.setItems(rooms);
        cbRoom.setValue("Chọn phòng");
        ObservableList<String> timeslots = Timeslot.selectAllTime();
        cbTime.setItems(timeslots);
        cbTime.setValue("Chọn khung giờ");
    }

}
