package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.World;
import virtualworld.organisms.animals.Animal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Plant extends Animal{
    protected static Image imageIcon;
    public Plant(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }

    @Override
    public void Act() {

    }

}
