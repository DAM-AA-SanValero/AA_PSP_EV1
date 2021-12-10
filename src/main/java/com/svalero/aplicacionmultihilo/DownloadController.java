package com.svalero.aplicacionmultihilo;

import com.svalero.aplicacionmultihilo.tasks.DownloadTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class DownloadController implements Initializable {

    private String textURL;
    private DownloadTask downloadTask;


    public TextField txtLink;
    public ProgressBar progressBar;
    public Label labelPercent;


    public DownloadController(String textURL) {
        this.textURL = textURL;
    }

    public void startDownload(ActionEvent event){
        try{
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(txtLink.getScene().getWindow());
            if(file==null) return;

            //INICIAR TAREA
            downloadTask = new DownloadTask(textURL, file);

            downloadTask.stateProperty().addListener((observableValue, oldState, newState) -> {
                if(newState == Worker.State.SUCCEEDED){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Descarga terminada");
                    alert.show();
                }
            });

            progressBar.progressProperty().unbind();
            progressBar.progressProperty().bind(downloadTask.progressProperty());

            downloadTask.messageProperty().addListener((observableValue, oldValue, newValue) -> labelPercent.setText(newValue));

            new Thread(downloadTask).start();
        } catch (MalformedURLException murle){
            murle.printStackTrace();
        }

    }

    public void stopDownload(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Descarga parada");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtLink.setText(textURL);
    }
}
