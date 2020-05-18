package Action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class MementoAction extends PatternAction {
    static private String originatorClass;
    static private String mementoClass;

    //setter methods for the fields
    public void setOriginatorClass(String originatorClass) {
        this.originatorClass = originatorClass;
    }

    public void setMementoClass(String mementoClass) {
        this.mementoClass = mementoClass;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Memento.main(null); // opens the pattern input dialog
        logger.info("Memento pattern input dialog invoked");
        try {
            //creates source files for Memento pattern
            myCreator.createPattern(originatorClass, new HashSet<>(), new HashSet<>(), mementoClass, config.getString("path.memento-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
