package imageviewer.view.ui;

import imageviewer.model.Image;

public interface ImageDisplay {

    Image current();

    void show(Image image);
}
