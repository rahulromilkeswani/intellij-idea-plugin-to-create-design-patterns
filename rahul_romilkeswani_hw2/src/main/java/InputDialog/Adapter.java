package InputDialog;
import Action.*;

import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Adapter extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField adapteeName;
    private JTextField methodName;
    private JTextField interfaceName;
    private JTextField adapterName;
    AdapterAction adapterAction;
    public Adapter() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Adapter Pattern");
        adapterAction = new AdapterAction();

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
        adapterAction.setAdapteeName(adapteeName.getText());
        adapterAction.setAdapterName(adapterName.getText());
        adapterAction.setInterfaceName(interfaceName.getText());
        adapterAction.setMethodName(methodName.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Adapter dialog = new Adapter();
        dialog.pack();
        dialog.setVisible(true);
    }
}
