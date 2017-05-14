package virtualworld;

import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.Antelope;

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
    private JButton organismsListButton;
    private JButton nextRoundButton;
    private JToolBar menuToolbar;
    private JButton button1;
    private LogWindow logFrame;
    private AllOrganismsListWindow allOrganismsListWindow;
    private World world;
    private Reporter reporter;

    public VirtualWorld() {
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
                if (dialogResult == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        logWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (world == null)
                    JOptionPane.showMessageDialog(null, "Start the game first", "Error", JOptionPane.ERROR_MESSAGE);
                else
                {
                    logFrame = new LogWindow();
                    reporter.setOutputList(logFrame.getList1());
                }
            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGameDialog newGameDialog = new NewGameDialog();
                GameInitializer gameInitializer = newGameDialog.GetResult();
                if (gameInitializer == null) return;
                gameInitializer.worldRepresentationPanel = worldRepresentationPanel;
                gameInitializer.reporter=reporter=new Reporter();
                gameInitializer.mainWindow = VirtualWorld.this;
                StartNewGame(gameInitializer);
            }
        });
        openGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        organismsListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (world == null)
                    JOptionPane.showMessageDialog(null, "Start the game first", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    allOrganismsListWindow = new AllOrganismsListWindow(world.getOrderedOrganisms());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.PushOrganism(new Antelope(0,0,0,new Position(5,5), world));
            }
        });
    }

    public void StartNewGame(GameInitializer gameInitializer) {
        world = new World(gameInitializer);
        world.DrawInterface(worldRepresentationPanel);
        world.RandomizeOrganisms();
        nextRoundButton = new JButton();
        nextRoundButton.setText("Next round");
        nextRoundButton.setBackground(Color.red);
        nextRoundButton.setOpaque(true);
        nextRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.playRound();
            }
        });
        menuToolbar.add(nextRoundButton, 0);
    }
    public void updateOrganismsList(Organism[] organisms){
        if(allOrganismsListWindow!=null){
            allOrganismsListWindow.refresh(organisms);
        }
    }
}
