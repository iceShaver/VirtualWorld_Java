package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.World;
import virtualworld.organisms.Organism;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Animal extends Organism {
    public Animal(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }

    @Override
    public void Act() {

    }

}
