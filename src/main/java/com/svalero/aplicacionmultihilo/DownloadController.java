package com.svalero.aplicacionmultihilo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DownloadController implements Initializable {

    private String textURL;


    public TextField txtLink;
    public ProgressBar progressBar;
    public Label labelPercent;


    public DownloadController(String textURL) {
        this.textURL = textURL;
    }

    public void startDownload(ActionEvent event){

    }

    public void stopDownload(ActionEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtLink.setText(textURL);
    }
}
