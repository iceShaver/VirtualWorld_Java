package virtualworld;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Position implements Cloneable{
    public Position() {}

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    private int x;
    private int y;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
