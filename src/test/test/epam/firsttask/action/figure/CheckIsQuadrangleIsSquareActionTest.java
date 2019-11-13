package test.epam.firsttask.action.figure;

import com.epam.firsttask.action.figure.CheckIsQuadrangleIsSquareAction;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckIsQuadrangleIsSquareActionTest {
    @Test
    public void testCheckIsQuadrangleIsSquare(){
        CheckIsQuadrangleIsSquareAction checkIsQuadrangleIsSquareAction=new CheckIsQuadrangleIsSquareAction();
        Quadrangle quadrangle = new Quadrangle(new Point(1, 2), new Point(1, 6), new Point(5, 6),
                new Point(5, 2));
        boolean actualAnswer=checkIsQuadrangleIsSquareAction.execute(quadrangle);
        assertTrue(actualAnswer,"Error quadrangle isn't square");
    }
}
