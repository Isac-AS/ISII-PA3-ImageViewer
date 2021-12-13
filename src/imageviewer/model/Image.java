package imageviewer.model;

import java.io.InputStream;

public interface Image {
    String name();
    InputStream stream();
}