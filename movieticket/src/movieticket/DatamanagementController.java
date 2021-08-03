/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticket;

import movieticket.DbConnection.DbConection;
import movieticket.Movie.Category;
import movieticket.Movie.MovieCategory;
import movieticket.Movie.Movie;
import movieticket.Account.StaffAccount;
import movieticket.Account.AdminAccount;
import movieticket.Account.ViewerAccount;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import movieticket.Infrastructure.Room;
import movieticket.Infrastructure.Seat;
import movieticket.Infrastructure.Timeslot;

/**
 * FXML Controller class
 *
 * @author Pham Huu Duong
 */
public class DatamanagementController implements Initializable {

    private AdminAccount aacc = null;

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField inputUsernameAdmin;

    @FXML
    private TextField inputPasswordAdmin;

    @FXML
    private Button btnSubmit;

    @FXML
    private TextField inputPasswordAdminAgain;

    @FXML
    private TextField inputStaffFullname;

    @FXML
    private TextField inputStafDob;

    @FXML
    private TextField inputStaffUsername;

    @FXML
    private TextField inputStaffPassword;

    @FXML
    private TextField inputStaffEmail;

    @FXML
    private TextField inputStaffPhonenumber;

    @FXML
    private TextField inputStaffAddress;

    @FXML
    private TableView<AdminAccount> tvAdmin;

    @FXML
    private TableColumn<AdminAccount, String> tcAdminUsername;

    @FXML
    private TableColumn<AdminAccount, String> tcAdminPassword;

    @FXML
    private TableView<StaffAccount> tvStaff;

    @FXML
    private TableColumn<StaffAccount, String> tcNameStaff;

    @FXML
    private TableColumn<StaffAccount, String> tcFullnameStaff;

    @FXML
    private TableColumn<StaffAccount, String> tcPhoneStaff;

    @FXML
    private TableView<ViewerAccount> tvViewer;

    @FXML
    private TableColumn<ViewerAccount, String> tcFullnameViewer;

    @FXML
    private TableColumn<ViewerAccount, String> tcUserNameViewer;

    @FXML
    private TableColumn<ViewerAccount, String> tcPhoneViewer;

    @FXML
    private TableView<Category> tvCategory;

    @FXML
    private TableColumn<Category, String> tcCategoryName;

    @FXML
    private TextField inputViewerFullname;

    @FXML
    private TextField inputViewerDob;

    @FXML
    private TextField inputViewerUsername;

    @FXML
    private TextField inputViewerPassword;

    @FXML
    private TextField inputViewerEmail;

    @FXML
    private TextField inputViewerPhonenumber;

    @FXML
    private TextField inputCategoryName;

    @FXML
    private TextField inputViewerAddress;

    @FXML
    private Button btnCreateViewer;

    @FXML
    private Button btnEditView;

    @FXML
    private Button btnDetailViewer;

    @FXML
    private Button btnDeleteViewer;

    @FXML
    private Label lbMessageViewer;

    @FXML
    private Button btnEditStaff;

    @FXML
    private Button btnDetailStaff;

    @FXML
    private Button btnDeleteStaff;

    @FXML
    private Button btnEditAdmin;

    @FXML
    private Button btnDetailAdmin;

    @FXML
    private Button btnDeleteAdmin;

    @FXML
    private Button btnCreateStaff;

    @FXML
    private Label lbMessage;

    @FXML
    private Label lbMessageStaff;

    @FXML
    private Button btnCreateNewCategoryname;

    @FXML
    private Button btnEditCategory;

    @FXML
    private Button btnDeleteCategoryName;

    @FXML
    private TableView<Movie> tvMovie;

    @FXML
    private TableColumn<Movie, String> tcTitle;

    @FXML
    private TableColumn<Movie, String> tcDirector;

    @FXML
    private TableColumn<Movie, String> tcNation;

    @FXML
    private TableColumn<Movie, String> tcYear;

    @FXML
    private TableColumn<Movie, Integer> tcViews;

    @FXML
    private TableColumn<Movie, String> tcStatus;

    @FXML
    private TableColumn<Movie, ImageView> tcCover;

    @FXML
    private TextField inputTitleMovie;

    @FXML
    private TextField inputDirectorMovie;

    @FXML
    private TextField inputNationMovie;

    @FXML
    private TextField inputYearMovie;

    @FXML
    private TextField inputViewsMovie;

    @FXML
    private ComboBox<String> comboBoxStatusMovie;

    @FXML
    private TextField inputCoverMovie;

    @FXML
    private Button btnChoosefileCover;

    @FXML
    private Button btnCreateMovie;

    @FXML
    private Button btnEditMovie;

    @FXML
    private Button btnDelleteMovie;

    @FXML
    private ComboBox<String> comboBoxMovie;

    @FXML
    private ComboBox<String> comboBoxCategory;

    @FXML
    private AnchorPane MovieCategoryArea;

    @FXML
    private Button btnSubmitCM;

    @FXML
    private TableView<MovieCategory> tvCategoryMovie;

    @FXML
    private TableColumn<MovieCategory, String> tcMovieMC;

    @FXML
    private TableColumn<MovieCategory, String> tcCategoryMC;

    @FXML
    private Button btnEditMC;

    @FXML
    private Button editDeleteMC;

    @FXML
    private Button btnLogout;

    @FXML
    private Label lbSessionusername;

    @FXML
    private AnchorPane seatAnchorPane;

    @FXML
    private AnchorPane homeAnchorPane;

    final int LENG_PER_LINE = 5;

    //Room
    @FXML
    private TableView<Room> tvRoom;

    @FXML
    private TableColumn<Room, String> tcRoomName;

    //Timeslot
    @FXML
    private TableView<Timeslot> tvTimeslot;

    @FXML
    private TableColumn<Timeslot, String> tcTimeslot;

    @FXML
    private TableView<TicketDetail> tvTicketDetail;

    @FXML
    private TableColumn<TicketDetail, String> tcCustomer;

    @FXML
    private TableColumn<TicketDetail, String> tcPhoneNumber;

    @FXML
    private TableColumn<TicketDetail, String> tcMovieNameTD;

    @FXML
    private TableColumn<TicketDetail, String> tcRoomTD;

    @FXML
    private TableColumn<TicketDetail, String> tcTimeSlotTD;

    @FXML
    private TableColumn<TicketDetail, String> tcSeatTD;

    @FXML
    private TableColumn<TicketDetail, Integer> tcPrice;

    @FXML
    private TableColumn<TicketDetail, Integer> tcQuantity;

    @FXML
    private TableColumn<TicketDetail, Integer> tcTotal;

    @FXML
    private TextField inputQuantityTD;

    @FXML
    private TextField inputSeatTD;

    @FXML
    private TextField inputCustomerTD;

    @FXML
    private TextField inputPhoneNumberTD;

    @FXML
    private Button btnEditTD;

    @FXML
    private Button btnDeleteTD;

    @FXML
    private Button btnSubmitTD;

    @FXML
    private ComboBox<String> comboBoxMovieNameTD;

    @FXML
    private ComboBox<String> comboBoxRoomTD;

    @FXML
    private ComboBox<String> comboBoxTimeSlotTD;

    //Admin
    @FXML
    void btnDeleteAdminClick(ActionEvent event) throws SQLException {
        AdminAccount acca = tvAdmin.getSelectionModel().getSelectedItem();

        if (acca == null) {
            warningNotSelect();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you sure you want to delete this account?");
            alert.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alert.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                AdminAccount deleteAccount = tvAdmin.getSelectionModel().getSelectedItem();
                boolean result = AdminAccount.delete(deleteAccount);

                if (result) {
                    tvAdmin.getItems().remove(deleteAccount); //update TableView
                    System.out.println("A Admin account is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnDetailAdminClick(ActionEvent event) throws IOException {
        AdminAccount acca = tvAdmin.getSelectionModel().getSelectedItem();
        if (acca == null) {
            warningNotSelect();
        } else {
//            inputUsernameAdmin.setText(acca.getUsername());
//            inputPasswordAdmin.setText(acca.getPassword());
//            btnSubmit.setText("");
//            btnSubmit.setDisable(true);
            alertDetailAdmin(acca);
        }

    }

    private void alertDetailAdmin(AdminAccount acca) {
        String text = "Fullname : " + acca.getUsername() + "\n" + "Password :" + acca.getPassword();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detail");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    @FXML
    void btnEditAdminClick(ActionEvent event) {
        AdminAccount acca = tvAdmin.getSelectionModel().getSelectedItem();
        if (acca == null) {
            warningNotSelect();
        } else {
            inputUsernameAdmin.setText(acca.getUsername());
            inputPasswordAdmin.setText(acca.getPassword());
            btnSubmit.setText("Submit");
        }

    }

    private AdminAccount setValueFromFeilds() {
        AdminAccount acc = new AdminAccount();
        acc.setUsername(inputUsernameAdmin.getText());
        acc.setPassword(inputPasswordAdmin.getText());
        return acc;
    }

    @FXML
    void btnSubmitAdminAccount(ActionEvent event) throws SQLException {
        AdminAccount selectedAdminAccount = tvAdmin.getSelectionModel().getSelectedItem();
        if (inputPasswordAdmin.getText().equals(inputPasswordAdminAgain.getText())) {
            if (selectedAdminAccount == null) {
                AdminAccount insertAdminAccount = setValueFromFeilds();
                insertAdminAccount = AdminAccount.insert(insertAdminAccount);
            } else {
                AdminAccount updateAdminAccount = setValueFromFeilds();
                updateAdminAccount.setAdminID(selectedAdminAccount.getAdminID());
                boolean result = AdminAccount.update(updateAdminAccount);
                if (result) {
                    lbMessage.setText("Updated Succesfully");
                    selectedAdminAccount = null;
                    btnSubmit.setText("Create New");

                } else {
                    lbMessage.setText("Updated Unsuccessfully");
                }
            }
            ShowDataTableView();
            resetInput();
            lbMessage.setText("");
        } else {
            String msg = "Password and Comfirm Password are not the same";
            lbMessage.setText(msg);
        }
    }

    private void ShowDataTableView() {
        ObservableList<AdminAccount> adList = AdminAccount.selectAllAdminAccount();
        tvAdmin.setItems(adList);

        tcAdminUsername.setCellValueFactory((ua) -> {
            return ua.getValue().getUsernameProperty();
        });

        tcAdminPassword.setCellValueFactory((pa) -> {
            return pa.getValue().getPasswordProperty();
        });

    }

    //Staff
    @FXML
    void btnDeleteStaffClick(ActionEvent event) throws SQLException {
        StaffAccount accs = tvStaff.getSelectionModel().getSelectedItem();

        if (accs == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.CONFIRMATION);
            alerts.setHeaderText("Are you sure you want to delete this account?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                StaffAccount deleteStaffAccount = tvStaff.getSelectionModel().getSelectedItem();
                boolean result = StaffAccount.delete(deleteStaffAccount);

                if (result) {
                    tvStaff.getItems().remove(deleteStaffAccount); //update TableView
                    System.out.println("A Staff account is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnCreateStaff(ActionEvent event) throws SQLException {
        StaffAccount selectedStaffAccount = tvStaff.getSelectionModel().getSelectedItem();
        if (selectedStaffAccount == null) {
            StaffAccount insertStaffAccount = setValueStaffFromFeilds();
            insertStaffAccount = StaffAccount.insert(insertStaffAccount);
        } else {
            StaffAccount updateStaffAccount = setValueStaffFromFeilds();
            updateStaffAccount.setStaffID(selectedStaffAccount.getStaffID());
            boolean result = StaffAccount.update(updateStaffAccount);
            if (result) {
                lbMessageStaff.setText("Updated Succesfully");
                selectedStaffAccount = null;
                btnCreateStaff.setText("Submit");
            } else {
                lbMessageStaff.setText("Updated Unsuccessfully");
            }
        }
        ShowDataTableStaff();
        resetInputStaff();
        //bo sung label bao' loi
    }

    @FXML
    void btnDetailStaffClick(ActionEvent event) {
        StaffAccount accs = tvStaff.getSelectionModel().getSelectedItem();
        if (accs == null) {
            warningNotSelect();
        } else {

//            inputStaffFullname.setText(accs.getFullname());
//            inputStafDob.setText(accs.getDob());
//            inputStaffUsername.setText(accs.getUsername());
//            inputStaffPassword.setText(accs.getPassword());
//            inputStaffEmail.setText(accs.getEmail());
//            inputStaffPhonenumber.setText(accs.getPhonenumber());
//            inputStaffAddress.setText(accs.getAdderss());
//            btnCreateStaff.setText("");
//            btnCreateStaff.setDisable(true);
            alertDetailStaff(accs);
        }
    }

    private void alertDetailStaff(StaffAccount accs) {
        String text = "Fullname : " + accs.getFullname() + "\n" + "Dob : " + accs.getDob()
                + "\nUsername : " + accs.getUsername() + "\n" + "Password : " + accs.getPassword()
                + "\nEmail : " + accs.getEmail() + "\n" + "Phone : " + accs.getPhonenumber()
                + "\nAdderss : " + accs.getAdderss();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detail");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    @FXML
    void btnEditStaffClick(ActionEvent event) {
        StaffAccount accs = tvStaff.getSelectionModel().getSelectedItem();
        if (accs == null) {
            warningNotSelect();
        } else {

            inputStaffFullname.setText(accs.getFullname());
            inputStafDob.setText(accs.getDob());
            inputStaffUsername.setText(accs.getUsername());
            inputStaffPassword.setText(accs.getPassword());
            inputStaffEmail.setText(accs.getEmail());
            inputStaffPhonenumber.setText(accs.getPhonenumber());
            inputStaffAddress.setText(accs.getAdderss());
            btnCreateStaff.setText("Submit");
        }
    }

    private void ShowDataTableStaff() {
        ObservableList<StaffAccount> sList = StaffAccount.selectAllStaffAccount();
        tvStaff.setItems(sList);
        tcNameStaff.setCellValueFactory((us) -> {
            return us.getValue().getUsernameProperty();
        });

        tcFullnameStaff.setCellValueFactory((ps) -> {
            return ps.getValue().getFullnameProperty();
        });

        tcPhoneStaff.setCellValueFactory((pn) -> {
            return pn.getValue().getPhoneProperty();
        });
    }

    private StaffAccount setValueStaffFromFeilds() {
        StaffAccount acc = new StaffAccount();
        acc.setFullname(inputStaffFullname.getText());
        acc.setDob(inputStafDob.getText());
        acc.setUsername(inputStaffUsername.getText());
        acc.setPassword(inputStaffPassword.getText());
        acc.setEmail(inputStaffEmail.getText());
        acc.setPhonenumber(inputStaffPhonenumber.getText());
        acc.setAdderss(inputStaffAddress.getText());

        return acc;

    }

//Viewer
    @FXML
    void btnCreateViewer(ActionEvent event) throws SQLException {
        ViewerAccount selectedViewerAccount = tvViewer.getSelectionModel().getSelectedItem();
        if (selectedViewerAccount == null) {
            ViewerAccount insertViewerAccount = setValueViewerFromFeilds();
            insertViewerAccount = ViewerAccount.insert(insertViewerAccount);
        } else {
            ViewerAccount updateViewerAccount = setValueViewerFromFeilds();
            updateViewerAccount.setViewerID(selectedViewerAccount.getViewID());
            boolean result = ViewerAccount.update(updateViewerAccount);
            if (result) {
                lbMessageStaff.setText("Updated Succesfully");
                selectedViewerAccount = null;
                btnCreateViewer.setText("Create New");
            } else {
                lbMessageStaff.setText("Updated Unsuccessfully");
            }
        }
        ShowDataTableViewer();
        resetInputViewer();
    }

    @FXML
    void btnDetailViewerClick(ActionEvent event) {
        ViewerAccount accs = tvViewer.getSelectionModel().getSelectedItem();
        if (accs == null) {
            warningNotSelect();
        } else {
            alertDetailViewer(accs);
        }
    }

    private void alertDetailViewer(ViewerAccount accs) {
        String text = "Fullname : " + accs.getFullnameV() + "\n" + "Dob : " + accs.getDobV()
                + "\nUsername : " + accs.getUsernameV() + "\n" + "Password : " + accs.getPasswordV()
                + "\nEmail : " + accs.getEmailV() + "\n" + "Phone : " + accs.getPhonenumberV()
                + "\nAdderss : " + accs.getAdderssV();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detail");
        alert.setHeaderText(text);
        alert.showAndWait();
    }

    @FXML
    void btnEditViewerClick(ActionEvent event) {
        ViewerAccount accs = tvViewer.getSelectionModel().getSelectedItem();
        if (accs == null) {
            warningNotSelect();
        } else {
            inputViewerFullname.setText(accs.getFullnameV());
            inputViewerDob.setText(accs.getDobV());
            inputViewerUsername.setText(accs.getUsernameV());
            inputViewerPassword.setText(accs.getPasswordV());
            inputViewerEmail.setText(accs.getEmailV());
            inputViewerPhonenumber.setText(accs.getPhonenumberV());
            inputViewerAddress.setText(accs.getAdderssV());
            btnCreateViewer.setText("Submit");
        }
    }

    private ViewerAccount setValueViewerFromFeilds() {
        ViewerAccount accv = new ViewerAccount();
        accv.setFullnameV(inputViewerFullname.getText());
        accv.setDobV(inputViewerDob.getText());
        accv.setUsernameV(inputViewerUsername.getText());
        accv.setPasswordV(inputViewerPassword.getText());
        accv.setEmailV(inputViewerEmail.getText());
        accv.setPhonenumberV(inputViewerPhonenumber.getText());
        accv.setAdderssV(inputViewerAddress.getText());

        return accv;
    }

    private void ShowDataTableViewer() {
        ObservableList<ViewerAccount> vList = ViewerAccount.selectAllViewAccount();
        tvViewer.setItems(vList);
        tcUserNameViewer.setCellValueFactory((us) -> {
            return us.getValue().getUsernameVProperty();
        });

        tcFullnameViewer.setCellValueFactory((ps) -> {
            return ps.getValue().getFullnameVProperty();
        });

        tcPhoneViewer.setCellValueFactory((pn) -> {
            return pn.getValue().getPhoneVProperty();
        });
    }

    @FXML
    void btnDeleteViewerClick(ActionEvent event) throws SQLException {
        ViewerAccount accv = tvViewer.getSelectionModel().getSelectedItem();

        if (accv == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.CONFIRMATION);
            alerts.setHeaderText("Are you sure you want to delete this account?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                ViewerAccount deleteViewerAccount = tvViewer.getSelectionModel().getSelectedItem();
                boolean result = ViewerAccount.delete(deleteViewerAccount);

                if (result) {
                    tvViewer.getItems().remove(deleteViewerAccount); //update TableView
                    System.out.println("A Viewer account is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    // category
    @FXML
    void btnDeleteCategoryName(ActionEvent event) throws SQLException {
        Category accv = tvCategory.getSelectionModel().getSelectedItem();

        if (accv == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.CONFIRMATION);
            alerts.setHeaderText("Are you sure you want to delete this category?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                Category deleteCategory = tvCategory.getSelectionModel().getSelectedItem();
                boolean result = Category.delete(deleteCategory);

                if (result) {
                    tvCategory.getItems().remove(deleteCategory); //update TableView
                    System.out.println("A Category is deleted");
                    setValueComboBoxMC();
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnCreateCategory(ActionEvent event) throws SQLException {
        Category selectedCategory = tvCategory.getSelectionModel().getSelectedItem();
        if (selectedCategory == null) {
            Category insertCategory = setValueCategoryFromFeilds();
            insertCategory = Category.insert(insertCategory);
            setValueComboBoxMC();
        } else {
            Category updateCategory = setValueCategoryFromFeilds();
            updateCategory.setCategoryID(selectedCategory.getCategoryID());
            boolean result = Category.update(updateCategory);
            if (result) {
                lbMessageStaff.setText("Updated Succesfully");
                selectedCategory = null;
                setValueComboBoxMC();
                btnCreateNewCategoryname.setText("Create New");
            } else {
                lbMessageStaff.setText("Updated Unsuccessfully");
            }
        }
        ShowDateTableCategory();
        resetInputCategory();
    }

    @FXML
    void btnEditCategoryClick(ActionEvent event) {
        Category accs = tvCategory.getSelectionModel().getSelectedItem();
        if (accs == null) {
            warningNotSelect();
        } else {
            inputCategoryName.setText(accs.getCategoryName());
            btnCreateNewCategoryname.setText("Submit");
        }
    }

    private void ShowDateTableCategory() {
        ObservableList<Category> cList = Category.selectAllCategory();
        tvCategory.setItems(cList);
        tcCategoryName.setCellValueFactory((ca) -> {
            return ca.getValue().getCategoryNameProperty();
        });
    }

    private Category setValueCategoryFromFeilds() {
        Category cat = new Category();
        cat.setCategoryName(inputCategoryName.getText());

        return cat;
    }

    //Movie
    private void ShowDataTableMovie() {
        ObservableList<Movie> mList = Movie.selectAllMovie();
        tvMovie.setItems(mList);
        tcTitle.setCellValueFactory((m) -> {
            return m.getValue().getTitleProperty();
        });

        tcDirector.setCellValueFactory((m) -> {
            return m.getValue().getDirectorProperty();
        });

        tcNation.setCellValueFactory((m) -> {
            return m.getValue().getNationProperty();
        });

        tcYear.setCellValueFactory((m) -> {
            return m.getValue().getYearProperty();
        });

        tcViews.setCellValueFactory((m) -> {
            return m.getValue().getViewsProperty();
        });

        tcStatus.setCellValueFactory((m) -> {
            return m.getValue().getStatusProperty();
        });

        tcCover.setCellValueFactory((m) -> {
            return m.getValue().getCoverProperty();
        });
    }

    @FXML
    void btnCreateMovieClick(ActionEvent event) throws SQLException {
        Movie selectedMovie = tvMovie.getSelectionModel().getSelectedItem();
        if (selectedMovie == null) {
            Movie insertMovie = setValueMovieFromFeilds();
            insertMovie = Movie.insert(insertMovie);
            setValueComboBoxMC();
            ShowDataTableMovie();
        } else {
            Movie updateMovie = setValueMovieFromFeilds();
            updateMovie.setMovieID(selectedMovie.getMovieID());
            boolean result = Movie.update(updateMovie);
            if (result) {
                lbMessageStaff.setText("Updated Succesfully");
                selectedMovie = null;
                setValueComboBoxMC();
                ShowDataTableMovie();
                btnCreateMovie.setText("Create New");
            } else {
                lbMessageStaff.setText("Updated Unsuccessfully");
            }
        }
        ShowDataTableMovie();
        resetInputMovie();
    }

    @FXML
    void btnEditMovieClick(ActionEvent event) {
        Movie m = tvMovie.getSelectionModel().getSelectedItem();
        if (m == null) {
            warningNotSelect();
        } else {
            inputTitleMovie.setText(m.getTitle());
            inputDirectorMovie.setText(m.getDirector());
            inputNationMovie.setText(m.getNation());
            inputYearMovie.setText(m.getYear());
            inputViewsMovie.setText(m.getViews().toString());
            comboBoxStatusMovie.setValue(m.getStatus());
            inputCoverMovie.setText("");
            btnCreateMovie.setText("Submit");
        }
    }

    @FXML
    void btnDeleteMovieClick(ActionEvent event) throws SQLException {
        Movie movie = tvMovie.getSelectionModel().getSelectedItem();

        if (movie == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setHeaderText("Are you sure you want to delete this movie?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                Movie deleteMovie = tvMovie.getSelectionModel().getSelectedItem();
                boolean result = Movie.delete(deleteMovie);

                if (result) {
                    tvMovie.getItems().remove(deleteMovie); //update TableView
                    setValueComboBoxMC();
                    System.out.println("A Movie is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnChoosefileCoverClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File");
//        fileChooser.setInitialDirectory(new File("D:\\Code\\Aptech\\movieticket\\src\\movieticket\\img"));
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*fpeg", "*.gif"),
                new ExtensionFilter("All Files", "*.*"));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        File seletedFile = fileChooser.showOpenDialog(stage);
        if (seletedFile != null) {
            String urlfile = seletedFile.getAbsolutePath().replace("\\", "&");
            inputCoverMovie.setText(urlfile.split("&")[9]);
        }
    }

    private Movie setValueMovieFromFeilds() {
        Movie m = new Movie();
        m.setTitle(inputTitleMovie.getText());
        m.setDirector(inputDirectorMovie.getText());
        m.setNation(inputNationMovie.getText());
        m.setYear(inputYearMovie.getText());
        m.setViews(Integer.parseInt(inputViewsMovie.getText()));
        m.setStatus(comboBoxStatusMovie.getValue());
        m.setCoverName(inputCoverMovie.getText());
        return m;
    }

    private void resetInputMovie() {
        inputTitleMovie.setText("");
        inputDirectorMovie.setText("");
        inputNationMovie.setText("");
        inputYearMovie.setText("");
        inputViewsMovie.setText("");
        comboBoxStatusMovie.setValue("Sắp chiếu");
        inputCoverMovie.setText("");
    }

    //MovieCategory
    @FXML
    void btnDeleteMCClick(ActionEvent event) throws SQLException {
        MovieCategory mcs = tvCategoryMovie.getSelectionModel().getSelectedItem();

        if (mcs == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setHeaderText("Are you sure you want to delete this item?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                MovieCategory deleteMC = tvCategoryMovie.getSelectionModel().getSelectedItem();
                deleteMC.setMCID(selectMCIDfromData(selectIDfromTitleMovie(deleteMC.getTitleMovie()), selectIDfromNameCategory(deleteMC.getNameCategory())));
                boolean result = MovieCategory.delete(deleteMC);

                if (result) {
                    tvCategoryMovie.getItems().remove(deleteMC); //update TableView
                    System.out.println("An item is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnEditMCClick(ActionEvent event) throws SQLException {
        MovieCategory m = tvCategoryMovie.getSelectionModel().getSelectedItem();
        if (m == null) {
            warningNotSelect();
        } else {
            comboBoxMovie.setValue(m.getTitleMovie());
            comboBoxCategory.setValue(m.getNameCategory());
            btnSubmitCM.setText("Submit");
        }
    }

    @FXML
    private Label lbtest;

    @FXML
    void btnSubmitCMClick(ActionEvent event) throws SQLException {

        MovieCategory selectedMovieCategory = tvCategoryMovie.getSelectionModel().getSelectedItem();

        if (selectedMovieCategory == null) {
            MovieCategory mc = setValueMovieCategoryFromFeild();
            mc = MovieCategory.insert(mc);
            showDataTableMovieCategory();
        } else {
            MovieCategory updateMovieCategory = new MovieCategory();
            updateMovieCategory.setMCID(selectMCIDfromData(selectIDfromTitleMovie(selectedMovieCategory.getTitleMovie()), selectIDfromNameCategory(selectedMovieCategory.getNameCategory())));
            updateMovieCategory.setMovieIDMC(selectIDfromTitleMovie(comboBoxMovie.getValue()));
            updateMovieCategory.setCatetoryIDMC(selectIDfromNameCategory(comboBoxCategory.getValue()));
            updateMovieCategory.setTitleMovie(comboBoxMovie.getValue());
            updateMovieCategory.setNameCategory(comboBoxCategory.getValue());
            boolean result = MovieCategory.update(updateMovieCategory);
            if (result) {
//                lbMessageStaff.setText("Updated Succesfully");
                showDataTableMovieCategory();
                selectedMovieCategory = null;
            } else {
//                lbMessageStaff.setText("Updated Unsuccessfully");
            }
        }

    }

    private void showDataTableMovieCategory() {
        ObservableList<MovieCategory> list = MovieCategory.selectAllCategoryMovie();
        tvCategoryMovie.setItems(list);

        tcMovieMC.setCellValueFactory((mmc) -> {
            return mmc.getValue().getTitleMovieProperty();
        });

        tcCategoryMC.setCellValueFactory((cmc) -> {
            return cmc.getValue().getNameCategoryProperty();
        });
    }

    private MovieCategory setValueMovieCategoryFromFeild() throws SQLException {
        MovieCategory mc = new MovieCategory();
        String valueTitle = comboBoxMovie.getValue();
        String valueCategory = comboBoxCategory.getValue();

        mc.setMovieIDMC(selectIDfromTitleMovie(valueTitle));
        mc.setCatetoryIDMC(selectIDfromNameCategory(valueCategory));
        return mc;
    }

    private void warningNotSelect() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Please select a account");
        alert.setHeaderText("A item must be selected for the operation");
        alert.showAndWait();
    }

    private void resetInput() {
        inputUsernameAdmin.setText("");
        inputPasswordAdmin.setText("");
        inputPasswordAdminAgain.setText("");
        btnSubmit.setText("Create new");
    }

    private void resetInputStaff() {
        inputStaffFullname.setText("");
        inputStafDob.setText("");
        inputStaffUsername.setText("");
        inputStaffPassword.setText("");
        inputStaffEmail.setText("");
        inputStaffPhonenumber.setText("");
        inputStaffAddress.setText("");
    }

    private void resetInputViewer() {
        inputViewerFullname.setText("");
        inputViewerDob.setText("");
        inputViewerUsername.setText("");
        inputViewerPassword.setText("");
        inputViewerEmail.setText("");
        inputViewerPhonenumber.setText("");
        inputViewerAddress.setText("");
    }

    private void resetInputCategory() {
        inputCategoryName.setText("");

    }

    public static Integer selectIDfromTitleMovie(String value) throws SQLException {
        int id = 0;
        Connection conn = DbConection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT movieid FROM movie WHERE title = '" + value + "'");

        while (rs.next()) {
            id = rs.getInt("movieid");
        }
        return id;
    }

    public static Integer selectIDfromNameCategory(String value) throws SQLException {
        int id = 0;
        Connection conn = DbConection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT categoryid FROM category WHERE categoryname = '" + value + "'");

        while (rs.next()) {
            id = rs.getInt("categoryid");
        }
        return id;
    }

    public static Integer selectMCIDfromData(int value1, int value2) throws SQLException {
        int id = 0;
        Connection conn = DbConection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT mcid FROM moviecategory  "
                + "WHERE movieid =  " + value1 + "  AND categoryid =  " + value2 + " ");

        while (rs.next()) {
            id = rs.getInt("mcid");
        }
        return id;
    }

    public void setValueComboBoxMC() {
        ObservableList<String> listMovie = Movie.selectAllTitleMovie();
        ObservableList<String> listCategory = Category.selectAllNameCategory();
        comboBoxMovie.setItems(listMovie);
        comboBoxCategory.setItems(listCategory);
        comboBoxMovie.setValue(listMovie.get(0));
        comboBoxCategory.setValue(listCategory.get(0));
    }

    public void showAllDataSeat() {
        ObservableList<Seat> seatlist = Seat.selectAllSeat();
        FlowPane seatArea = new FlowPane();
        seatArea.setPadding(new Insets(15, 15, 15, 15));

        for (int i = 0, z = 0; i < seatlist.size(); z += 20) {
            HBox seatRow = new HBox();
            seatRow.setPadding(new Insets(15, 15, 15, 15));
            seatRow.setSpacing(15);
            for (int j = 0; j < this.LENG_PER_LINE; j++, i++) {
                Button seat = new Button();
                seat.setText(seatlist.get(i).getSeatCode());
                seat.setPadding(new Insets(15, 15, 15, 15));
                seatRow.getChildren().add(seat);
            }
            seatArea.getChildren().add(seatRow);
        }

        seatAnchorPane.getChildren().add(seatArea);

    }

//    Room
    public void ShowAllRoom() {
        ObservableList<Room> roomlist = Room.selectAllRoom();

        tvRoom.setItems(roomlist);
        tcRoomName.setCellValueFactory((r) -> {
            return r.getValue().getRoomNameProperty();
        });
    }

    //Timeslot
    public void ShowAllTineslot() {
        ObservableList<Timeslot> tllist = Timeslot.selectAllTimeslot();

        tvTimeslot.setItems(tllist);
        tcTimeslot.setCellValueFactory((r) -> {
            return r.getValue().getTimeSlotProperty();
        });
    }

    @FXML
    void btnLogOutClick(ActionEvent event) throws IOException {
        lbSessionusername.setText(null);
        Navigator.getInstance().goLogin();
    }

    //TicketDetail
    //Datamanagement -> TickDetail -> Seat (combox -> text Feil) 
    // bổ sung thêm các trường còn thiếu trong scene (customer, phone number, price, quantity, total)
    //import @FXML các trường vừa sửa.
    //Seat -> Controllner :chú ý
    //cập nhật lại các function
    //TicketDetail -> bổ sung các cùng query + get ; set;
    @FXML
    void btnDeleteTDClick(ActionEvent event) throws SQLException {
        TicketDetail t = tvTicketDetail.getSelectionModel().getSelectedItem();

        if (t == null) {
            warningNotSelect();
        } else {
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setHeaderText("Are you sure you want to delete this movie?");
            alerts.setTitle("Delete");
            Optional<ButtonType> confirmationResponse = alerts.showAndWait();
            if (confirmationResponse.get() == ButtonType.OK) {
                TicketDetail dt = tvTicketDetail.getSelectionModel().getSelectedItem();
                boolean result = TicketDetail.delete(dt);

                if (result) {
                    tvMovie.getItems().remove(dt); //update TableView
                    ShowDataTableTD();
                    System.out.println("A item is deleted");
                } else {
                    System.err.println("No one deleted");
                }
            }
        }
    }

    @FXML
    void btnEditTDClick(ActionEvent event) {
        TicketDetail m = tvTicketDetail.getSelectionModel().getSelectedItem();
        if (m == null) {
            warningNotSelect();
        } else {
            inputCustomerTD.setText(m.getCustomer());
            inputPhoneNumberTD.setText(m.getPhoneNumber());
            comboBoxMovieNameTD.setValue(m.getMovieName());
            comboBoxRoomTD.setValue(m.getRoom());
            comboBoxTimeSlotTD.setValue(m.getTimeSlot());
            inputSeatTD.setText(m.getSeat());
            inputQuantityTD.setText(m.getNumberTicket().toString());
            btnSubmitTD.setText("Submit");

        }
    }

    @FXML
    void btnSubmitTDClick(ActionEvent event) throws SQLException {
        TicketDetail t = tvTicketDetail.getSelectionModel().getSelectedItem();
        if (t == null) {
            TicketDetail it = setValueDTFromFeilds();
            it = TicketDetail.insert(it);
            ShowDataTableTD();
        } else {
            TicketDetail ut = setValueDTFromFeilds();
            ut.setTicketID(t.getTicketID());
            boolean result = TicketDetail.update(ut);
            if (result) {
                lbMessage.setText("Updated Succesfully");
                t = null;
                ResetValueDTFeilds();
                ShowDataTableTD();
                btnSubmitTD.setText("Create New");
            } else {
                lbMessage.setText("Updated Unsuccessfully");
            }
        }
        resetInput();
        lbMessage.setText("");

    }

    public TicketDetail setValueDTFromFeilds() {
        TicketDetail t = new TicketDetail();
        t.setCustomer(inputCustomerTD.getText());
        t.setPhoneNumber(inputPhoneNumberTD.getText());
        t.setMovieName(comboBoxMovieNameTD.getValue());
        t.setRoom(comboBoxRoomTD.getValue());
        t.setTimeSlot(comboBoxTimeSlotTD.getValue());
        t.setSeat(inputSeatTD.getText());
        t.setPrice(75000);
        t.setNumberTicket(Integer.parseInt(inputQuantityTD.getText()));
        t.setTotalPrice(75000 * Integer.parseInt(inputQuantityTD.getText()));

        return t;
    }

    public void ResetValueDTFeilds() {
        ObservableList<String> listM = Movie.selectAllTitleMovieActived();
        ObservableList<String> listR = Room.selectAllRoomName();
        ObservableList<String> listTS = Timeslot.selectAllTime();
        inputCustomerTD.setText("");
        inputPhoneNumberTD.setText("");
        comboBoxMovieNameTD.setValue(listM.get(0));
        comboBoxRoomTD.setValue(listR.get(0));
        comboBoxTimeSlotTD.setValue(listTS.get(0));
        inputSeatTD.setText("");
        inputQuantityTD.setText("");
    }

    public void setValueComboBoxTD() {
        ObservableList<String> listM = Movie.selectAllTitleMovieActived();
        comboBoxMovieNameTD.setItems(listM);
        comboBoxMovieNameTD.setValue(listM.get(0));

        ObservableList<String> listR = Room.selectAllRoomName();
        comboBoxRoomTD.setItems(listR);
        comboBoxRoomTD.setValue(listR.get(0));

        ObservableList<String> listTS = Timeslot.selectAllTime();
        comboBoxTimeSlotTD.setItems(listTS);
        comboBoxTimeSlotTD.setValue(listTS.get(0));

    }

    private void ShowDataTableTD() {
        ObservableList<TicketDetail> list = TicketDetail.selectAllTicketDetail();
        tvTicketDetail.setItems(list);
        tcCustomer.setCellValueFactory((us) -> {
            return us.getValue().getCustomerProperty();
        });
        tcPhoneNumber.setCellValueFactory((us) -> {
            return us.getValue().getPhoneNumberProperty();
        });
        tcMovieNameTD.setCellValueFactory((us) -> {
            return us.getValue().getMovieNameProperty();
        });

        tcRoomTD.setCellValueFactory((us) -> {
            return us.getValue().getRoomProperty();
        });

        tcTimeSlotTD.setCellValueFactory((ps) -> {
            return ps.getValue().getTimeSlotProperty();
        });

        tcSeatTD.setCellValueFactory((pn) -> {
            return pn.getValue().getSeatProperty();
        });

        tcPrice.setCellValueFactory((pn) -> {
            return pn.getValue().getPriceProperty();
        });

        tcQuantity.setCellValueFactory((pn) -> {
            return pn.getValue().getNumberTicketProperty();
        });

        tcTotal.setCellValueFactory((pn) -> {
            return pn.getValue().getTotalPriceProperty();
        });
    }
//    initialize

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO: code here

    }

    public void initialize(AdminAccount aacc) {
        this.aacc = aacc;
        lbSessionusername.setText(aacc.getUsername());
        ObservableList<String> listStatus = FXCollections.observableArrayList("Sắp chiếu", "Đang chiếu", "Đã ngừng chiếu");
        comboBoxStatusMovie.setItems(listStatus);
        comboBoxStatusMovie.setValue("Sắp chiếu");
        setValueComboBoxMC();
        ShowDataTableView();
        ShowDataTableStaff();
        ShowDataTableViewer();
        ShowDateTableCategory();
        ShowDataTableMovie();
        showDataTableMovieCategory();
        showAllDataSeat();
        ShowAllRoom();
        ShowAllTineslot();
        setValueComboBoxTD();
        ShowDataTableTD();

    }

}
