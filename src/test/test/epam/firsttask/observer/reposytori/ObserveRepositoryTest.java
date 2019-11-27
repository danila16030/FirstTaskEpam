package test.epam.firsttask.observer.reposytori;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Point;

import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.repository.FigureEvent;
import main.com.epam.firsttask.repository.FigureRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ObserveRepositoryTest {
    @Test
    public void testObserver() {
        List<Figure> figureList = new ArrayList<>();
        Point point = new Point(9, 85, 2);
        Point point2 = new Point(19, 120, 2);
        FigureRepository figureRepository = new FigureRepository(figureList);
        Observer<FigureEvent> first = figureRepository;
        figureList.add(point);
        figureList.add(point2);
        figureRepository.attach(first);
        point.setId(85);
        int expectedAnswer = point.getId();
        Assert.assertSame((figureList.get(0)).getId(), expectedAnswer, "Error in observe figures in rep");
    }
}
