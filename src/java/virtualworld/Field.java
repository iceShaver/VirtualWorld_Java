package virtualworld;

import virtualworld.organisms.Organism;

import javax.swing.*;

/**
 * Created by kamil on 5/13/17.
 */
public class Field {
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
}
