package test.epam.firsttask.action.load;

import com.epam.firsttask.action.load.LineValidationAction;
import com.epam.firsttask.pattern.SetOfPatterns;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LineValidationActionTest {

    @Test
    public void testLineValidation() {
        LineValidationAction lineValidationAction = new LineValidationAction();
        boolean actualAnswer=lineValidationAction.circleComplianceCheck("1 2 3",SetOfPatterns.CIRCLE_PATTERN);
        Assert.assertSame(actualAnswer,true,"Error in figures are different");
    }
}
