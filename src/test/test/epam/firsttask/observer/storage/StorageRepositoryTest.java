package test.epam.firsttask.observer.storage;

import com.epam.firsttask.action.figure.CircleSquareAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.observer.storage.circle.CircleObserver;
import com.epam.firsttask.storage.circle.CircleParameter;
import com.epam.firsttask.storage.circle.CircleStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StorageRepositoryTest {
    @Test
    public void testObserveOfCircle() {
        Circle circle = new Circle(1, new Point(2, 4), 3);
        CircleObserver observer = CircleStorage.getCircleStorage();
        circle.attach(observer);
        circle.setCenter(new Point(5, 9));
        CircleSquareAction circleSquareAction = new CircleSquareAction();
        double expectedAnswer = circleSquareAction.execute(circle);
        double actualAnswer = CircleStorage.getMap().get(circle.getId()).getSquare();
        Assert.assertEquals(actualAnswer, expectedAnswer);
    }
}
