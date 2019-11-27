package test.epam.firsttask.observer.storage;

import main.com.epam.firsttask.action.figure.CircleSquareAction;
import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.registrar.circle.CircleEvent;

import main.com.epam.firsttask.registrar.circle.CircleParameterRegistrar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParameterRegistrarTest {
    @Test
    public void testObserveOfCircle() {
        Circle circle = new Circle(1, new Point(2, 4), 3);
        Observer<CircleEvent> observer = CircleParameterRegistrar.getCircleStorage();
        circle.attach(observer);
        circle.setCenter(new Point(5, 9));
        circle.setId(25);
        CircleSquareAction circleSquareAction = new CircleSquareAction();
        double expectedAnswer = circleSquareAction.execute(circle);
        double actualAnswer = CircleParameterRegistrar.getMap().get(circle.getId()).getSquare();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
}
