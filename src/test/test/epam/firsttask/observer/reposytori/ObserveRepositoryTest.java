package test.epam.firsttask.observer.reposytori;

import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.observer.repository.FigureObserver;
import com.epam.firsttask.repository.FigureRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ObserveRepositoryTest {
    @Test
    public void testObserver() {
        List<Figure> figureList = new ArrayList<>();
        Point point = new Point(55, 1, 2);
        FigureRepository figureRepository = new FigureRepository(figureList);
        FigureObserver first = figureRepository;
        figureList.add(point);
        figureRepository.attach(first);
        point.setId(85);
        int expectedAnswer = point.getId();
        Assert.assertSame(((Point) figureList.get(0)).getId(), expectedAnswer, "Error in observe figures in rep");
    }
}
