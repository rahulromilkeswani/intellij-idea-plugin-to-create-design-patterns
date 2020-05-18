package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class MediatorAction extends PatternAction {
    static private String abstractMediator;
    static private String abstractColleague;
    static private String colleague1;
    static private String colleague2;
    static private String mediator;

    //setter methods for the fields
    public void setAbstractMediator(String abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

    public void setAbstractColleague(String abstractColleague) {
        this.abstractColleague = abstractColleague;
    }

    public void setColleague1(String colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(String colleague2) {
        this.colleague2 = colleague2;
    }

    public void setMediator(String mediator) {
        this.mediator = mediator;
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Mediator.main(null); // opens the pattern input dialog
        logger.info("Mediator pattern input dialog invoked");
        try {
            //creates source files for Mediator pattern
            HashSet<String> classNames = new HashSet<>();
            classNames.add(Helper.toMemberString(colleague1));
            classNames.add(Helper.toMemberString(colleague2));
            myCreator.createPattern(abstractColleague, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractMediator))), new HashSet<>(), null, config.getString("path.mediator-abstract-class-ftl"));
            myCreator.createPattern(colleague1, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractMediator))), new HashSet<>(), abstractColleague, config.getString("path.mediator-concrete-class-ftl"));
            myCreator.createPattern(colleague2, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractMediator))), new HashSet<>(), abstractColleague, config.getString("path.mediator-concrete-class-ftl"));
            myCreator.createPattern(abstractMediator, new HashSet<>(Arrays.asList(Helper.toMemberString(abstractColleague))), new HashSet<>(), null, config.getString("path.colleague-abstract-class-ftl"));
            myCreator.createPattern(mediator, classNames, new HashSet<>(), Helper.toParentString(abstractMediator, abstractColleague), config.getString("path.colleague-concrete-class-ftl"));


        } catch (Exception ex) {
            logger.info(ex.toString());
        }

    }
}
