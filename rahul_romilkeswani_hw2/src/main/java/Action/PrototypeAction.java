package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class PrototypeAction extends PatternAction {
    static private String objectInterface;
    static private String methodName;
    static private String prototypeInterface;
    static private String concreteClass;

    //setter methods for the fields
    public void setObjectInterface(String objectInterface) {
        this.objectInterface = objectInterface;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setPrototypeInterface(String prototypeInterface) {
        this.prototypeInterface = prototypeInterface;
    }

    public void setConcreteClass(String concreteClass) {
        this.concreteClass = concreteClass;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e)
    {
        setOutputDirectory(e);
        InputDialog.Prototype.main(null); // opens the pattern input dialog
        logger.info("Prototype pattern input dialog invoked");
        try {
            //creates source files for Prototype pattern
            myCreator.createPattern(objectInterface, new HashSet<>(),myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(prototypeInterface, new HashSet<>(), new HashSet<>(Arrays.asList(Helper.toFieldString(config.getString("string.clone-text"), objectInterface))), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(concreteClass, new HashSet<>(), myCreator.formatMethods(methodName), Helper.toParentString(objectInterface, prototypeInterface), config.getString("path.prototype-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
