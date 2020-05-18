package Action;

import Utility.Helper;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;

public class InterpreterAction extends PatternAction {
    static private String contextClass;
    static private String abstractClass;
    static private String nonTerminalClass;

    //setter methods for the fields
    public void setContextClass(String contextClass) {
        this.contextClass = contextClass;
    }

    public void setAbstractClass(String abstractClass) {
        this.abstractClass = abstractClass;
    }

    public void setNonTerminalClass(String nonTerminalClass) {
        this.nonTerminalClass = nonTerminalClass;
    }

    public void setTerminalClass(String terminalClass) {
        this.terminalClass = terminalClass;
    }


    static private String terminalClass;

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        setOutputDirectory(e);
        InputDialog.Interpreter.main(null); // opens the pattern input dialog
        logger.info("Interpreter pattern input dialog invoked");
        try {
            //creates source files for Interpreter pattern
            myCreator.createPattern(contextClass, new HashSet<>(), new HashSet<>(), null, config.getString("path.class-ftl"));
            myCreator.createPattern(abstractClass, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))), new HashSet<>(), null,
                    config.getString("path.interpreter-abstract-class-ftl"));
            myCreator.createPattern(nonTerminalClass, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))),
                    new HashSet<>(), abstractClass, config.getString("path.interpreter-nonterminal-class-ftl"));
            myCreator.createPattern(terminalClass, new HashSet<>(Arrays.asList(Helper.toMemberString(contextClass))), new HashSet<>(), abstractClass, config.getString("path.interpreter-terminal-class-ftl"));


        } catch (Exception ex) {
            logger.info(ex.toString());
        }
    }
}
