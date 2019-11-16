package test.epam.firsttask.action.figure;

import com.epam.firsttask.action.figure.CirclePerimeterAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CirclePerimeterActionTest {
    @DataProvider(name = "data")
    public Object[][] createData() {
        return new Object[][]{{7, 43.98}, {5.1, 32.04}, {2, 12.56}};
    }

    @Test(dataProvider = "data")
    public void testFindPerimeterOfCircle(double radius,double expectedAnswer){
        CirclePerimeterAction circlePerimeterAction=new CirclePerimeterAction();
        Circle circle=new Circle(123,new Point(0,0),radius);
        double actualAnswer= circlePerimeterAction.execute(circle);
        assertEquals(actualAnswer, expectedAnswer, 0.01, "Error in finding perimeter circle");
    }
}
