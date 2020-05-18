package InputDialog;
import Action.ChainOfResponsibilityAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class ChainOfResponsibility extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField handler;
    private JTextField methodName;
    private JTextField receiver1;
    private JTextField receiver2;
    private JTextField receiver3;
    ChainOfResponsibilityAction chainOfResponsibilityAction;

    public ChainOfResponsibility() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Chain of Responsibility Pattern");
        chainOfResponsibilityAction = new ChainOfResponsibilityAction();

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
        chainOfResponsibilityAction.setHandler(handler.getText());
        chainOfResponsibilityAction.setMethodName(methodName.getText());
        chainOfResponsibilityAction.setReceiver1(receiver1.getText());
        chainOfResponsibilityAction.setReceiver2(receiver2.getText());
        chainOfResponsibilityAction.setReceiver3(receiver3.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ChainOfResponsibility dialog = new ChainOfResponsibility();
        dialog.pack();
        dialog.setVisible(true);
    }
}
