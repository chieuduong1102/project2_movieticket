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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import movieticket.Account.ViewerAccount;

/**
 * FXML Controller class
 *
 * @author Pham Huu Duong
 */
public class RegisController implements Initializable {

    @FXML
    private TextField inputFullName;

    @FXML
    private TextField inputDob;

    @FXML
    private TextField inputUsername;

    @FXML
    private TextField inputPassword1;

    @FXML
    private TextField inputPassword2;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputPhoneNumber;

    @FXML
    private TextField inputAddress;

    @FXML
    private Button btnRegis;

    @FXML
    void btnRegisClick(ActionEvent event) throws SQLException, IOException {
        ViewerAccount insertViewerAccount = setValueViewerFromFeilds();
        insertViewerAccount = ViewerAccount.insert(insertViewerAccount);
        String text = "Congratulations on your successful registration! Login Now!";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Regis Successfully!");
        alert.setHeaderText(text);
        Optional<ButtonType> confirmationResponse = alert.showAndWait();
        if (confirmationResponse.get() == ButtonType.OK) {
            Navigator.getInstance().goLogin();
        }
    }

    @FXML
    void clickGoToLogin(ActionEvent event) throws IOException {
        Navigator.getInstance().goLogin();
    }

    private ViewerAccount setValueViewerFromFeilds() {
        ViewerAccount accv = new ViewerAccount();
        accv.setFullnameV(inputFullName.getText());
        accv.setDobV(inputDob.getText());
        accv.setUsernameV(inputUsername.getText());
        accv.setPasswordV(inputPassword1.getText());
        accv.setEmailV(inputEmail.getText());
        accv.setPhonenumberV(inputPhoneNumber.getText());
        accv.setAdderssV(inputAddress.getText());

        return accv;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
