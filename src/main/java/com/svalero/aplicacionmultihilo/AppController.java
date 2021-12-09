package com.svalero.aplicacionmultihilo;

import com.svalero.aplicacionmultihilo.util.R;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AppController {

    public TextField txtField;
    public TabPane tpDownloads;

    public AppController() {
    }

    public void launchDownload(ActionEvent event){
        String url = txtField.getText();
        txtField.clear();
        txtField.requestFocus();

        launchDownload(url);
    }

    public void launchDownload(String url){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(R.getURL("downloads.fxml"));

        DownloadController downloadController = new DownloadController(url);
        loader.setController(downloadController);
        VBox downloadBox = loader.load();

        String filename = url.substring(url.lastIndexOf("/") +1 );

        tpDownloads.getTabs().add(new Tab(filename, downloadBox));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelAllDownloads(ActionEvent event){

    }
}
