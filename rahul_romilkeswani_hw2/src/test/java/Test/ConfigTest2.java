package Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ConfigTest2 {
    InputStream inStream = ConfigTest.class.getClassLoader().getResourceAsStream("application.conf");
    Reader reader = new InputStreamReader(inStream);
    Config config = ConfigFactory.parseReader(reader);

    //test for application.conf
    @Test
    public void testConfigValues(){
        assertEquals(config.getString("path.test"),"Test");
        assertNotEquals(config.getString("path.test"),"Hello world");
    }

    //test for exception in case of incorrect path
    @Test(expected = Exception.class)
    public void checkException()
    {
        config.getString("path.class-ftl");
    }
}