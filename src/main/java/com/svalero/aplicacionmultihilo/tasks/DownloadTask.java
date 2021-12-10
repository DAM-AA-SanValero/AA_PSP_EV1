package com.svalero.aplicacionmultihilo.tasks;

import javafx.concurrent.Task;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadTask extends Task<Integer> {

    private URL url;
    private File file;

    public DownloadTask(String url, File file) throws MalformedURLException {
        this.url = new URL(url);
        this.file = file;
    }


    @Override
    protected Integer call() throws Exception {
        //ENTENDER
        URLConnection urlConnection = url.openConnection();
        double fileSize = urlConnection.getContentLength();
        BufferedInputStream in = new BufferedInputStream(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        int totalRead = 0;
        double downloadProgress = 0;

        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            downloadProgress = (totalRead / fileSize);
            updateProgress(downloadProgress, 1);
            updateMessage(downloadProgress * 100 + " %");

            fileOutputStream.write(dataBuffer, 0, bytesRead);
            totalRead += bytesRead;
        }
        updateProgress(1, 1);
        updateMessage("100 %");


        return null;
    }
}
