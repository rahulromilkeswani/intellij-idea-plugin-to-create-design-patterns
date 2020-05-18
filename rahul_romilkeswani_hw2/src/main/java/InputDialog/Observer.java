package InputDialog;

import Action.ObserverAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Observer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractObserver;
    private JTextField abstractSubject;
    private JTextField concreteSubject;
    private JTextField observer1;
    private JTextField observer2;
    ObserverAction observerAction;

    public Observer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Observer Pattern");
        observerAction = new ObserverAction();

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
        observerAction.setAbstractObserver(abstractObserver.getText());
        observerAction.setAbstractSubject(abstractSubject.getText());
        observerAction.setConcreteSubject(concreteSubject.getText());
        observerAction.setObserver1(observer1.getText());
        observerAction.setObserver2(observer2.getText());


        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Observer dialog = new Observer();
        dialog.pack();
        dialog.setVisible(true);
    }
}
