package test.epam.firsttask.action.figure;

import main.com.epam.firsttask.action.figure.CheckIsQuadrangleIsTrapezoidAction;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckIsQuadrangleIsTrapezoidActionTest {
    @Test
    public void testCheckIsQuadrangleIsTrapezoid(){
        CheckIsQuadrangleIsTrapezoidAction checkIsQuadrangleIsTrapezoidAction=new CheckIsQuadrangleIsTrapezoidAction();
        Quadrangle quadrangle = new Quadrangle(123,new Point(1, 2), new Point(1, 6), new Point(5, 6),
                new Point(5, 2));
        boolean actualAnswer=checkIsQuadrangleIsTrapezoidAction.execute(quadrangle);
        assertTrue(actualAnswer,"Error quadrangle isn't trapezoid");
    }
}
