package com.example.procssmart.View;

import com.example.procssmart.Model.Money;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(MainView.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
