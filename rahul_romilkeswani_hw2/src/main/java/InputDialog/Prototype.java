package InputDialog;

import Action.PrototypeAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Prototype extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField objectInterface;
    private JTextField methodName;
    private JTextField prototypeInterface;
    private JTextField concreteClass;
    PrototypeAction prototypeAction;

    public Prototype() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Prototype Pattern");
        prototypeAction = new PrototypeAction();

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
        prototypeAction.setConcreteClass(concreteClass.getText());
        prototypeAction.setMethodName(methodName.getText());
        prototypeAction.setObjectInterface(objectInterface.getText());
        prototypeAction.setPrototypeInterface(prototypeInterface.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Prototype dialog = new Prototype();
        dialog.pack();
        dialog.setVisible(true);
    }
}
