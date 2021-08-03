/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import movieticket.Account.AdminAccount;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import movieticket.Account.ViewerAccount;
import movieticket.DatamanagementController;

/**
 *
 * @author Pham Huu Duong
 */
public class Navigator {

    public static final String LOGIN_FXML = "login.fxml";
    public static final String HOME_FXML = "Home.fxml";
    public static final String DATA_FXML = "datamanagement.fxml";
    public static final String DETAIL_ADMIN_FXML = "detailadmin.fxml";
    public static final String REGIS_FXML = "Regis.fxml";
    public static final String DETAIL_FXML = "Detail.fxml";
    public static final String CART_FXML = "Cart.fxml";
    public static final String ORDER_FXML = "OrderMovie.fxml";
    

    private FXMLLoader loader;
    private Stage stage = null;

    private static Navigator nav = null;

    private Navigator() {

    }

    public static Navigator getInstance() {
        if (nav == null) {
            nav = new Navigator();
        }
        return nav;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    private void goPage(String fxml) throws IOException {
        this.loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
    }

    public void goLogin() throws IOException {
        this.goPage(LOGIN_FXML);
    }
    
    public void goRegis() throws IOException {
        this.goPage(REGIS_FXML);
    }

    public void goHome() throws IOException {
        this.goPage(HOME_FXML);
    }

    public void goDataManagement(AdminAccount aacc) throws IOException {
        this.goPage(DATA_FXML);
        DatamanagementController ctrl = loader.getController();
        ctrl.initialize(aacc);
    }

    public void goDetailAdmin(AdminAccount aacc) throws IOException {
        this.goPage(DETAIL_ADMIN_FXML);
        DatamanagementController ctrl = loader.getController();
        ctrl.initialize(aacc);
    }
    public void goToDetail( int a) throws IOException, SQLException{
        this.goPage(DETAIL_FXML);
        DetailController de = loader.getController();
        de.initialize(a);
    }
    
    public void goToCart(TicketDetail t, int count) throws IOException, SQLException {
        this.goPage(CART_FXML);
        CartController c = loader.getController();
        c.initialize(t, count);
    }
    
    public void goToOrder(int id, ViewerAccount accv) throws IOException, SQLException{
        this.goPage(ORDER_FXML);
        OrderMovieController o = loader.getController();
        o.initialize(id, accv);
    }

    void goHomeWithAV(ViewerAccount accv) throws IOException {
        this.goPage(HOME_FXML);
        HomeController h = loader.getController();
        h.initialize(accv);
    }

    void goToDetailWithAV(int id, ViewerAccount accv) throws IOException, SQLException {
        this.goPage(DETAIL_FXML);
        DetailController de = loader.getController();
        de.initialize(id, accv);
    }

    void goLoginWithIDMovie(int idm) throws IOException, SQLException {
        this.goPage(LOGIN_FXML);
        LoginController l = loader.getController();
        l.initialize(idm);
    }
    
    

}
