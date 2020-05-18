package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class BuilderAction extends PatternAction {
    static private String interfaceName;
    static private String methodName;
    static private String class1;
    static private String class2;

    //setter methods for the fields
    public  void setInterfaceName(String interfaceName) {
        BuilderAction.interfaceName = interfaceName;
    }

    public void setMethodName(String methodName) {
        BuilderAction.methodName = methodName;
    }

    public void setClass1(String class1) {
        BuilderAction.class1 = class1;
    }

    public void setClass2(String class2) {
        BuilderAction.class2 = class2;
    }

    public void setComplexObject(String complexObject) {
        BuilderAction.complexObject = complexObject;
    }

    public void setBuilderInterface(String builderInterface) {
        BuilderAction.builderInterface = builderInterface;
    }

    public void setBuilder(String builder) {
        BuilderAction.builder = builder;
    }

    static private String complexObject;
    static private String builderInterface;
    static private String builder;


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Builder.main(null); // opens the pattern input dialog
        logger.info("Builder pattern input dialog invoked");
        HashSet<String> builderMethods = new HashSet<>();
        try {
            //creates source files for Builder pattern
            myCreator.createPattern(interfaceName, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(class1, new HashSet<>(), myCreator.formatMethods(methodName), interfaceName, config.getString("path.implementor-class-ftl"));
            myCreator.createPattern(class2, new HashSet<>(), myCreator.formatMethods(methodName), interfaceName, config.getString("path.implementor-class-ftl"));
            builderMethods.add(Helper.toMemberString(class1));
            builderMethods.add(Helper.toMemberString(class2));
            myCreator.createPattern(complexObject, new HashSet<>(Arrays.asList(Helper.toMemberString(interfaceName))), new HashSet<>(), null, config.getString("path.builder-complex-object-ftl"));
            myCreator.createPattern(builderInterface, new HashSet<>(Arrays.asList(Helper.toMemberString(complexObject))), builderMethods, null, config.getString("path.builder-interface-ftl"));
            myCreator.createPattern(builder, new HashSet<>(Arrays.asList(Helper.toMemberString(complexObject))), builderMethods,builderInterface, config.getString("path.builder-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}