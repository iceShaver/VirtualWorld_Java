import virtualworld.AreaType;
import virtualworld.GameInitializer;

import javax.swing.*;
import java.awt.event.*;

public class NewGameDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField widthField;
    private JTextField heightField;
    private JRadioButton squareRadioButton;
    private JRadioButton hexRadioButton;
    private VirtualWorld mainWindow;

    public NewGameDialog(VirtualWorld mainWindow) {
        this.mainWindow = mainWindow;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
        setVisible(true);
    }

    private void onOK() {
        // add your code here
        int width, height;
        try {
            width = Integer.parseInt(widthField.getText());
            height = Integer.parseInt(heightField.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Conajmniej jedna podana liczba jest bledna", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AreaType areaType;
        if(squareRadioButton.isSelected())areaType=AreaType.SQUARE;
        else if(hexRadioButton.isSelected())areaType= AreaType.HEX;
        else {
            JOptionPane.showMessageDialog(null, "Nie wybrano rodzaju pol planszy", "Blad", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dispose();
        mainWindow.StartNewGame(new GameInitializer(width, height, areaType));
    }



    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
