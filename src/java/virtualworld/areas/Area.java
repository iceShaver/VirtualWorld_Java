package virtualworld.areas;

import virtualworld.Dimension;
import virtualworld.Position;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Area implements Serializable{
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
    public abstract Position GetEmptyRandomPosition();
    public abstract Position GetEmptyRandomPosition(Position position, int range);
    public abstract Organism GetOrganism(Position position);
    public abstract Position GetRandomPosition(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode);

    public abstract Vector<Position> getAllNeighbourPositions(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode);


    public JPanel getWorldRepresentationPanel() {
        return worldRepresentationPanel;
    }

    public void setWorldRepresentationPanel(JPanel worldRepresentationPanel) {
        this.worldRepresentationPanel = worldRepresentationPanel;
    }

    public abstract void DrawFields();

    public abstract void pushOrganism(Organism organism);


    public abstract void deleteOrganism(Position position);
}
