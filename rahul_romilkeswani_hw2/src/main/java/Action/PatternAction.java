package Action;

import Creator.MyCreator;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

//abstract class which the individual patterns inherit.
public abstract class PatternAction extends AnAction {
    //initializing resources
    InputStream inStream = MyCreator.class.getClassLoader().getResourceAsStream("ConfigFiles/Values.conf");
    Reader reader = new InputStreamReader(inStream);
    Config config = ConfigFactory.parseReader(reader);
    InputStream inStream2 = MyCreator.class.getClassLoader().getResourceAsStream("application.conf");
    Reader reader2 = new InputStreamReader(inStream2);
    Config config2 = ConfigFactory.parseReader(reader2);
    MyCreator myCreator = new MyCreator();
    Logger logger = LoggerFactory.getLogger(PatternAction.class);

    //get workspace path for the launched instance and sets it as output directory
    public void setOutputDirectory(AnActionEvent e)
    {
        VirtualFile virtualFile = ModuleRootManager.getInstance(ModuleManager.getInstance(e.getProject()).getModules()[0]).getContentRoots()[0];
        String path = virtualFile.getPath();
        myCreator.setOutputDirectory(path+config2.getString("path.output-src"));
        logger.info("Output directory set");
    }



}
