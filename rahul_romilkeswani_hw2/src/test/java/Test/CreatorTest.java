package Test;

import Creator.MyCreator;
import Facade.GeneratorFacade;
import Generator.ClassGenerator;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CreatorTest {

    //test for format method
    @Test
    public void testFormatMethod(){
        MyCreator creator = new MyCreator();
        HashSet<String> actualResult = new HashSet<>();
        actualResult.add("getName String");
        actualResult.add("getPrice String");
        HashSet<String> result = creator.formatMethods("getName String;getPrice float");
        TreeSet<String> sortedActualResult = new TreeSet(actualResult);
        TreeSet<String> sortedResult =  new TreeSet(result);
        for (int i = 0; i < sortedResult.size(); i++) {
            assertEquals(sortedActualResult.iterator().next(),sortedResult.iterator().next());
        }
    }

    //test to check if file is correct generated in output directory
    @Test
    public void testCreator() throws Exception {
        InputStream inStream = ConfigTest.class.getClassLoader().getResourceAsStream("application.conf");
        Reader reader = new InputStreamReader(inStream);
        Config config = ConfigFactory.parseReader(reader);
        ClassGenerator classGenerator = new ClassGenerator();
        GeneratorFacade generatorFacade = new GeneratorFacade();
        classGenerator.setOutputDirectory(config.getString("path.output-directory")); //setting output directory
        generatorFacade.createFiles("MyClass",new HashSet<>(),new HashSet<>(),null,"FreemarkerFiles/Class.ftl");
        File file = new File(config.getString("path.output-directory")+"/MyClass.java");
        int result = 0;
        if(file.exists())
        {
            result = 1;
        }
        assertEquals(1,result);
    }


}
