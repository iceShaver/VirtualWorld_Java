package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.World;
import virtualworld.organisms.animals.Animal;

import java.awt.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Plant extends Animal{
    public Plant(int strength, Position position, int age, World world, int initiative, Color color) {
        super(strength, position, age, world, initiative, color);
    }

    @Override
    public void Act() {

    }

}
