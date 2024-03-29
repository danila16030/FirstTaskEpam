package test.epam.firsttask.action.load;

import main.com.epam.firsttask.action.loading.CreateFigureFromLineAction;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Point;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateFigureFromLineActionTest {

    @Test
    public void testCreateFigureFromLine() {
        CreateFigureFromLineAction createFigureFromLineAction = new CreateFigureFromLineAction();
        Figure actualAnswer = createFigureFromLineAction.getPointFromLine("1 2");
        Point point=new Point(1,2);
        Assert.assertSame(actualAnswer.getClass(), point.getClass(), "Error in creating figures from line");
    }
}
