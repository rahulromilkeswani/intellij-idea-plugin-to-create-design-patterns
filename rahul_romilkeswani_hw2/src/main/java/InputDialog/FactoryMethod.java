package InputDialog;

import Action.FactoryMethodAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class FactoryMethod extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField factoryInterfaceObject;
    private JTextField methodName;
    private JTextField class1;
    private JTextField class2;
    private JTextField abstractFactory;
    private JTextField factoryClass;
    private JTextField createdObject;
    FactoryMethodAction factoryMethodAction;

    public FactoryMethod() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Factory Method Pattern");
        factoryMethodAction = new FactoryMethodAction();
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
        factoryMethodAction.setAbstractFactory(abstractFactory.getText());
        factoryMethodAction.setClass1(class1.getText());
        factoryMethodAction.setClass2(class2.getText());
        factoryMethodAction.setCreatedObject(createdObject.getText());
        factoryMethodAction.setFactoryClass(factoryClass.getText());
        factoryMethodAction.setFactoryInterfaceObject(factoryInterfaceObject.getText());
        factoryMethodAction.setMethodName(methodName.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        FactoryMethod dialog = new FactoryMethod();
        dialog.pack();
        dialog.setVisible(true);
    }
}
