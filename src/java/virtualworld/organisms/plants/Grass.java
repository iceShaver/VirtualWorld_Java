package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Grass extends Plant implements Serializable {
    protected static ImageIcon imageIcon;
    public Grass(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;

    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

}
