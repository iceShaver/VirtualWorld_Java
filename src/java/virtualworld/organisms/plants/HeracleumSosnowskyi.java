package virtualworld.organisms.plants;

import javafx.geometry.Pos;
import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.Animal;
import virtualworld.organisms.animals.CyberSheep;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Vector;

import static virtualworld.ResistType.kill;

/**
 * Created by Kamil on 11.05.2017.
 */
public class HeracleumSosnowskyi extends Plant implements Serializable {
    protected static ImageIcon imageIcon;
    public HeracleumSosnowskyi(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;

    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    @Override
    public ResistType resistAttack(Organism otherOrganism) {
        if(otherOrganism instanceof CyberSheep)
            return ResistType.surrender;
        return  kill;
    }

    @Override
    public void Act() {
        super.Act();
        Vector<Position> organismPositions = world.GetAllNeighbourPositions(position, 1, NeighbourPlaceSearchMode.all);
        for (Position organismPosition : organismPositions) {
            Organism organism = world.GetOrganism(organismPosition);
            if(organism!=null){
                if(organism instanceof Animal && !(organism instanceof CyberSheep)){
                    world.newMessage("zabija",this, world.GetOrganism(organismPosition));
                    world.safeDeleteOrganism(organism);
                }
            }
        }
    }
}
