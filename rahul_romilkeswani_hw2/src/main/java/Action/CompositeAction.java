package Action;

import Creator.MyCreator;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class CompositeAction extends PatternAction {
    static private String abstractComponent;
    static private String childClass;
    static private String compositeClass;

    //setter methods for the fields
    public void setAbstractComponent(String abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }

    public void setCompositeClass(String compositeClass) {
        this.compositeClass = compositeClass;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        setOutputDirectory(e);
        MyCreator myCreator = new MyCreator();
        InputDialog.Composite.main(null);  // opens the pattern input dialog
        logger.info(" pattern input dialog invoked");
        try {
            //creates source files for Composite pattern
            myCreator.createPattern(abstractComponent,new HashSet<>(),new HashSet<>(),null,config.getString("path.component-abstract-class-ftl"));
            myCreator.createPattern(childClass,new HashSet<>(),new HashSet<>(),abstractComponent,config.getString("path.component-child-class-ftl"));
            myCreator.createPattern(compositeClass, new HashSet<>(), new HashSet<>(), abstractComponent, config.getString("path.composite-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
