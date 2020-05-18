package InputDialog;

import Action.CommandAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Command extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField receiver;
    private JTextField methodName;
    private JTextField commandInterface;
    private JTextField commandClass;
    CommandAction commandAction;

    public Command() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Command Pattern");
        commandAction = new CommandAction();

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
        commandAction.setCommandClass(commandClass.getText());
        commandAction.setCommandInterface(commandInterface.getText());
        commandAction.setMethodName(methodName.getText());
        commandAction.setReceiver(receiver.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary

        dispose();
    }

    public static void main(String[] args) {
        Command dialog = new Command();
        dialog.pack();
        dialog.setVisible(true);

    }
}
