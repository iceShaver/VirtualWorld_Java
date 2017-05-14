package virtualworld;

import virtualworld.organisms.Organism;
import virtualworld.organisms.animals.Antelope;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    boolean gameStarted;

    public VirtualWorld() {
        super("Wirtualny świat - Kamil Królikowski 165253");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setContentPane(virtualWorldPanel);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pack();
                setVisible(true);
                gameStarted = false;
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
        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveGame();
            }
        });
        openGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Binary files", "bin");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(getParent());
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " +
                            chooser.getSelectedFile().getName());
                    openGame(chooser.getSelectedFile().getAbsolutePath());
                }

            }
        });
    }

    private void openGame(String absolutePath) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(absolutePath);
            ois = new ObjectInputStream(fis);
            world = (World) ois.readObject();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try{
            if(ois!=null)
                ois.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                if(fis!=null)fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        GameInitializer gameInitializer = new GameInitializer();
        gameInitializer.mainWindow=this;
        gameInitializer.worldRepresentationPanel = worldRepresentationPanel;
        world.initializeAfterDeserialization(gameInitializer);
        world.DrawInterface(worldRepresentationPanel);
    }

    private void saveGame() {
        if(world==null)
        {
            JOptionPane.showMessageDialog(null, "Start the game first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("test.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(world);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException w) {
            }
            try{
                if (fos!=null)
                    fos.close();
            }catch (IOException e){

            }
        }
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
