package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class DeadlyNightshade extends Plant{
    public DeadlyNightshade(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }
    static {
        readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }
}
