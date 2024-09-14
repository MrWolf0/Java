package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/* the controller for the sign-up process */
public class SignUpNewUser {
    public SignUpNewUser() throws IOException {
        Stage stage = new Stage();
        /*here we call the fxml file and put the layout in a scene */
        FXMLLoader fxmlLoader = new FXMLLoader(SignUpNewUser.class.getResource("SignUpNewUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),450,330);
        stage.setTitle("تسجيل مستخدم جديد");
        stage.setScene(scene);
        stage.show();
    }
}
