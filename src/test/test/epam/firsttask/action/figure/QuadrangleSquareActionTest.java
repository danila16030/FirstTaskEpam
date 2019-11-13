package test.epam.firsttask.action.figure;

import com.epam.firsttask.action.figure.QuadrangleSquareAction;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuadrangleSquareActionTest {
    @Test
    public void testFindSquareOfQuadrangle(){
        QuadrangleSquareAction quadrangleSquareAction=new QuadrangleSquareAction();
        Quadrangle quadrangle=new Quadrangle(new Point(1,2),new Point(1,6),new Point(9,6),
                new Point(9,2));
        double actualAnswer=quadrangleSquareAction.execute(quadrangle);
        assertEquals(actualAnswer,32,0.01,"Error in finding square of quadrangle");
    }
}
