package virtualworld;

/**
 * Created by Kamil on 11.05.2017.
 */
public final class GameInitializer {
    public GameInitializer(int width, int height, AreaType areaType) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
    }

    public int width;
    public int height;
    public AreaType areaType;
}
