package InputDialog;

import Action.MediatorAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Mediator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractMediator;
    private JTextField abstractColleague;
    private JTextField colleague1;
    private JTextField colleague2;
    private JTextField mediator;
    MediatorAction mediatorAction;

    public Mediator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Mediator Pattern");
        mediatorAction = new MediatorAction();

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
        mediatorAction.setAbstractColleague(abstractColleague.getText());
        mediatorAction.setAbstractMediator(abstractMediator.getText());
        mediatorAction.setMediator(mediator.getText());
        mediatorAction.setColleague1(colleague1.getText());
        mediatorAction.setColleague2(colleague2.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Mediator dialog = new Mediator();
        dialog.pack();
        dialog.setVisible(true);
    }
}
