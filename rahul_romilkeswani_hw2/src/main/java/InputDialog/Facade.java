package InputDialog;
import Action.*;
import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Facade extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField class1;
    private JTextField class1Method;
    private JTextField class2;
    private JTextField class2Method;
    private JTextField abstractFacade;
    private JTextField facadeMethod;
    private JTextField facadeClass;
    FacadeAction facadeAction;

    public Facade() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Facade Pattern");
        facadeAction = new FacadeAction();

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
        facadeAction.setAbstractFacade(abstractFacade.getText());
        facadeAction.setClass1(class1.getText());
        facadeAction.setClass1Method(class1Method.getText());
        facadeAction.setClass2(class2.getText());
        facadeAction.setClass2Method(class2Method.getText());
        facadeAction.setFacadeClass(facadeClass.getText());
        facadeAction.setFacadeMethod(facadeMethod.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Facade dialog = new Facade();
        dialog.pack();
        dialog.setVisible(true);
    }
}
