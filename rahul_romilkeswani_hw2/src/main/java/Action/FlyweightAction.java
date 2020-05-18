package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class FlyweightAction extends PatternAction {
    static private String flyweightInterface;
    static private String methodName;
    static private String flyweightClass;

    //setter methods for the fields
    public void setFlyweightInterface(String flyweightInterface) {
        this.flyweightInterface = flyweightInterface;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setFlyweightClass(String flyweightClass) {
        this.flyweightClass = flyweightClass;
    }

    public void setFlyweightFactory(String flyweightFactory) {
        this.flyweightFactory = flyweightFactory;
    }

    static private String flyweightFactory;
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Flyweight.main(null); // opens the pattern input dialog
        logger.info("Flyweight pattern input dialog invoked");
        try {
            //creates source files for Flyweight pattern
            myCreator.createPattern(flyweightInterface,new HashSet<>(),myCreator.formatMethods(methodName),null,config.getString("path.interface-ftl"));
            myCreator.createPattern(flyweightClass,new HashSet<>(),myCreator.formatMethods(methodName),flyweightInterface,config.getString("path.flyweight-concrete-class-ftl"));
            myCreator.createPattern(flyweightFactory,new HashSet<>(Arrays.asList(Helper.toMemberString(flyweightClass))),new HashSet<>(),flyweightInterface,config.getString("path.flyweight-factory-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
