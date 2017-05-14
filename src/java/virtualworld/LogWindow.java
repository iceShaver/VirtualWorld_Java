package virtualworld;

import virtualworld.organisms.Organism;

import javax.swing.*;

/**
 * Created by Kamil on 01.05.2017.
 */
public class LogWindow extends JFrame {
    private JPanel LogPanel;
    private JList list1;

    public JList getList1() {
        return list1;
    }

    public LogWindow() {
        super("Log Window");
        setContentPane(LogPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        pack();
        setVisible(true);
    }

}
