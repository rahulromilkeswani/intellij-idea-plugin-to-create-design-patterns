package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class CommandAction extends PatternAction {
    static private String receiver;
    static private String methodName;
    static private String commandInterface;

    //setter methods for the fields
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setCommandInterface(String commandInterface) {
        this.commandInterface = commandInterface;
    }

    public void setCommandClass(String commandClass) {
        this.commandClass = commandClass;
    }

    static private String commandClass;


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Command.main(null);  // opens the pattern input dialog
        logger.info("Command pattern input dialog invoked");
        try {
            //creates source files for Command pattern
            myCreator.createPattern(receiver, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.class-ftl"));
            myCreator.createPattern(commandInterface, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(commandClass, new HashSet<>(Arrays.asList(Helper.toMemberString(receiver))), myCreator.formatMethods(methodName), commandInterface, config.getString("path.command-concrete-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
