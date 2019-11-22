package test.epam.firsttask.action.figure;

import main.com.epam.firsttask.action.figure.CheckIsQuadrangleIsConvexAction;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CheckIsQuadrangleIsConvexActionTest {
    @Test
    public void testCheckIsQuadrangleIsConvex(){
        CheckIsQuadrangleIsConvexAction checkIsQuadrangleIsConvexAction=new CheckIsQuadrangleIsConvexAction();
        Quadrangle quadrangle = new Quadrangle(123,new Point(1, 2), new Point(1, 6), new Point(5, 6),
                new Point(5, 2));
        boolean actualAnswer=checkIsQuadrangleIsConvexAction.execute(quadrangle);
        assertTrue(actualAnswer,"Error quadrangle isn't convex");
    }
}
