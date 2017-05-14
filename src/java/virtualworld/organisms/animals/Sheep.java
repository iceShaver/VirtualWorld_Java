package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Sheep extends Animal{
    protected static ImageIcon imageIcon;
    public Sheep(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;

    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

}
