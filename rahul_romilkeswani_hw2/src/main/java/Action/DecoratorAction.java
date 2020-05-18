package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class DecoratorAction extends PatternAction {
    static private String abstractComponent;
    static private String methodName;
    static private String componentClass;
    static private String abstractDecorator;
    static private String decorator1;

    //setter methods for the fields
    public void setAbstractComponent(String abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setComponentClass(String componentClass) {
        this.componentClass = componentClass;
    }

    public void setAbstractDecorator(String abstractDecorator) {
        this.abstractDecorator = abstractDecorator;
    }

    public void setDecorator1(String decorator1) {
        this.decorator1 = decorator1;
    }

    public void setDecorator2(String decorator2) {
        this.decorator2 = decorator2;
    }

    static private String decorator2;
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Decorator.main(null); // opens the pattern input dialog
        logger.info("Decorator pattern input dialog invoked");
        try {
            //creates source files for Decorator pattern
            myCreator.createPattern(abstractComponent,new HashSet<>(),myCreator.formatMethods(methodName),null,config.getString("path.abstract-class-ftl"));
            myCreator.createPattern(componentClass,new HashSet<>(),myCreator.formatMethods(methodName),abstractComponent,config.getString("path.concrete-class-ftl"));
            myCreator.createPattern(abstractDecorator,new HashSet<>(),myCreator.formatMethods(methodName),abstractComponent,config.getString("path.decorator-abstract-class-ftl"));
            myCreator.createPattern(decorator1,new HashSet<>(),myCreator.formatMethods(methodName), Helper.toParentString(abstractDecorator, abstractComponent), config.getString("path.decorator-concrete-class-ftl"));
            myCreator.createPattern(decorator2,new HashSet<>(),myCreator.formatMethods(methodName), Helper.toParentString(abstractDecorator, abstractComponent), config.getString("path.decorator-concrete-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
