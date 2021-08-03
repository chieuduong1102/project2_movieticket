/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import movieticket.Account.ViewerAccount;
import movieticket.Movie.Movie;

/**
 * FXML Controller class
 *
 * @author Pham Huu Duong
 */
public class DetailController implements Initializable {

    private int idm;
    private ViewerAccount acc;
    @FXML
    private AnchorPane anchorPaneDetail;

    @FXML
    private Button btnDatVe;

    @FXML
    private Label lbTitleMovie;

    @FXML
    private Label lbDirectorMovie;

    @FXML
    private Label lbNationMovie;

    @FXML
    private Label lbYearMovie;

    @FXML
    private Label lbViewerMovie;

//    @FXML
//    private ImageView imvCover;
    @FXML
    private Button btnBackDT;

    @FXML
    void btnBackDTClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goHome();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initialize(int a) throws SQLException {
        Movie movie = Movie.getMovieByID(a);
        idm = a;
        lbTitleMovie.setText(movie.getTitle());
        lbDirectorMovie.setText(movie.getDirector());
        lbNationMovie.setText(movie.getNation());
        lbYearMovie.setText(movie.getYear());
        lbViewerMovie.setText(movie.getViews().toString());
        ImageView imv = movie.getCover();
        imv.setFitWidth(220);
        imv.setFitHeight(315);
        imv.setLayoutX(60);
        imv.setLayoutY(50);
        anchorPaneDetail.getChildren().add(imv);
    }

    void initialize(int id, ViewerAccount accv) throws SQLException {
        Movie movie = Movie.getMovieByID(id);
        idm = id;
        acc = accv;
        lbTitleMovie.setText(movie.getTitle());
//        lbDirectorMovie.setText(accv.getUsernameV());
        lbDirectorMovie.setText(movie.getDirector());
        lbNationMovie.setText(movie.getNation());
        lbYearMovie.setText(movie.getYear());
        lbViewerMovie.setText(movie.getViews().toString());
        ImageView imv = movie.getCover();
        imv.setFitWidth(220);
        imv.setFitHeight(315);
        imv.setLayoutX(60);
        imv.setLayoutY(50);
        anchorPaneDetail.getChildren().add(imv);
    }

    @FXML
    void btnDatVeClick(ActionEvent event) throws IOException, SQLException {
        if (acc == null) {
            Navigator.getInstance().goLogin();
        } else {
            Navigator.getInstance().goToOrder(idm, acc);
        }
    }
}
