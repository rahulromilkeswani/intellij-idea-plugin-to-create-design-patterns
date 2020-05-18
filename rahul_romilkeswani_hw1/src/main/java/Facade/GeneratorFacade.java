package Facade;

import Generator.ClassGenerator;
import Generator.YamlGenerator;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;

//Facade class to communicate with the generators
public class GeneratorFacade {
    InputStream inStream = GeneratorFacade.class.getClassLoader().getResourceAsStream("ConfigFiles/Values.conf");
    Reader reader = new InputStreamReader(inStream);
    Config config = ConfigFactory.parseReader(reader);
    final String yamlPath ;
    Logger logger = LoggerFactory.getLogger(GeneratorFacade.class);

    YamlGenerator yamlGenerator = new YamlGenerator();
    ClassGenerator classGenerator = new ClassGenerator();

    public GeneratorFacade() {
        logger.info("Generator Facade created");
        yamlPath = config.getString("path.yaml-input");

    }

    //method to invoke creation of .yaml and then the .java files
    public void createFiles(String className, HashSet<String> fieldList, HashSet<String> methodList, String parentName, String ftlPath)
            throws Exception {
        logger.info("Creating .yaml file for " + className);
        if (yamlGenerator.createFile(className, fieldList, methodList, parentName)) {
            logger.info("Creating .java file for " + className);
            classGenerator.createFile(ftlPath);
        }
    }
}
