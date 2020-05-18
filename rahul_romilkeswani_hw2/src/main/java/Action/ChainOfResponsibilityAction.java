package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class ChainOfResponsibilityAction extends PatternAction {

    static private String handler;
    static private String methodName;
    static private String receiver1;
    static private String receiver2;
    static private String receiver3;

    //setter methods for the fields
    public void setHandler(String handler) {
        ChainOfResponsibilityAction.handler = handler;
    }

    public void setMethodName(String methodName) {
        ChainOfResponsibilityAction.methodName = methodName;
    }

    public void setReceiver1(String receiver1) {
        ChainOfResponsibilityAction.receiver1 = receiver1;
    }

    public void setReceiver2(String receiver2) {
        ChainOfResponsibilityAction.receiver2 = receiver2;
    }

    public void setReceiver3(String receiver3) {
        ChainOfResponsibilityAction.receiver3 = receiver3;
    }

    @Override

    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.ChainOfResponsibility.main(null); // opens the pattern input dialog
        logger.info("Chain of responsibility pattern input dialog invoked");
        try {
            //creates source files for Chain of Responsibility pattern
            myCreator.createPattern(handler, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handler))), myCreator.formatMethods(methodName), null, config.getString("path.cor-abstract-class-ftl"));
            myCreator.createPattern(receiver1, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handler))), myCreator.formatMethods(methodName), handler, config.getString("path.cor-receiver-class-ftl"));
            myCreator.createPattern(receiver2, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handler))), myCreator.formatMethods(methodName), handler, config.getString("path.cor-receiver-class-ftl"));
            myCreator.createPattern(receiver3, new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.successor-text"), handler))), myCreator.formatMethods(methodName), handler, config.getString("path.cor-final-receiver-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}