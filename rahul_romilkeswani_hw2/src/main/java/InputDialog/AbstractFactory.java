package InputDialog;

import Action.AbstractFactoryAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class AbstractFactory extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField object1;
    private JTextField object1Methods;
    private JTextField className1;
    private JTextField object2;
    private JTextField object2Methods;
    private JTextField className2;
    private JTextField interfaceName;
    private JTextField factoryName;
    AbstractFactoryAction abstractFactoryAction;

    public AbstractFactory() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Abstract Factory Pattern");
        abstractFactoryAction = new AbstractFactoryAction();

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
        abstractFactoryAction.setClassName1(className1.getText());
        abstractFactoryAction.setClassName2(className2.getText());
        abstractFactoryAction.setFactoryName(factoryName.getText());
        abstractFactoryAction.setInterfaceName(interfaceName.getText());
        abstractFactoryAction.setObject1(object1.getText());
        abstractFactoryAction.setObject2(object2.getText());
        abstractFactoryAction.setObject1Methods(object1Methods.getText());
        abstractFactoryAction.setObject2Methods(object2Methods.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AbstractFactory dialog = new AbstractFactory();
        dialog.pack();
        dialog.setVisible(true);
    }


}
