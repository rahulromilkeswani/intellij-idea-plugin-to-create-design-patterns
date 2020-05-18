package Test;

import Action.SingletonAction;
import org.junit.Test;

public class FormTest {
    @Test
    public void testFormAction()
    {
        SingletonAction singletonAction = new SingletonAction();
        singletonAction.setFieldName("myField");
        singletonAction.setClassName("Test");
    }

}
