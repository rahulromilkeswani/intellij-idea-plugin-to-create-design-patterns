package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class FactoryMethodAction extends PatternAction {
    static private String factoryInterfaceObject;
    static private String methodName;
    static private String class1;
    static private String class2;
    static private String abstractFactory;
    static private String factoryClass;
    static private String createdObject;

    //setter methods for the fields
    public  void setFactoryInterfaceObject(String factoryInterfaceObject) {
        FactoryMethodAction.factoryInterfaceObject = factoryInterfaceObject;
    }

    public  void setMethodName(String methodName) {
        FactoryMethodAction.methodName = methodName;
    }

    public void setClass1(String class1) {
        FactoryMethodAction.class1 = class1;
    }

    public void setClass2(String class2) {
        FactoryMethodAction.class2 = class2;
    }

    public void setAbstractFactory(String abstractFactory) {
        FactoryMethodAction.abstractFactory = abstractFactory;
    }

    public void setFactoryClass(String factoryClass) {
        FactoryMethodAction.factoryClass = factoryClass;
    }

    public void setCreatedObject(String createdObject) {
        FactoryMethodAction.createdObject = createdObject;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.FactoryMethod.main(null); // opens the pattern input dialog
        logger.info("Factory method pattern input dialog invoked");
        try {
            //creates source files for Factory Method pattern
            myCreator.createPattern(factoryInterfaceObject,new HashSet<>(),myCreator.formatMethods(methodName),null,config.getString("path.interface-ftl"));
            myCreator.createPattern(class1,new HashSet<>(),myCreator.formatMethods(methodName),factoryInterfaceObject,config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(class2,new HashSet<>(),myCreator.formatMethods(methodName),factoryInterfaceObject,config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(abstractFactory, new HashSet<>(), new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.factory-method-text"),factoryInterfaceObject))),null,config.getString("path.abstract-class-ftl"));
            myCreator.createPattern(factoryClass, new HashSet<>(Arrays.asList(Helper.toMemberString(createdObject))),
                    new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.factory-method-text"),factoryInterfaceObject))), abstractFactory, config.getString("path.factory-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
