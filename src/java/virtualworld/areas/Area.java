package virtualworld.areas;

import virtualworld.Dimension;
import virtualworld.Position;
import virtualworld.organisms.Organism;

import javax.swing.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Area {
    public Area(int width, int height, JPanel worldRepresentationPanel) {
        this.width = width;
        this.height = height;
        this.worldRepresentationPanel = worldRepresentationPanel;

    }

    protected int width;
    protected int height;
    protected JPanel worldRepresentationPanel;
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




    public abstract void DrawFields();

    public abstract void pushOrganism(Organism organism);


}
