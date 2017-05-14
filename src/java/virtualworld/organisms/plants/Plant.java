package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.Animal;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Plant extends Organism implements Serializable {
    protected static Image imageIcon;

    public Plant(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }

    @Override
    public void Act() {
        if (new Random().nextDouble() < 0.01)
            sow();
    }

    private void sow() {
        Position newPosition = world.GetRandomNeighbourPosition(position, 1, NeighbourPlaceSearchMode.onlyEmpty);
        if(newPosition==null)
            return;
        if (this instanceof Dandelion)
            world.safePushOrganism(new Dandelion(0, 0, 0, newPosition, world));
        else if (this instanceof DeadlyNightshade)
            world.safePushOrganism(new DeadlyNightshade(99, 0, 0, newPosition, world));
        else if (this instanceof Grass)
            world.safePushOrganism(new Grass(0, 0, 0, newPosition, world));
        else if (this instanceof Guarana)
            world.safePushOrganism(new Guarana(0, 0, 0, newPosition, world));
        else if (this instanceof HeracleumSosnowskyi)
            world.safePushOrganism(new HeracleumSosnowskyi(10, 0, 0, newPosition, world));
    }


    @Override
    public void handleCollision(Organism otherOrganism) {
    }
}
