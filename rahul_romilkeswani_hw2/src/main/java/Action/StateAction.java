package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class StateAction extends PatternAction {
    static private String contextClass;
    static private String stateInterface;
    static private String methodName;
    static private String state1;
    static private String state2;

    //setter methods for the fields
    public void setContextClass(String contextClass) {
        this.contextClass = contextClass;
    }

    public void setStateInterface(String stateInterface) {
        this.stateInterface = stateInterface;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.State.main(null); // opens the pattern input dialog
        logger.info("State pattern input dialog invoked");
        try {
            //creates source files for State pattern
            myCreator.createPattern(stateInterface, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))), myCreator.formatMethods(methodName), null, config.getString("path.state-interface-ftl"));
            myCreator.createPattern(contextClass, new HashSet<>(Arrays.asList(Helper.toMemberString(stateInterface))), myCreator.formatMethods(methodName), null, config.getString("path.state-context-class-ftl"));
            myCreator.createPattern(state1, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))), myCreator.formatMethods(methodName), stateInterface, config.getString("path.state-concrete-class-ftl"));
            myCreator.createPattern(state2, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))), myCreator.formatMethods(methodName), stateInterface, config.getString("path.state-concrete-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
