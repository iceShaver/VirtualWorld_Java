package virtualworld;

import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 13.05.2017.
 */
public class AllOrganismsListWindow extends JFrame {
    private JPanel panel1;
    private JList list1;
    private Organism[] organisms;
    public AllOrganismsListWindow(Organism[]organisms){
        this.organisms = organisms;
        list1.setListData(organisms);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public void refresh(Organism[] organisms) {
        list1.setListData(organisms);
    }
}
