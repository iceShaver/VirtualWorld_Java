package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Guarana extends Plant{
    public Guarana(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }
    static {
        readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }
}
