package virtualworld.organisms.plants;

import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Guarana extends Plant implements Serializable {
    protected static ImageIcon imageIcon;
    public Guarana(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        icon=imageIcon;

    }
    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    @Override
    public ResistType resistAttack(Organism otherOrganism) {
        return ResistType.increaseStrength;
    }
}
