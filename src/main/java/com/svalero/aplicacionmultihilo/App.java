package com.svalero.aplicacionmultihilo;

import com.svalero.aplicacionmultihilo.util.R;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getURL("downloader.fxml"));
        loader.setController(new AppController());
        VBox vBox = loader.load();

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Downloader");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
