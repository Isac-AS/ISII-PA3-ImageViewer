package imageviewer.view.persistence;

import imageviewer.model.Image;
import imageviewer.model.ProxyImage;
import java.io.*;

public class FileImageLoader implements ImageLoader {

    private final File[] files;
    private int current;

    public FileImageLoader(File folder) {
        this.current = 0;
        this.files = folder.listFiles(imageTypes());
    }

    private FileFilter imageTypes() {
        return (File pathname) -> pathname.getName().endsWith(".jpg");
    }

    @Override
    public Image load() {
        return new ProxyImage(this.files[this.current]);
    }

    @Override
    public Image next() {
        if (this.current == this.files.length -1) {
            this.current = 0;
        } else {
            this.current++;
        }
        return this.load();
    }

    @Override
    public Image prev() {
        if (this.current == 0) {
            this.current = this.files.length -1;
        } else {
            this.current--;
        }
        return this.load();
    }
}