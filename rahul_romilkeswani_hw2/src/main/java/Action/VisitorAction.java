package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class VisitorAction extends PatternAction {
    static private String abstractVisitor;
    static private String abstractElement;
    static private String element1;
    static private String element2;
    static private String visitorClass;

    //setter methods for the fields
    public void setAbstractVisitor(String abstractVisitor) {
        this.abstractVisitor = abstractVisitor;
    }

    public void setAbstractElement(String abstractElement) {
        this.abstractElement = abstractElement;
    }

    public void setElement1(String element1) {
        this.element1 = element1;
    }

    public void setElement2(String element2) {
        this.element2 = element2;
    }

    public void setVisitorClass(String visitorClass) {
        this.visitorClass = visitorClass;
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        HashSet<String> classNames = new HashSet<>();
        InputDialog.Visitor.main(null); // opens the pattern input dialog
        logger.info("Visitor pattern input dialog invoked");
        try {
            //creates source files for Visitor pattern
            myCreator.createPattern(abstractElement, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractVisitor))), new HashSet<>(), null, config.getString("path.element-abstract-class-ftl"));
            myCreator.createPattern(element1, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractVisitor))), new HashSet<>(), abstractElement, config.getString("path.element-concrete-class-ftl"));
            myCreator.createPattern(element2, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractVisitor))), new HashSet<>(), abstractElement, config.getString("path.element-concrete-class-ftl"));
            classNames.add(Helper.toMemberString(element1));
            classNames.add(Helper.toMemberString(element2));
            myCreator.createPattern(abstractVisitor, classNames, new HashSet<>(), null, config.getString("path.visitor-abstract-class-ftl"));
            myCreator.createPattern(visitorClass, new HashSet<>(classNames), new HashSet<>(), abstractVisitor, config.getString("path.visitor-concrete-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}