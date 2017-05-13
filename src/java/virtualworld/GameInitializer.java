package virtualworld;

import javax.swing.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public final class GameInitializer {
    public GameInitializer(int width, int height, AreaType areaType, JPanel worldRepresentationPanel) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = worldRepresentationPanel;
    }
    public GameInitializer(int width, int height, AreaType areaType) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = null;
    }

    public int width;
    public int height;
    public AreaType areaType;
    public JPanel worldRepresentationPanel;
}
