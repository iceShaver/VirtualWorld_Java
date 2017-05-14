package virtualworld;

import com.google.common.collect.TreeMultiset;
import javafx.geometry.Pos;
import oracle.jrockit.jfr.JFR;
import virtualworld.areas.Area;
import virtualworld.areas.HexagonalArea;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.areas.SquareArea;
import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.*;
import virtualworld.organisms.plants.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Created by Kamil on 11.05.2017.
 */
public class World implements Serializable {
    private Area area;
    private Reporter reporter;
    transient private VirtualWorld mainWindow;
    private Human human;
    public LinkedList<Organism> organismsToPush;
    public LinkedList<Organism> organismsToDelete;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public VirtualWorld getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(VirtualWorld mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public World(GameInitializer gameInitializer) {
        if (gameInitializer.areaType == AreaType.SQUARE)
            area = new SquareArea(gameInitializer.width, gameInitializer.height, gameInitializer.worldRepresentationPanel);
        else if (gameInitializer.areaType == AreaType.HEX)
            area = new HexagonalArea(gameInitializer.width, gameInitializer.height, gameInitializer.worldRepresentationPanel);
        organisms = TreeMultiset.create();
        organismsToDelete = new LinkedList<>();
        organismsToPush = new LinkedList<>();
        reporter = gameInitializer.reporter;
        mainWindow = (VirtualWorld) gameInitializer.mainWindow;
    }



    private TreeMultiset<Organism> organisms;

    public int GetWidth() {
        return area.getWidth();
    }

    public int GetHeight() {
        return area.getHeight();
    }

    public void safePushOrganism(Organism organism) {
        area.pushOrganism(organism);
        organismsToPush.add(organism);
    }

    public void safeDeleteOrganism(Organism organism) {
        area.deleteOrganism(organism.getPosition());
        organismsToDelete.add(organism);
    }

    public void PushOrganism(Organism organism) {
        organisms.add(organism);
        mainWindow.updateOrganismsList(organisms.toArray(new Organism[organisms.size()]));
        area.pushOrganism(organism);
    }

    public void DrawInterface(JPanel worldRepresentationPanel) {
        area.DrawFields();
    }

    public Organism[] getOrderedOrganisms() {
        return organisms.toArray(new Organism[organisms.size()]);
    }

    public void RandomizeOrganisms() {
        human = new Human(5, 0, 4, area.GetEmptyRandomPosition(), this);
        PushOrganism(human);
        PushOrganism(new Antelope(1, 1, 1, area.GetEmptyRandomPosition(), this));
        PushOrganism(new CyberSheep(11, 0, 4, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Fox(3, 0, 7, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Sheep(4, 0, 4, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Turtle(2, 0, 1, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Wolf(9, 0, 5, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Dandelion(0, 0, 0, area.GetEmptyRandomPosition(), this));
        PushOrganism(new DeadlyNightshade(99, 0, 0, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Grass(0, 0, 0, area.GetEmptyRandomPosition(), this));
        PushOrganism(new Guarana(0, 0, 0, area.GetEmptyRandomPosition(), this));
        PushOrganism(new HeracleumSosnowskyi(10, 0, 0, area.GetEmptyRandomPosition(), this));
    }

    public void newMessage(String message) {
        reporter.newMessage(message);
    }

    public void newMessage(String message, final Organism organism) {
        reporter.newMessage(message, organism);
    }

    public void newMessage(String message, final Organism organism, final Organism otherOrganism) {
        reporter.newMessage(message, organism, otherOrganism);
    }

    public void playRound() {

        for (Organism organism : organisms) {
            organism.Act();
        }
        if (organismsToDelete.size() != 0) {
            for (Organism organism : organismsToDelete) {
                deleteFromList(organism);
            }
            organismsToDelete.clear();
        }
        if (organismsToPush.size() != 0) {
            for (Organism toPush : organismsToPush) {
                pushToList(toPush);
            }
            organismsToPush.clear();
        }
        mainWindow.updateOrganismsList(organisms.toArray(new Organism[organisms.size()]));
    }


    private void deleteFromList(Organism organism) {
        //TODO: Check compare methods
        Iterator<Organism> iterator = organisms.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == organism)
                iterator.remove();
        }
        mainWindow.updateOrganismsList(organisms.toArray(new Organism[organisms.size()]));
    }


    public Position GetRandomPosition() {
        return area.GetRandomPosition();
    }

    public Position GetRandomPosition(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode) {
        return area.GetRandomPosition(position, range, neighbourPlaceSearchMode);
    }

    public Position GetEmptyRandomPosition() {
        return area.GetEmptyRandomPosition();
    }

    public Position GetEmptyRandomPosition(Position position, int range) {
        return area.GetEmptyRandomPosition(position, range);
    }

    public Position GetRandomNeighbourPosition(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode) {
        return area.GetRandomPosition(position, range, neighbourPlaceSearchMode);
    }

    public Vector<Position> GetAllNeighbourPositions(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode) {
        return area.getAllNeighbourPositions(position, range, neighbourPlaceSearchMode);
    }

    public Organism GetOrganism(Position position) {
        return area.GetOrganism(position);
    }


    public void moveOrganism(Organism organism, Position newPosition) {
        area.deleteOrganism(organism.getPosition());
        organism.setPosition(newPosition);
        area.pushOrganism(organism);
    }

    public void pushToArea(Organism organism) {
        area.pushOrganism(organism);
    }

    public void pushToList(Organism organism) {
        organisms.add(organism);
        mainWindow.updateOrganismsList(organisms.toArray(new Organism[organisms.size()]));
    }

    public void initializeAfterDeserialization(GameInitializer gameInitializer) {
        area.setWorldRepresentationPanel(gameInitializer.worldRepresentationPanel);
        mainWindow = (VirtualWorld) gameInitializer.mainWindow;
    }
}
