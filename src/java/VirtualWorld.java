import oracle.jrockit.jfr.JFR;
import virtualworld.GameInitializer;
import virtualworld.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kamil on 01.05.2017.
 */
public class VirtualWorld extends JFrame {
    private JPanel virtualWorldPanel;
    private JButton newGameButton;
    private JButton openGameButton;
    private JButton saveGameButton;
    private JButton quitButton;
    private JPanel worldRepresentationPanel;
    private JButton logWindowButton;
    private JButton intructionButton;
    private LogWindow logFrame;
    private World world;
    public VirtualWorld(){
        super("Wirtualny świat - Kamil Królikowski 165253");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setContentPane(virtualWorldPanel);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack();
                setVisible(true);
            }
        });



        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int dialogResult = JOptionPane.showConfirmDialog(
                        null,
                        "Czy na pewno chcesz opuścić aplikację?",
                        "Potwierdź akcję",
                        JOptionPane.YES_NO_OPTION);
                if(dialogResult==JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        logWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logFrame = new LogWindow();
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGameDialog(VirtualWorld.this);
            }
        });
        openGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void StartNewGame(GameInitializer gameInitializer){
        world = new World(gameInitializer);
        drawIterface();
    }

    private void drawIterface() {

    }
}
