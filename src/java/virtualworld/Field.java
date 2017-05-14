package virtualworld;

import virtualworld.organisms.Organism;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by kamil on 5/13/17.
 */
public class Field implements Serializable{
    Organism organism;
    JButton button;

    public Field(Organism organism, JButton button) {
        this.organism = organism;
        this.button = button;
    }

    public Organism getOrganism() {
        return organism;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public void clear() {
        button.removeActionListener(organism);
        button.setIcon(null);
        button.setOpaque(false);
        button.repaint();
        organism = null;
    }
}
