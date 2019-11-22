package test.epam.firsttask.action.load;

import main.com.epam.firsttask.action.loading.LineValidationAction;
import main.com.epam.firsttask.pattern.SetOfPatterns;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LineValidationActionTest {

    @Test
    public void testLineValidation() {
        LineValidationAction lineValidationAction = new LineValidationAction();
        boolean actualAnswer=lineValidationAction.circleComplianceCheck("1 2 3",SetOfPatterns.CIRCLE_PATTERN);
        Assert.assertSame(actualAnswer,true,"Error  figures are different");
    }
}
