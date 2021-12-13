package imageviewer.controller;

import imageviewer.view.persistence.ImageLoader;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import imageviewer.view.ui.ImageDisplay;
import imageviewer.view.ui.SwingImageDisplay;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;
    final ImageLoader imageLoader;

    public MainFrame(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1310, 1000);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.prev());
        };
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return (ActionEvent e) -> {
            imageDisplay.show(imageLoader.next());
        };
    }

    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
}