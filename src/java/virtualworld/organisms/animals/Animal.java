package virtualworld.organisms.animals;

import javafx.geometry.Pos;
import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.areas.NeighbourPlaceSearchMode;
import virtualworld.organisms.Organism;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

import static virtualworld.ResistType.*;
import static virtualworld.areas.NeighbourPlaceSearchMode.onlyEmpty;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Animal extends Organism implements Serializable {
    public Animal(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
    }

    @Override
    public void Act() {
        Position newPosition = world.GetRandomPosition(position, 1, NeighbourPlaceSearchMode.all);
        if (newPosition == null) return;
        if (world.GetOrganism(newPosition) != null) {
            //world.Collide(this, world.GetOrganism(newPosition));
            handleCollision(world.GetOrganism(newPosition));
            return;

        }
        world.moveOrganism(this, newPosition);
    }

    @Override
    public void handleCollision(Organism otherOrganism) {
        Position newPosition = new Position(otherOrganism.getPosition().getX(), otherOrganism.getPosition().getY());
        world.newMessage("* ", this, otherOrganism);
        if (getClass().getSimpleName() == otherOrganism.getClass().getSimpleName()) {
            Position tmp = world.GetRandomNeighbourPosition(this.position, 1, onlyEmpty);
            if (tmp == null) return;
            Position organismPosition = new Position(tmp.getX(), tmp.getY());
            world.newMessage("nowe zwierze", this);
            if (this instanceof Antelope)
                world.safePushOrganism(new Antelope(1, 1, 1, organismPosition, world));
            if (this instanceof CyberSheep)
                world.safePushOrganism(new CyberSheep(11, 0, 4, organismPosition, world));
            if (this instanceof Fox)
                world.safePushOrganism(new Fox(3, 0, 7, organismPosition, world));
            if (this instanceof Sheep)
                world.safePushOrganism(new Sheep(4, 0, 4, organismPosition, world));
            if (this instanceof Turtle)
                world.safePushOrganism(new Turtle(2, 0, 1, organismPosition, world));
            if (this instanceof Wolf)
                world.safePushOrganism(new Wolf(9, 0, 5, organismPosition, world));
        }
        ResistType result = otherOrganism.resistAttack(this);
        if(result == kill)
        {
            world.newMessage("< ", this, otherOrganism);
            world.safeDeleteOrganism(this);
        }else if(result == surrender)
        {
            world.newMessage("> ", this, otherOrganism);
            world.safeDeleteOrganism(otherOrganism);
            world.moveOrganism(this,newPosition);
        }else if(result==moveToPreviousPlace)
        {
            world.newMessage("zostaje odepchniety przez ", this, otherOrganism);
        }else if(result==escape)
        {
            world.newMessage("wyploszyl ", this, otherOrganism);
            world.moveOrganism(this, newPosition);
        }else if(result == increaseStrength)
        {
            strength += 3;
            StringBuilder message = new StringBuilder();
            message.append("sila rosnie do ");
            message.append(strength);
            message.append(" ");
            world.newMessage("> ", this, otherOrganism);
            world.safeDeleteOrganism(otherOrganism);
            world.newMessage(message.toString(), this);
            world.moveOrganism(this, newPosition);
        }else if(result==moveAroundMe)
        {
            Position newOrganismPos = world.GetRandomNeighbourPosition(position, 1, onlyEmpty);
            if(newOrganismPos!=null)
            {
                world.moveOrganism(this, newOrganismPos);
                //delete newOrganismPos;
            }
        }
    }


}