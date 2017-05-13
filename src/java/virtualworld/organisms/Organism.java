package virtualworld.organisms;

import virtualworld.Position;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Organism implements Comparable, ActionListener {
    public Organism(int strength, Position position, int age, World world, int initiative, Color color) {
        this.strength = strength;
        this.position = position;
        this.age = age;
        this.world = world;
        this.initiative = initiative;
        this.color = color;
    }

    public abstract void Act();

    @Override
    public int compareTo(Object o) {
        if(initiative>((Organism)o).initiative)
            return 1;
        if(initiative<((Organism)o).initiative)
            return -1;
        if(initiative==((Organism)o).initiative){
            if(age>((Organism)o).age)
                return 1;
            if(age<((Organism)o).age)
                return -1;
            return 0;
        }
        return 0;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append(System.lineSeparator());
        sb.append("Sila: "+strength);
        sb.append(System.lineSeparator());
        sb.append("Pozycja: "+position.toString());
        sb.append(System.lineSeparator());
        sb.append("Wiek: "+age);
        sb.append(System.lineSeparator());
        sb.append("Inicjatywa: "+initiative);
        sb.append(System.lineSeparator());
        sb.append("Color"+color);
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

    public void setColor(Color color) {
        this.color = color;
    }

    protected int strength;
    protected Position position;
    protected int age;
    protected World world;
    private int initiative;
    private Color color;
    public Color getColor() {
        return color;
    }
}
