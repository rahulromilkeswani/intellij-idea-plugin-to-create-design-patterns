package InputDialog;

import Action.SingletonAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Singleton extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField SingletonClassName;
    private JTextField SingletonInstanceName;

    SingletonAction singleton;

    public Singleton() {
        singleton = new SingletonAction();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Singleton Pattern");

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
        singleton.setClassName(SingletonClassName.getText());
        singleton.setFieldName(SingletonInstanceName.getText());
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Singleton dialog = new Singleton();
        dialog.pack();
        dialog.setVisible(true);
    }
}
