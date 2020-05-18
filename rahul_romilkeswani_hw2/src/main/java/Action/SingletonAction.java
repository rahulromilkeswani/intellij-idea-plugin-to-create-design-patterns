package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;


public class SingletonAction extends PatternAction {
    static private String className;
    static private String fieldName;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Singleton.main(null); // opens the pattern input dialog
        logger.info("Singleton pattern input dialog invoked");
        try {
            //creates source files for Singleton pattern
            myCreator.createPattern(className, new HashSet(Arrays.asList(Helper.toMemberString(fieldName))), new HashSet<>(), null, config.getString("path.singleton-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }

    //setter methods for the fields
    public void setClassName(String className) {
        this.className = className;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}


