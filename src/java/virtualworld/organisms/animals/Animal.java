package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.World;
import virtualworld.organisms.Organism;

import java.awt.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Animal extends Organism {
    public Animal(int strength, Position position, int age, World world, int initiative, Color color) {
        super(strength, position, age, world, initiative, color);
    }

    @Override
    public void Act() {

    }
}
