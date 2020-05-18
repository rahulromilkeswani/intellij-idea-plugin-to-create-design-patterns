package InputDialog;

import Action.InterpreterAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Interpreter extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField contextClass;
    private JTextField abstractClass;
    private JTextField nonTerminalClass;
    private JTextField terminalClass;
InterpreterAction interpreterAction;
    public Interpreter() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Interpreter Pattern");
        interpreterAction = new InterpreterAction();

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
        interpreterAction.setAbstractClass(abstractClass.getText());
        interpreterAction.setContextClass(contextClass.getText());
        interpreterAction.setNonTerminalClass(nonTerminalClass.getText());
        interpreterAction.setTerminalClass(terminalClass.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Interpreter dialog = new Interpreter();
        dialog.pack();
        dialog.setVisible(true);
    }
}
