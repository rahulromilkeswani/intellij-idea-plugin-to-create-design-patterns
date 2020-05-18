package Generator;

import Model.ClassModel;
import Parser.YamlParser;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


//handles the creation of the source java file
public class ClassGenerator {
    InputStream inStream = ClassGenerator.class.getClassLoader().getResourceAsStream("ConfigFiles/Values.conf");
    Reader reader = new InputStreamReader(inStream);
    Config config = ConfigFactory.parseReader(reader);
    static String outputDirectory ;
    final String yamlPath = "InputYaml.yaml";
    Configuration freemarkerConfig = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    static Logger logger = LoggerFactory.getLogger(ClassGenerator.class);

    //parses the ftl file and maps the elements to create the .java file
    public void createFile(String ftlPath) throws Exception {
        File output = new File(outputDirectory);
        final File yamlFile = new File(yamlPath);
        YamlParser yamlParser = new YamlParser();
        ClassModel classModel = yamlParser.readFile(yamlFile);
        ClassGenerator classGenerator = new ClassGenerator();
        classGenerator.generateSourceFile(classModel, output, (ftlPath));
        logger.info("Created .java file for " + classModel.getClassName());
    }

    //creates the filename.java using the FreeMarker Library
    public void generateSourceFile(ClassModel classModel, File yamlFileDirectory, String ftlPath) throws Exception {
        Map<String, Object> freemarkerDataModel = new HashMap<>();
        freemarkerConfig.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        Template template = freemarkerConfig.getTemplate(ftlPath);
        freemarkerDataModel.put(config.getString(("string.class-model-string")), classModel);
        File sourceFile = new File(yamlFileDirectory, classModel.getClassName() + config.getString("string.java-extension"));
        Writer sourceFileWriter = new FileWriter(sourceFile);
        template.process(freemarkerDataModel, sourceFileWriter);
    }

    public void setOutputDirectory(String path)
    {
        outputDirectory = path;
    }
}