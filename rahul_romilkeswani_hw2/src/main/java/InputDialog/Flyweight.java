package InputDialog;

import Action.FlyweightAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Flyweight extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField flyweightInterface;
    private JTextField methodName;
    private JTextField flyweightClass;
    private JTextField flyweightFactory;
    FlyweightAction flyweightAction;

    public Flyweight() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Flyweight Pattern");
        flyweightAction = new FlyweightAction();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
    }

    private void onOK() {
        flyweightAction.setFlyweightClass(flyweightClass.getText());
        flyweightAction.setFlyweightFactory(flyweightFactory.getText());
        flyweightAction.setFlyweightInterface(flyweightInterface.getText());
        flyweightAction.setMethodName(methodName.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Flyweight dialog = new Flyweight();
        dialog.pack();
        dialog.setVisible(true);
    }
}
