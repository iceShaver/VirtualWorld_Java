package virtualworld.areas;

import virtualworld.Dimension;
import virtualworld.Position;
import virtualworld.organisms.Organism;

import javax.swing.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Area {
    public Area(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected int width;
    protected int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract Position GetRandomPosition();
    public abstract Position GetRandomPosition(Position position, int range);
    public abstract Position GetEmptyRandomPosition();
    public abstract Position GetEmptyRandomPosition(Position position, int range);
    public abstract Organism GetOrganism(Position position);
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    protected Dimension dimension;


    public abstract void DrawFields(JPanel worldRepresentationPanel);

    public abstract void pushOrganism(Organism organism);
}
