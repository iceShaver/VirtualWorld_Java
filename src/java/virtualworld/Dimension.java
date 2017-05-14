package virtualworld;

import java.io.Serializable;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Dimension implements Serializable{
    public Dimension() {
    }

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int width;
    private int height;
}
