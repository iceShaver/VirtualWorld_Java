package virtualworld.organisms.animals;

import javafx.geometry.Pos;
import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Random;

import static virtualworld.ResistType.escape;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Antelope extends Animal implements Serializable {
    protected static ImageIcon imageIcon;
    public Antelope(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;
    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    @Override
    public void Act() {
        Position newPosition = world.GetRandomNeighbourPosition(position, 2, NeighbourPlaceSearchMode.all);
        if (newPosition==null) return;
        Organism neigbourOrganism = world.GetOrganism(newPosition);
        if (neigbourOrganism!=null)
            handleCollision(neigbourOrganism);
        else {
            world.moveOrganism(this, newPosition);
        }
    }

    @Override
    public ResistType resistAttack(Organism otherOrganism) {
        if(new Random().nextDouble()<0.5){
            Position newPosition = world.GetRandomNeighbourPosition(position, 2, NeighbourPlaceSearchMode.onlyEmpty);
            if(newPosition!=null){
                world.moveOrganism(this, newPosition);
                return escape;
            }
        }
        return super.resistAttack(otherOrganism);
    }
}
