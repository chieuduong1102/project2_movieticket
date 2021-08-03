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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import movieticket.Account.ViewerAccount;
import movieticket.Movie.Category;
import movieticket.Movie.Movie;

/**
 * FXML Controller class
 *
 * @author FPT SHOP
 */
public class HomeController implements Initializable {

    private ViewerAccount acc;

    @FXML
    private AnchorPane homeAnchorPane;
    
    @FXML
    private AnchorPane rootAnchorPane;
    
    @FXML
    private FlowPane flowPaneHome;

    @FXML
    private FlowPane flowPaneDC;

    @FXML
    private FlowPane flowPaneSC;

    @FXML
    private ComboBox<String> comboBoxCategory;

    @FXML
    private ComboBox<String> comboBoxNation;

    @FXML
    private Button btnLogOutHome;

    @FXML
    void btnLogOutHomeClick(ActionEvent event) throws IOException {
        Navigator.getInstance().goLogin();
    }

    public void showAllDatamovie() {

        ObservableList<Movie> movielist = Movie.selectAllMovieActived();
        FlowPane movieArea = new FlowPane();
        movieArea.setPadding(new Insets(15, 15, 15, 15));
        for (int i = 0; i < movielist.size(); i++) {
            AnchorPane hotMovie = new AnchorPane();
            Button detail = new Button();
            Text view = new Text();
            hotMovie.setPadding(new Insets(15, 15, 15, 15));
//              hotMovie.setSpacing(10);
            int id = movielist.get(i).getMovieID();
            detail.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        if (acc == null) {
                            Navigator.getInstance().goToDetail(id);
                        } else {
                            Navigator.getInstance().goToDetailWithAV(id, acc);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            ImageView iv = new ImageView();
            view.setText("     " + movielist.get(i).getViews().toString() + " lượt xem");
            iv = movielist.get(i).getCover();
            detail.setText("Chi Tiết");
            hotMovie.getChildren().add(iv);
            hotMovie.getChildren().add(detail);
            hotMovie.getChildren().add(view);
            movieArea.getChildren().add(hotMovie);
            detail.setLayoutY(160);
            detail.setLayoutX(15);
            detail.getStyleClass().add("btn-detail");
            detail.setStyle("-fx-font-weight: bold");
            view.setLayoutY(152);

        }

        flowPaneHome.getChildren().add(movieArea);
    }

    public void showAllDatamovieDC() {

        ObservableList<Movie> movielist = Movie.selectAllMovieDC();
        FlowPane movieArea = new FlowPane();
        movieArea.setPadding(new Insets(15, 15, 15, 15));
        for (int i = 0; i < movielist.size(); i++) {
            AnchorPane hotMovie = new AnchorPane();
            Button detail = new Button();
            Text view = new Text();
            view.setText("     " + movielist.get(i).getViews().toString() + " lượt xem");
            hotMovie.getChildren().add(view);
            view.setLayoutY(152);
            hotMovie.setPadding(new Insets(15, 15, 15, 15));
//              hotMovie.setSpacing(10);
            int id = movielist.get(i).getMovieID();
            detail.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        if (acc == null) {
                            Navigator.getInstance().goToDetail(id);
                        } else {
                            Navigator.getInstance().goToDetailWithAV(id, acc);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            ImageView iv = new ImageView();
            iv = movielist.get(i).getCover();
//            Label title = new Label();
            detail.setText("Chi Tiết");
//            title.setText(movielist.get(i).getTitle());
            hotMovie.getChildren().add(iv);
//            hotMovie.getChildren().add(title);
            hotMovie.getChildren().add(detail);
            movieArea.getChildren().add(hotMovie);
            detail.setLayoutY(160);
            detail.setLayoutX(15);
            detail.getStyleClass().add("btn-detail");
            detail.setStyle("-fx-font-weight: bold");
        }

        flowPaneDC.getChildren().add(movieArea);
    }

    public void showAllDatamovieSC() {

        ObservableList<Movie> movielist = Movie.selectAllMovieSC();
        FlowPane movieArea = new FlowPane();
        movieArea.setPadding(new Insets(15, 15, 15, 15));
        for (int i = 0; i < movielist.size(); i++) {
            AnchorPane hotMovie = new AnchorPane();
            Button detail = new Button();
            Text view = new Text();
//            view.setText("     " + movielist.get(i).getViews().toString() + " lượt xem");
            hotMovie.getChildren().add(view);
            view.setLayoutY(152);
            hotMovie.setPadding(new Insets(15, 15, 15, 15));
//              hotMovie.setSpacing(10);
            int id = movielist.get(i).getMovieID();
            detail.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    try {
                        if (acc == null) {
                            Navigator.getInstance().goToDetail(id);
                        } else {
                            Navigator.getInstance().goToDetailWithAV(id, acc);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });
            ImageView iv = new ImageView();
            iv = movielist.get(i).getCover();
//            Label title = new Label();
            detail.setText("Chi Tiết");
//            title.setText(movielist.get(i).getTitle());
            hotMovie.getChildren().add(iv);
//            hotMovie.getChildren().add(title);
            hotMovie.getChildren().add(detail);
            movieArea.getChildren().add(hotMovie);
            detail.setLayoutY(160);
            detail.setLayoutX(15);
            detail.getStyleClass().add("btn-detail");
            detail.setStyle("-fx-font-weight: bold");
        }

        flowPaneSC.getChildren().add(movieArea);
    }

    public void setValueComboBoxNation() {
        ObservableList<String> list = Movie.selectAllNationMovie();
        comboBoxNation.setItems(list);
        comboBoxNation.setValue("Quốc gia");
    }

    public void setValueComboBoxCategory() {
        ObservableList<String> list = Category.selectAllNameCategory();
        comboBoxCategory.setItems(list);
        comboBoxCategory.setValue("Thể Loại");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        showAllDatamovie();
        showAllDatamovieDC();
        showAllDatamovieSC();
        setValueComboBoxNation();
        setValueComboBoxCategory();
    }

    void initialize(ViewerAccount accv) {
        acc = accv;
        if (acc != null) {
            btnLogOutHome.setText("Xin chào: " + acc.getUsernameV());
        } else {
            btnLogOutHome.setText("Đăng nhập");
        }
        showAllDatamovie();
        showAllDatamovieDC();
        showAllDatamovieSC();
        setValueComboBoxNation();
        setValueComboBoxCategory();
//        System.out.println(accv.getUsernameV());
    }

}
