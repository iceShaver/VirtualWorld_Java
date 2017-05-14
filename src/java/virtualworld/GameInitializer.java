package virtualworld;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by Kamil on 11.05.2017.
 */
public final class GameInitializer implements Serializable{
    public GameInitializer() {
    }

    public GameInitializer(int width, int height, AreaType areaType, JPanel worldRepresentationPanel) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = worldRepresentationPanel;
        reporter = null;
        this.mainWindow = null;
    }
    public GameInitializer(int width, int height, AreaType areaType) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = null;
        reporter = null;
        this.mainWindow = null;
    }

    public GameInitializer(int width, int height, AreaType areaType, JPanel worldRepresentationPanel, Reporter reporter) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = worldRepresentationPanel;
        this.reporter = reporter;
        this.mainWindow = null;
    }

    public GameInitializer(int width, int height, AreaType areaType, JPanel worldRepresentationPanel, Reporter reporter, JFrame mainWindow) {
        this.width = width;
        this.height = height;
        this.areaType = areaType;
        this.worldRepresentationPanel = worldRepresentationPanel;
        this.reporter = reporter;
        this.mainWindow = mainWindow;
    }

    public int width;
    public int height;
    public AreaType areaType;
    public JPanel worldRepresentationPanel;
    public Reporter reporter;
    public JFrame mainWindow;
}
