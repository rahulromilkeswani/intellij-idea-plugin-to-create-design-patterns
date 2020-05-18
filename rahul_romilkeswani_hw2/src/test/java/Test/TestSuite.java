package Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

//test suite which includes the other test classes

@Suite.SuiteClasses({
        ConfigTest.class,
        ConfigTest2.class,
        CreatorTest.class
})

public class TestSuite {
}