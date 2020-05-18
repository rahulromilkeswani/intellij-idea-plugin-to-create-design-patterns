package Action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class TemplateAction extends PatternAction {
    static private String abstractClass;
    static private String methodName;
    static private String concreteClass;

    //setter methods for the fields
    public void setAbstractClass(String abstractClass) {
        this.abstractClass = abstractClass;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Template.main(null); //opens the pattern input dialog
        logger.info("Template pattern input dialog invoked");
        try {
            //creates source files for Template pattern
            myCreator.createPattern(abstractClass, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.template-abstract-class-ftl"));
            myCreator.createPattern(concreteClass, new HashSet<>(), myCreator.formatMethods(methodName), abstractClass, config.getString("path.template-concrete-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());

        }

    }
}
