package virtualworld;
import com.google.common.collect.TreeMultiset;
import javafx.geometry.Pos;
import virtualworld.areas.Area;
import virtualworld.areas.HexagonalArea;
import virtualworld.areas.SquareArea;
import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.*;
import virtualworld.organisms.plants.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public class World {
    private Area area;
    public World(GameInitializer gameInitializer) {
        if(gameInitializer.areaType == AreaType.SQUARE) area = new SquareArea(gameInitializer.width, gameInitializer.height,gameInitializer.worldRepresentationPanel);
        else if(gameInitializer.areaType==AreaType.HEX) area = new HexagonalArea(gameInitializer.width, gameInitializer.height, gameInitializer.worldRepresentationPanel);
        organisms = TreeMultiset.create();
    }

    public void Collide(Organism attacker, Organism attacked){

    }
    private TreeMultiset<Organism> organisms;

    public int GetWidth() {
        return area.getWidth();
    }
    public int GetHeight(){
        return area.getHeight();
    }
    public void PushOrganism(Organism organism){
        organisms.add(organism);
        area.pushOrganism(organism);
    }
    public void DrawInterface(JPanel worldRepresentationPanel) {
        area.DrawFields();
    }

    public Organism[] getOrderedOrganisms(){
        return (Organism[]) organisms.toArray();
    }
    public void RandomizeOrganisms() {
        PushOrganism(new Antelope(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new CyberSheep(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Fox(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Human(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Sheep(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Turtle(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Wolf(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Dandelion(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new DeadlyNightshade(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Grass(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new Guarana(1,1,1,area.GetEmptyRandomPosition(), this));
        PushOrganism(new HeracleumSosnowskyi(1,1,1,area.GetEmptyRandomPosition(), this));



    }
}
