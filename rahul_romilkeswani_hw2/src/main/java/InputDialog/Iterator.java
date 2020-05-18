package InputDialog;
import Action.*;
import javax.swing.*;
import java.awt.event.*;

//JDialog class to create dialogs and also set fields received from the user
public class Iterator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField iteratorInterface;
    private JTextField aggregateInterface;
    private JTextField aggregateConcrete;
    private JTextField interatorConcrete;
    IteratorAction iteratorAction;

    public Iterator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Iterator Pattern");
        iteratorAction = new IteratorAction();


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
        iteratorAction.setAggregateConcrete(aggregateConcrete.getText());
        iteratorAction.setAggregateInterface(aggregateInterface.getText());
        iteratorAction.setInteratorConcrete(interatorConcrete.getText());
        iteratorAction.setIteratorInterface(iteratorInterface.getText());

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Iterator dialog = new Iterator();
        dialog.pack();
        dialog.setVisible(true);
    }
}
