package Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    //entry point to run all tests in the package
    public static void main(String args[]) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if(result.wasSuccessful()){
            System.out.println("All tests passed successfully");
        }
    }

}
