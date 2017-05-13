import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kamil on 13.05.2017.
 */
public class AllOrganismsListWindow extends JFrame {
    private JPanel panel1;
    private Organism[] organisms;
    public AllOrganismsListWindow(Organism[]organisms){
        this.organisms = organisms;
        panel1.add(new JList(organisms));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }





}
