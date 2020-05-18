package Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConfigTest {
    InputStream inStream = ConfigTest.class.getClassLoader().getResourceAsStream("ConfigFiles/Values.conf");
    Reader reader = new InputStreamReader(inStream);
    Config config = ConfigFactory.parseReader(reader);

    //test for config values of hw1
    @Test
    public void testConfigValues(){
        assertEquals(config.getString("path.yaml-input"),"YamlFiles/YamlInput.yaml");
        assertNotEquals(config.getString("path.yaml-input"),"Hello world");
    }

    //test if exception is thrown for incorrect paths in .conf of hw1
    @Test(expected = Exception.class)
    public void checkException() {
        config.getString("path.test");
    }

}

