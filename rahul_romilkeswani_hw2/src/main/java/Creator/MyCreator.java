package Creator;

import Facade.GeneratorFacade;
import Generator.ClassGenerator;
import Parser.YamlParser;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashSet;

public class MyCreator {
    Logger logger = LoggerFactory.getLogger(MyCreator.class); //initializing logger
    static String outputDirectory;
    public void createPattern(String className, HashSet<String> fields, HashSet<String> methods,String parentName, String ftlPath) throws Exception {
        //Initializing config
        InputStream inStream = MyCreator.class.getClassLoader().getResourceAsStream("application.conf");
        Reader reader = new InputStreamReader(inStream);
        Config config = ConfigFactory.parseReader(reader);
        logger.info("Read config");

        //Initializing Generators of Hw1
        GeneratorFacade generatorFacade = new GeneratorFacade();
        YamlParser yamlParser = new YamlParser();
        ClassGenerator classGenerator = new ClassGenerator();

        classGenerator.setOutputDirectory(outputDirectory); //setting output directory
        generatorFacade.createFiles(className,fields,methods,parentName,ftlPath); //call to actual creator of Hw1
        logger.info("Source file created for "+className);
    }

    //utility method
    public HashSet<String> formatMethods(String methods)
    {
        String[] methodsList = methods.split(";");
        return new HashSet<>(Arrays.asList(methodsList));
    }

    public void setOutputDirectory(String path)
    {
        outputDirectory = path;
    }
}
