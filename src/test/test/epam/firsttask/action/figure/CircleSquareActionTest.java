package test.epam.firsttask.action.figure;

import com.epam.firsttask.action.figure.CircleSquareAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleSquareActionTest {
    @DataProvider(name = "data")
    public Object[][] createData() {
        return new Object[][]{{7, 153.93}, {5.1, 81.71}, {2, 12.56}};
    }

    @Test(dataProvider = "data")
    public void testFindSquareOfCircle(double radius, double expectedAnswer) {
        CircleSquareAction circleSquareAction = new CircleSquareAction();
        Circle circle = new Circle(new Point(0, 0), radius);
        double actualAnswer = circleSquareAction.execute(circle);
        assertEquals(actualAnswer, expectedAnswer, 0.01, "Error in finding square circle");
    }
}
