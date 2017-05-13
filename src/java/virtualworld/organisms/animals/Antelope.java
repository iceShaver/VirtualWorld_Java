package virtualworld.organisms.animals;

import virtualworld.Position;
import virtualworld.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Antelope extends Animal{
    public Antelope(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }
    static {
        readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }
}
