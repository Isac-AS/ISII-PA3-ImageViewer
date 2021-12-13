package imageviewer.controller;

import java.io.File;
import imageviewer.model.Image;
import imageviewer.view.persistence.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Isac\\OneDrive - Universidad de Las Palmas de Gran Canaria\\Tercero\\40975 - ISII\\IS2 - Practicas\\NetBeansProjects\\ImageViewer");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
