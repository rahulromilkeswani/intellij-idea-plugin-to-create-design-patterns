package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class BridgeAction extends PatternAction {
    static private String abstractionInterface;
    static private String methodName;
    static private String abstractionClass;
    static private String bridgeInterface;

    //setter methods for the fields
    public void setAbstractionInterface(String abstractionInterface) {
        BridgeAction.abstractionInterface = abstractionInterface;
    }

    public void setMethodName(String methodName) {
        BridgeAction.methodName = methodName;
    }

    public void setAbstractionClass(String abstractionClass) {
        BridgeAction.abstractionClass = abstractionClass;
    }

    public void setBridgeInterface(String bridgeInterface) {
        BridgeAction.bridgeInterface = bridgeInterface;
    }

    public void setBridge(String bridge) {
        BridgeAction.bridge = bridge;
    }

    static private String bridge;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Bridge.main(null); // opens the pattern input dialog
        logger.info("Bridge pattern input dialog invoked");
        try {
            //creates source files for Bridge pattern
            myCreator.createPattern(abstractionInterface, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(abstractionClass, new HashSet<>(), myCreator.formatMethods(methodName), abstractionInterface, config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(bridgeInterface, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(bridge, new HashSet<>(Arrays.asList(Helper.toMemberString(bridgeInterface))), myCreator.formatMethods(methodName), bridgeInterface, config.getString("path.bridge-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
