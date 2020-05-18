package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class AdapterAction extends PatternAction {
    //setter methods for the fields
    public void setAdapteeName(String adapteeName) {
        this.adapteeName = adapteeName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName;
    }

    static private String adapteeName;
    static private String methodName;
    static private String interfaceName;
    static private String adapterName;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Adapter.main(null); // opens the pattern input dialog
        logger.info("Adapter pattern input dialog invoked");

        try {
            //creates source files for Adapter pattern
            myCreator.createPattern(adapteeName, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.class-ftl"));
            myCreator.createPattern(interfaceName, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.interface-ftl"));
            myCreator.createPattern(adapterName, new HashSet<>(Arrays.asList(Helper.toMemberString(adapteeName))), myCreator.formatMethods(methodName), interfaceName, config.getString("path.object-adapter-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());

        }
    }
}
