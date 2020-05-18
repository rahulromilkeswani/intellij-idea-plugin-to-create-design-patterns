package InputDialog;

import Action.StrategyAction;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Strategy extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField strategyInterface;
    private JTextField methodName;
    private JTextField strategy1;
    private JTextField strategy2;
    private JTextField contextClass;
    StrategyAction strategyAction;

    public Strategy() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Strategy Pattern");
        strategyAction = new StrategyAction();

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
        strategyAction.setContextClass(contextClass.getText());
        strategyAction.setMethodName(methodName.getText());
        strategyAction.setStrategy1(strategy1.getText());
        strategyAction.setStrategy2(strategy2.getText());
        strategyAction.setStrategyInterface(strategyInterface.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Strategy dialog = new Strategy();
        dialog.pack();
        dialog.setVisible(true);
    }
}
