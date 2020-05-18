package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class ProxyAction extends PatternAction {
    static private String abstractProxy;
    static private String methodName;
    static private String realClass;

    //setter methods for the fields
    public void setAbstractProxy(String abstractProxy) {
        this.abstractProxy = abstractProxy;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setRealClass(String realClass) {
        this.realClass = realClass;
    }

    public void setProxyClass(String proxyClass) {
        this.proxyClass = proxyClass;
    }

    static private String proxyClass;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Proxy.main(null); // opens the pattern input dialog
        logger.info("Proxy pattern input dialog invoked");
        try {
            //creates source files for Proxy pattern
            myCreator.createPattern(abstractProxy, new HashSet<>(), myCreator.formatMethods(methodName), null, config.getString("path.abstract-class-ftl"));
            myCreator.createPattern(realClass, new HashSet<>(), myCreator.formatMethods(methodName), abstractProxy, config.getString("path.concrete-class-ftl"));
            myCreator.createPattern(proxyClass, new HashSet<>(Arrays.asList(Helper.toMemberString(realClass))), myCreator.formatMethods(methodName), abstractProxy, config.getString("path.proxy-class-ftl"));

        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
