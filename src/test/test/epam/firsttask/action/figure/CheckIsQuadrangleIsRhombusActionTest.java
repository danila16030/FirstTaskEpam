package test.epam.firsttask.action.figure;

import main.com.epam.firsttask.action.figure.CheckIsQuadrangleIsRhombusAction;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckIsQuadrangleIsRhombusActionTest {
    @Test
    public void testCheckIsQuadrangleIsRhombus(){
        CheckIsQuadrangleIsRhombusAction checkIsQuadrangleIsRhombusAction=new CheckIsQuadrangleIsRhombusAction();
        Quadrangle quadrangle = new Quadrangle(123,new Point(3, 6), new Point(5, 10), new Point(7, 6),
                new Point(5, 2));
        boolean actualAnswer=checkIsQuadrangleIsRhombusAction.execute(quadrangle);
        assertTrue(actualAnswer,"Error quadrangle isn't rhombus");

    }
}
