package Action;

import Creator.MyCreator;
import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class AbstractFactoryAction extends PatternAction {
    //setter methods for the fields
    public void setObject1(String object1) {
        this.object1 = object1;
    }

    public void setObject1Methods(String object1Methods) {
        this.object1Methods = object1Methods;
    }

    public void setClassName1(String className1) {
        this.className1 = className1;
    }

    public void setObject2(String object2) {
        this.object2 = object2;
    }

    public void setObject2Methods(String object2Methods) {
        this.object2Methods = object2Methods;
    }

    public void setClassName2(String className2) {
        this.className2 = className2;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    static private String object1;
    static private String object1Methods;
    static private String className1;
    static private String object2;
    static private String object2Methods;
    static private String className2;
    static private String interfaceName;
    static private String factoryName;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        MyCreator myCreator = new MyCreator();
        InputDialog.AbstractFactory.main(null); // opens the pattern input dialog
        logger.info("Abstract factory pattern input dialog invoked");
        try {
            //creates source files for Abstract Factory pattern
            HashSet<String> objectsType = new HashSet<>();
            myCreator.createPattern(object1,new HashSet<>(),myCreator.formatMethods(object1Methods),null,config.getString("path.interface-ftl"));
            myCreator.createPattern(className1,new HashSet<>(),myCreator.formatMethods(object1Methods),object1,config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(object2,new HashSet<>(),myCreator.formatMethods(object2Methods),null,config.getString("path.interface-ftl"));
            myCreator.createPattern(className2,new HashSet<>(),myCreator.formatMethods(object2Methods),object2,config.getString("path.implementor-class-ftl"));
            objectsType.add(Helper.toFieldString(className1, object1));
            objectsType.add(Helper.toFieldString(className2, object2));
            myCreator.createPattern(interfaceName,new HashSet<>(),objectsType,null,config.getString("path.abstract-factory-interface-ftl"));
            myCreator.createPattern(factoryName,new HashSet<>(),objectsType,interfaceName,config.getString("path.abstract-factory-concrete-ftl"));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
}
