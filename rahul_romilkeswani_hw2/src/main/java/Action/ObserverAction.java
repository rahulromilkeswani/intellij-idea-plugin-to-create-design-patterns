package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class ObserverAction extends PatternAction {
    static private String abstractObserver;
    static private String abstractSubject;
    static private String concreteSubject;
    static private String observer1;
    static private String observer2;

    //setter methods for the fields
    public void setAbstractObserver(String abstractObserver) {
        this.abstractObserver = abstractObserver;
    }

    public void setAbstractSubject(String abstractSubject) {
        this.abstractSubject = abstractSubject;
    }

    public void setConcreteSubject(String concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    public void setObserver1(String observer1) {
        this.observer1 = observer1;
    }

    public void setObserver2(String observer2) {
        this.observer2 = observer2;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Observer.main(null); // opens the pattern input dialog
        logger.info("Observer pattern input dialog invoked");
        try {
            //creates source files for Observer pattern
            myCreator.createPattern(abstractObserver, new HashSet<>(), new HashSet<>(), null, config.getString("path.observer-abstract-class-ftl"));
            myCreator.createPattern(abstractSubject, new HashSet<>(), new HashSet<>(), abstractObserver, config.getString("path.subject-abstract-class-ftl"));
            myCreator.createPattern(concreteSubject, new HashSet<>(), new HashSet<>(), abstractSubject, config.getString("path.subject-concrete-class-ftl"));
            myCreator.createPattern(observer1, new HashSet<>(Arrays.asList(Helper.toMemberString(concreteSubject))), new HashSet<>(), abstractObserver, config.getString("path.observer-concrete-class-ftl"));
            myCreator.createPattern(observer2, new HashSet<>(Arrays.asList(Helper.toMemberString(concreteSubject))), new HashSet<>(), abstractObserver, config.getString("path.observer-concrete-class-ftl"));


        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
