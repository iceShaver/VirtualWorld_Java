package virtualworld.areas;

import virtualworld.Dimension;
import virtualworld.Position;
import virtualworld.organisms.Organism;

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
    public Organism GetOrganism(Position position){
        return organisms[position.getX()][position.getY()];
    }
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    protected Dimension dimension;
    protected Organism[][] organisms;
}
