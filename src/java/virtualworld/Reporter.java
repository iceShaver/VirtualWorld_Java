package virtualworld;

import virtualworld.organisms.Organism;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Kamil on 11.05.2017.
 */
public class Reporter {
    private JList outputList;
    DefaultListModel messages;

    public Reporter(JList outputList) {
        this.outputList = outputList;
        messages = new DefaultListModel();
    }

    public Reporter() {
        messages = new DefaultListModel();

    }

    private void scrollToEnd() {
        if (outputList != null) {
            int lastIndex = outputList.getModel().getSize() - 1;
            if (lastIndex >= 0)
                outputList.ensureIndexIsVisible(lastIndex);
        }
    }

    public void newMessage(String message) {
        messages.addElement(message);
        scrollToEnd();
    }

    public void newMessage(String message, final Organism organism) {
        messages.addElement(organism + " " + message);
        scrollToEnd();
    }

    public void newMessage(String message, final Organism organism, final Organism otherOrganism) {
        messages.addElement(organism + " " + message + " " + otherOrganism);
        scrollToEnd();
    }

    public void setOutputList(JList outputList) {
        this.outputList = outputList;
        outputList.setModel(messages);
    }
}
