package InputDialog;

import Action.BridgeAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Bridge extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractionInterface;
    private JTextField methodName;
    private JTextField abstractionClass;
    private JTextField bridgeInterface;
    private JTextField bridge;
    BridgeAction bridgeAction;

    public Bridge() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Bridge Pattern");
        bridgeAction = new BridgeAction();

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
        bridgeAction.setAbstractionClass(abstractionClass.getText());
        bridgeAction.setAbstractionInterface(abstractionInterface.getText());
        bridgeAction.setBridge(bridge.getText());
        bridgeAction.setBridgeInterface(bridgeInterface.getText());
        bridgeAction.setMethodName(methodName.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Bridge dialog = new Bridge();
        dialog.pack();
        dialog.setVisible(true);
    }
}
