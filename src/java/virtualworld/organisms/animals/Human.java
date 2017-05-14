package virtualworld.organisms.animals;

import virtualworld.MovementDirection;
import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

import static virtualworld.MovementDirection.*;
import static virtualworld.ResistType.moveAroundMe;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Human extends Animal implements Serializable {
    protected static ImageIcon imageIcon;
    private MovementDirection movementDirection;
    private boolean alzursShieldActivated;
    private int alzursShieldActDeactRound;

    public Human(int strength, int age, int initiative, Position position, World world) {
        super(strength, age, initiative, position, world);
        movementDirection = MovementDirection.undefined;
        icon = imageIcon;
        alzursShieldActivated = false;
        alzursShieldActDeactRound = 0;
    }

    @Override
    public void Act() {
        handleAlzursShield();
        Position newOrganismPositon = new Position(position.getX(), position.getY());
        switch (movementDirection) {
            case undefined:
                world.newMessage("pozostaje na miejscu", this);
                return;
            case upLeft:
                newOrganismPositon.setX(newOrganismPositon.getX() - 1);
                newOrganismPositon.setY(newOrganismPositon.getY() - 1);
                break;
            case up:
                newOrganismPositon.setY(newOrganismPositon.getY() - 1);
                break;
            case upRight:
                newOrganismPositon.setX(newOrganismPositon.getX() + 1);
                newOrganismPositon.setY(newOrganismPositon.getY() - 1);
                break;
            case left:
                newOrganismPositon.setX(newOrganismPositon.getX() - 1);
                break;
            case right:
                newOrganismPositon.setX(newOrganismPositon.getX() + 1);
                break;
            case downLeft:
                newOrganismPositon.setX(newOrganismPositon.getX() - 1);
                newOrganismPositon.setY(newOrganismPositon.getY() + 1);
                break;
            case down:
                newOrganismPositon.setY(newOrganismPositon.getY() + 1);
                break;
            case downRight:
                newOrganismPositon.setX(newOrganismPositon.getX() + 1);
                newOrganismPositon.setY(newOrganismPositon.getY() + 1);
                break;
            default:
                break;
        }
        if (newOrganismPositon == position)
            world.newMessage("pozostaje na miejscu", this);
        else if (world.checkIfPlaceIsValidAndEmpty(newOrganismPositon.getX(), newOrganismPositon.getY())) {
            world.moveOrganism(this, newOrganismPositon);
        } else if (world.checkIfPlaceIsValid(newOrganismPositon.getX(), newOrganismPositon.getY())) {
            handleCollision(world.GetOrganism(newOrganismPositon));
        }


    }

    private void handleAlzursShield() {
        if(alzursShieldActivated)
        {
            if ((world.getRoundNumber() - alzursShieldActDeactRound) < 5) return;
            world.newMessage("Tarcza alzura zdezaktywowana", this);
            alzursShieldActivated = false;
            alzursShieldActDeactRound = world.getRoundNumber();
        }
    }

    static {
        imageIcon = readImage(MethodHandles.lookup().lookupClass().getSimpleName());
    }

    public void handleInput(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                movementDirection = up;
                break;
            case KeyEvent.VK_DOWN:
                movementDirection = down;
                break;
            case KeyEvent.VK_LEFT:
                movementDirection = left;
                break;
            case KeyEvent.VK_RIGHT:
                movementDirection = right;
                break;
            case KeyEvent.VK_PAGE_UP:
                movementDirection = upRight;
                break;
            case KeyEvent.VK_PAGE_DOWN:
                movementDirection = downRight;
                break;
            case KeyEvent.VK_HOME:
                movementDirection = upLeft;
                break;
            case KeyEvent.VK_END:
                movementDirection = downLeft;
                break;
            case KeyEvent.VK_SPACE:
                activateAlzursShield();
                break;
            case KeyEvent.VK_DELETE:
                movementDirection = undefined;
                break;

        }
    }

    private void activateAlzursShield() {
        if (alzursShieldActivated) return;
        if ((world.getRoundNumber() - alzursShieldActDeactRound) < 5) return;
        world.newMessage("Tarcza alzura aktywowana", this);
        alzursShieldActivated = true;
        alzursShieldActDeactRound = world.getRoundNumber();
    }

    @Override
    public ResistType resistAttack(Organism otherOrganism) {
        if (alzursShieldActivated)
        {
            world.newMessage("tarcza alzura dla ", this, otherOrganism);
            return moveAroundMe;
        }
        return super.resistAttack(otherOrganism);
    }
    private boolean isAlzursShieldActivated(){
        return alzursShieldActivated;
    }
}
