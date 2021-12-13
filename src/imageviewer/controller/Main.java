package imageviewer.controller;

import java.io.File;
import imageviewer.model.Image;
import imageviewer.view.persistence.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        File file = new File(".");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame(imageLoader);
        mainFrame.getImageDisplay().show(image);
    }
}