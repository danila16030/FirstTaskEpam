package test.epam.firsttask.action.figure;

import main.com.epam.firsttask.action.figure.CheckIsQuadrangleRealQuadrangleAction;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.entity.Quadrangle;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckIsQuadrangleRealQuadrangleActionTest {
    @Test
    public void testCheckIsQuadrangleRealQuadrangle() {
        CheckIsQuadrangleRealQuadrangleAction checkIsQuadrangleRealQuadrangleAction =
                new CheckIsQuadrangleRealQuadrangleAction();
        Quadrangle quadrangle = new Quadrangle(123,new Point(1, 2), new Point(3, 4), new Point(5, 6),
                new Point(9, 2));
        boolean actualAnswer = checkIsQuadrangleRealQuadrangleAction.execute(quadrangle);
        assertTrue(actualAnswer, "Error quadrangle isn't real quadrangle");
    }
}
