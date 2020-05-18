package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class IteratorAction extends PatternAction {
    static private String iteratorInterface;
    static private String aggregateInterface;
    static private String aggregateConcrete;
    static private String interatorConcrete;

    //setter methods for the fields
    public void setIteratorInterface(String iteratorInterface) {
        this.iteratorInterface = iteratorInterface;
    }

    public void setAggregateInterface(String aggregateInterface) {
        this.aggregateInterface = aggregateInterface;
    }

    public void setAggregateConcrete(String aggregateConcrete) {
        this.aggregateConcrete = aggregateConcrete;
    }

    public void setInteratorConcrete(String interatorConcrete) {
        this.interatorConcrete = interatorConcrete;
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Iterator.main(null); // opens the pattern input dialog
        logger.info("Iterator pattern input dialog invoked");
        try {
            //creates source files for Iterator pattern
            myCreator.createPattern(iteratorInterface, new HashSet<>(), new HashSet<>(), null, config.getString("path.iterator-interface-ftl"));
            myCreator.createPattern(aggregateInterface, new HashSet<>(Arrays.asList(Helper.toMemberString(iteratorInterface))), new HashSet<>(), null, config.getString("path.aggregate-interface-ftl"));
            myCreator.createPattern(aggregateConcrete, new HashSet<>(Arrays.asList(Helper.toMemberString(interatorConcrete))), new HashSet<>(), Helper.toParentString(aggregateInterface, iteratorInterface), config.getString("path.aggregate-concrete-class-ftl"));
        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
