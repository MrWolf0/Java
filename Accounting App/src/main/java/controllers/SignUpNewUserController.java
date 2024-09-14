package controllers;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import main.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AccountData;

import java.io.IOException;

public class SignUpNewUserController {
    DatabaseConnection databaseConnection = new DatabaseConnection ();
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private Button saveBtn;
    private Stage stage;


    public void initialize() {
        handleEvent();
    }
    public void setStage(Stage stage) {
        this.stage = stage; // Setter to inject the stage reference
    }

    protected void handleEvent() {
        saveBtn.setOnAction(event -> {

            stage.close();

            // Open the main window stage
            try {
                mainWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private void mainWindow() throws IOException
    {
        Stage stage1 = new Stage();
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double stageWidth = screenBounds.getWidth() * 0.8; // 80% of screen width
        double stageHeight = screenBounds.getHeight() * 0.8; // 80% of screen height
        stage1.setTitle("الواجهة الرئيسية");
        Parent mainwindow = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage1.setScene(new Scene (mainwindow,stageWidth,stageHeight));
        stage1.show();
    }

}
