package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Random;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Turtle extends Animal implements Serializable {
    protected static ImageIcon imageIcon;
    public Turtle(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;

    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    @Override
    public void Act() {
        if(new Random().nextDouble()<0.25){
            Position newPosition = world.GetRandomNeighbourPosition(position, 1, NeighbourPlaceSearchMode.all);
            if(newPosition==null)return;
            Organism neighbourOrganism = world.GetOrganism(newPosition);
            if(neighbourOrganism!=null)
                handleCollision(neighbourOrganism);
            else
                world.moveOrganism(this, newPosition);

        }
    }

    @Override
    public ResistType resistAttack(Organism otherOrganism) {
        if(otherOrganism.getStrength() < 5){
            return ResistType.moveToPreviousPlace;
        }
        return ResistType.surrender;
    }
}
