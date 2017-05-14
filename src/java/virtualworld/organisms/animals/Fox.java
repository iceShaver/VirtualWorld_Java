package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Fox extends Animal implements Serializable {
    protected static ImageIcon imageIcon;
    public Fox(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;
    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    @Override
    public void Act() {
        Position newPosition = world.GetRandomNeighbourPosition(position, 1, NeighbourPlaceSearchMode.emptyOrWithWeakOrganism);
        if(newPosition==null)return;
        Organism neighbourOrganism = world.GetOrganism(newPosition);
        if(neighbourOrganism!=null)
            handleCollision(neighbourOrganism);
        else
            world.moveOrganism(this, newPosition);
    }
}
