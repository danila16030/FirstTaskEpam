package test.epam.firsttask.action.figure;

import main.com.epam.firsttask.entity.Point;

import main.com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import main.com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadranglePerimeterActionTest {
    @Test
    public void testFindPerimeterOfQuadrangle(){
        QuadranglePerimeterAction quadranglePerimeterAction=new QuadranglePerimeterAction();
        Quadrangle quadrangle=new Quadrangle(123,new Point(1,2),new Point(1,6),new Point(9,6),
                new Point(9,2));
        double actualAnswer=quadranglePerimeterAction.execute(quadrangle);
        assertEquals(actualAnswer,24,0.01,"Error in finding perimeter of quadrangle");
    }
}
