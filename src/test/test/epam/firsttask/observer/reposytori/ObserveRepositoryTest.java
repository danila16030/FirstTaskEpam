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
        Circle circle = new Circle(55, new Point(1,2), 2);
        FigureRepository figureRepository = new FigureRepository(figureList);
        Observer<FigureEvent> first = figureRepository;
        figureList.add(circle);
        figureRepository.attach(first);
        circle.setId(85);
        int expectedAnswer = circle.getId();
        Assert.assertSame(( figureList.get(0)).getId(), expectedAnswer, "Error in observe figures in rep");
    }
}
