package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class StrategyAction extends PatternAction {
    static private String strategyInterface;
    static private String methodName;
    static private String strategy1;
    static private String strategy2;
    static private String contextClass;

    //setter methods for the fields
    public void setStrategyInterface(String strategyInterface) {
        this.strategyInterface = strategyInterface;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setStrategy1(String strategy1) {
        this.strategy1 = strategy1;
    }

    public void setStrategy2(String strategy2) {
        this.strategy2 = strategy2;
    }

    public void setContextClass(String contextClass) {
        this.contextClass = contextClass;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Strategy.main(null); // opens the pattern input dialog
        logger.info("Strategy pattern input dialog invoked");
        try {
            //creates source files for Strategy pattern
            myCreator.createPattern(strategyInterface, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(strategy1, new HashSet<>(), myCreator.formatMethods(methodName), strategyInterface, config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(strategy2, new HashSet<>(), myCreator.formatMethods(methodName), strategyInterface, config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(contextClass, new HashSet<>(Arrays.asList(Helper.toMemberString(strategyInterface))), myCreator.formatMethods(methodName), null, config.getString("path.strategy-context-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
