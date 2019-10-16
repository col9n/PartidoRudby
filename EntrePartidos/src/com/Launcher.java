package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    public void start(Stage stage ) throws IOException {
       // Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        stage.setTitle("Pantalla principal");
        stage.setScene(new Scene(root,300,300));
        stage.show();
    }

    public static void main(String[] args){
        launch(args);

    }
}
