/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import movieticket.Account.StaffAccount;
import movieticket.Account.AdminAccount;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import static movieticket.Account.AdminAccount.getAdminAccount;
import movieticket.Account.ViewerAccount;
import static movieticket.Account.ViewerAccount.getViewerAccount;

/**
 * FXML Controller class
 *
 * @author Pham Huu Duong
 */
public class LoginController implements Initializable {

    private int id;
    private ViewerAccount acc;
    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lbMessage;

    @FXML
    void btnLoginClick(ActionEvent event) throws SQLException, IOException {
        String msg = "";
        AdminAccount ss = new AdminAccount();
        if (loginUsername.getText().length() > 0 && loginPassword.getText().length() > 0) {
            AdminAccount acca = new AdminAccount();
            acca = getAdminAccount(loginUsername.getText());

            ViewerAccount accv = new ViewerAccount();
            accv = getViewerAccount(loginUsername.getText());

            if (loginUsername.getText().equals(acca.getUsername())
                    && loginPassword.getText().equals(acca.getPassword())) {
                ss.setUsername(loginUsername.getText());
                ss.setPassword("");
                Navigator.getInstance().goDataManagement(ss);
//                Navigator.getInstance().goHome();
            } else if (loginUsername.getText().equals(accv.getUsernameV())
                    && loginPassword.getText().equals(accv.getPasswordV())) {
                accv.setUsernameV(loginUsername.getText());
                Navigator.getInstance().goHomeWithAV(accv);
            } else {
                msg = "Username or Password is NOT correct!";
                lbMessage.setText(msg);
            }
        } else {
            msg = "Username or Password must be NOT empty!";
            lbMessage.setText(msg);
        }
    }

    @FXML
    void clickGoToRegistration(ActionEvent event) throws IOException {
        Navigator.getInstance().goRegis();
    }

    /**
     * Initializes the controller class.
     */
    public void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void initialize(int idm) throws IOException {
        id = idm;
//        Navigator.getInstance().goRegis();
    }

}
