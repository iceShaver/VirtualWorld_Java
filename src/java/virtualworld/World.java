package virtualworld;
import com.google.common.collect.TreeMultiset;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import javafx.geometry.Pos;
import virtualworld.areas.Area;
import virtualworld.areas.HexagonalArea;
import virtualworld.areas.SquareArea;
import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.Sheep;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public class World {
    private Area area;
    public World(GameInitializer gameInitializer) {
        if(gameInitializer.areaType == AreaType.SQUARE) area = new SquareArea(gameInitializer.width, gameInitializer.height);
        else if(gameInitializer.areaType==AreaType.HEX) area = new HexagonalArea(gameInitializer.width, gameInitializer.height);
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
        area.DrawFields(worldRepresentationPanel);
    }

    public void RandomizeOrganisms() {
        Organism org = new Sheep(1, new Position(10, 10), 1, this, 1, Color.red);
        PushOrganism(org);
    }
}
