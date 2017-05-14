package virtualworld.organisms;

import virtualworld.Position;
import virtualworld.ResistType;
import virtualworld.World;
import virtualworld.organisms.animals.Animal;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Organism implements Comparable, ActionListener, Serializable {
    public Organism(int strength, int age, int initiative, Position position, World world) {
        this.strength = strength;
        this.age = age;
        this.initiative = initiative;
        this.position = position;
        this.world = world;
        world.newMessage("Rodzi się", this);
    }

    public abstract void Act();
    public  ResistType resistAttack(final Organism otherOrganism){
        if(strength>otherOrganism.strength)return ResistType.kill;
        return ResistType.surrender;
    }
    public abstract void handleCollision(Organism organism);
    @Override
    public int compareTo(Object o) {
        if (initiative > ((Organism) o).initiative)
            return -1;
        if (initiative < ((Organism) o).initiative)
            return 1;
        if (initiative == ((Organism) o).initiative) {
            if (age > ((Organism) o).age)
                return -1;
            if (age < ((Organism) o).age)
                return 1;
            return -1;
        }
        return -1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(System.lineSeparator());
        sb.append("Sila: " + strength);
        sb.append(System.lineSeparator());
        sb.append("Wiek: " + age);
        sb.append(System.lineSeparator());
        sb.append("Inicjatywa: " + initiative);
        sb.append(System.lineSeparator());
        sb.append("Pozycja: " + position.toString());
        sb.append(System.lineSeparator());
        JOptionPane.showMessageDialog(null, sb, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }



    protected int strength;
    protected int age;
    private int initiative;
    protected Position position;
    protected World world;
    //protected Image icon;
    protected ImageIcon icon;

    static protected ImageIcon readImage(String className) {
        Image result = null;
        try {
            result = ImageIO.read(new File("./img/"+className+".png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono pliku tekstury dla: " + className, "Blad", JOptionPane.ERROR_MESSAGE);
            //Graphics graphics = new BufferedImage(0,40,BufferedImage.TYPE_INT_ARGB).getGraphics();
            //graphics.drawString(className.substring(0,2), 1, 1);
            //graphics.drawImage(imageIcon, 0, 0, null);
            //imageIcon = new BufferedImage(1,1,BufferedImage.TYPE_INT_ARGB);
        }
        return new ImageIcon(result.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        //return null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" +
                "strength=" + strength +
                ", age=" + age +
                ", initiative=" + initiative +
                ", position=" + position +
                '}';
    }
    public ImageIcon getIcon() {
        return icon;
    }
}
