/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import movieticket.Account.ViewerAccount;

/**
 * FXML Controller class
 *
 * @author FPT SHOP
 */
public class CartController implements Initializable {

    ViewerAccount acc = new ViewerAccount();
    TicketDetail td = new TicketDetail();

    private int index = 0;
    
    
    @FXML
    private TableView<TicketDetail> tvProduct;

    @FXML
    private TableColumn<TicketDetail, String> tcNameProduct;

    @FXML
    private TableColumn<TicketDetail, String> tcRoom;

    @FXML
    private TableColumn<TicketDetail, String> tcTimeslot;

    @FXML
    private TableColumn<TicketDetail, Integer> tcPriceProduct;

    @FXML
    private TableColumn<TicketDetail, Integer> tcAmountProduct;

    @FXML
    private TableColumn<TicketDetail, Integer> tcMoneyProduct;

    @FXML
    private TableColumn<TicketDetail, String> tcSeat;

    @FXML
    private Button btnBuyMovie;

    @FXML
    private Button btnPayProduct;

    @FXML
    private TextField tfCustomer;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfNumberCart;

    @FXML
    private TextField tfSeat;

    @FXML
    private ComboBox<String> cbRoom;

    @FXML
    private ComboBox<String> cbTime;

    @FXML
    private Label lbMovieName;

    @FXML
    void btnBuyMovieClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goHomeWithAV(acc);
        System.out.println(acc.getUsernameV());
    }

    @FXML
    void btnPayProductClick(ActionEvent event) throws IOException, SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Order Succesfull");
        alert.setTitle("Notify");
        Optional<ButtonType> confirmationResponse = alert.showAndWait();
        if (confirmationResponse.get() == ButtonType.OK) {
//            td = TicketDetail.insert(td);
            CountIndex.update(0);
            Navigator.getInstance().goHomeWithAV(acc);
        } else {
            
        }
    }

    public void showDataTable(ObservableList<TicketDetail> list) {
        tvProduct.setItems(list);
        tcNameProduct.setCellValueFactory((us) -> {
            return us.getValue().getMovieNameProperty();
        });

        tcRoom.setCellValueFactory((us) -> {
            return us.getValue().getRoomProperty();
        });

        tcTimeslot.setCellValueFactory((ps) -> {
            return ps.getValue().getTimeSlotProperty();
        });

        tcSeat.setCellValueFactory((pn) -> {
            return pn.getValue().getSeatProperty();
        });

        tcPriceProduct.setCellValueFactory((pn) -> {
            return pn.getValue().getPriceProperty();
        });

        tcAmountProduct.setCellValueFactory((pn) -> {
            return pn.getValue().getNumberTicketProperty();
        });

        tcMoneyProduct.setCellValueFactory((pn) -> {
            return pn.getValue().getTotalPriceProperty();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    void initialize(TicketDetail t, int count) throws SQLException {
        index = index + count;
        ObservableList<TicketDetail> list = TicketDetail.selectAllTicketDetailOrdered(index);
        acc = ViewerAccount.getViewerAccountbyFullName(t.getCustomer());
        td = t;
        showDataTable(list);
    }

}
