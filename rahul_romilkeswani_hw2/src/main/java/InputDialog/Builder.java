package InputDialog;
import Action.*;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Builder extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField interfaceName;
    private JTextField methodName;
    private JTextField class1;
    private JTextField class2;
    private JTextField complexObject;
    private JTextField builderInterface;
    private JTextField builder;
    BuilderAction builderAction;

    public Builder() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Builder Pattern");
        builderAction = new BuilderAction();

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
        builderAction.setBuilder(builder.getText());
        builderAction.setBuilderInterface(builderInterface.getText());
        builderAction.setClass1(class1.getText());
        builderAction.setClass2(class2.getText());
        builderAction.setComplexObject(complexObject.getText());
        builderAction.setInterfaceName(interfaceName.getText());
        builderAction.setMethodName(methodName.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Builder dialog = new Builder();
        dialog.pack();
        dialog.setVisible(true);
    }
}
