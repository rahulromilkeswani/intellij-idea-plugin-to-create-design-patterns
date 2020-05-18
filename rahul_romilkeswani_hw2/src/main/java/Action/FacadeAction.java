package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class FacadeAction extends PatternAction {
    static private String class1;
    static private String class1Method;
    static private String class2;
    static private String class2Method;
    static private String abstractFacade;
    static private String facadeMethod;

    //setter methods for the fields
    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public void setClass1Method(String class1Method) {
        this.class1Method = class1Method;
    }

    public void setClass2(String class2) {
        this.class2 = class2;
    }

    public void setClass2Method(String class2Method) {
        this.class2Method = class2Method;
    }

    public void setAbstractFacade(String abstractFacade) {
        this.abstractFacade = abstractFacade;
    }

    public void setFacadeMethod(String facadeMethod) {
        this.facadeMethod = facadeMethod;
    }

    public void setFacadeClass(String facadeClass) {
        this.facadeClass = facadeClass;
    }

    static private String facadeClass;
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Facade.main(null); // opens the pattern input dialog
        logger.info("Facade pattern input dialog invoked");
        try {
            //creates source files for Facade pattern
            HashSet<String> classNames = new HashSet<>();
            myCreator.createPattern(class1,new HashSet<>(),myCreator.formatMethods(class1Method),null,config.getString("path.class-ftl"));
            myCreator.createPattern(class2,new HashSet<>(),myCreator.formatMethods(class2Method),null,config.getString("path.class-ftl"));
            classNames.add(Helper.toMemberString(class1));
            classNames.add(Helper.toMemberString(class2));
            myCreator.createPattern(abstractFacade,new HashSet<>(),myCreator.formatMethods(facadeMethod),null,config.getString("path.abstract-class-ftl"));
            myCreator.createPattern(facadeClass,classNames,myCreator.formatMethods(facadeMethod),abstractFacade,config.getString("path.facade-concrete-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
