package br.maua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Controller/pokeview.fxml"));
        primaryStage.setTitle("Pokedex");
        primaryStage.setScene(new Scene(root, 750, 527));
        primaryStage.show();
    }
}