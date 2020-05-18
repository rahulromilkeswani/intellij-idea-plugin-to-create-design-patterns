package InputDialog;

import Action.ProxyAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Proxy extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField abstractProxy;
    private JTextField methodName;
    private JTextField realClass;
    private JTextField proxyClass;
    ProxyAction proxyAction;

    public Proxy() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Proxy Pattern");
        proxyAction = new ProxyAction();

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
        proxyAction.setAbstractProxy(abstractProxy.getText());
        proxyAction.setMethodName(methodName.getText());
        proxyAction.setProxyClass(proxyClass.getText());
        proxyAction.setRealClass(realClass.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Proxy dialog = new Proxy();
        dialog.pack();
        dialog.setVisible(true);
    }
}
