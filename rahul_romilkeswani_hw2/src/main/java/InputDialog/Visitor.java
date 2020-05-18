package InputDialog;

import Action.VisitorAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Visitor extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractVisitor;
    private JTextField abstractElement;
    private JTextField element1;
    private JTextField element2;
    private JTextField visitorClass;
    VisitorAction visitorAction;

    public Visitor() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Visitor Pattern");
        visitorAction = new VisitorAction();

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
        visitorAction.setAbstractElement(abstractElement.getText());
        visitorAction.setAbstractVisitor(abstractVisitor.getText());
        visitorAction.setElement1(element1.getText());
        visitorAction.setElement2(element2.getText());
        visitorAction.setVisitorClass(visitorClass.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Visitor dialog = new Visitor();
        dialog.pack();
        dialog.setVisible(true);
    }
}
