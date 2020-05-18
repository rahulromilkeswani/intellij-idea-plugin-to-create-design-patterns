package InputDialog;

import Action.DecoratorAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Decorator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractComponent;
    private JTextField methodName;
    private JTextField componentClass;
    private JTextField abstractDecorator;
    private JTextField decorator1;
    private JTextField decorator2;
    DecoratorAction decoratorAction;


    public Decorator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Decorator Pattern");
        decoratorAction = new DecoratorAction();

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
        decoratorAction.setAbstractComponent(abstractComponent.getText());
        decoratorAction.setAbstractDecorator(abstractDecorator.getText());
        decoratorAction.setComponentClass(componentClass.getText());
        decoratorAction.setDecorator1(decorator1.getText());
        decoratorAction.setDecorator2(decorator2.getText());
        decoratorAction.setMethodName(methodName.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Decorator dialog = new Decorator();
        dialog.pack();
        dialog.setVisible(true);
    }
}
