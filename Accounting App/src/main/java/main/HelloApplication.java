package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class HelloApplication extends Application
{
    public static void main(String[] args)
    {
        Locale.setDefault (new Locale ("ar"));
        launch ();
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        mainWindow ();
    }

    private void mainWindow() throws IOException
    {
        Rectangle2D screenBounds = Screen.getPrimary ().getVisualBounds ();
        double stageWidth = screenBounds.getWidth () * 0.8; // 80% of screen width
        double stageHeight = screenBounds.getHeight () * 0.8; // 80% of screen height
        Stage stage1 = new Stage ();
        stage1.setTitle ("الواجهة الرئيسية");
        Parent mainwindow = FXMLLoader.load (getClass ().getResource ("main.fxml"));
        Scene root = new Scene (mainwindow, stageWidth, stageHeight);
        root.getStylesheets().add(getClass().getResource("/main/styles/Styles.css").toExternalForm());
        stage1.setScene (root);
        stage1.show ();
    }

}