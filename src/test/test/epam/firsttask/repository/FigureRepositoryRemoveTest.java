package test.epam.firsttask.repository;

import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.repository.FigureRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureRepositoryRemoveTest {
    @Test
    public void testRemove() {
        List<Figure> figureList = new ArrayList<>();
        Point point = new Point(1, 2);
        figureList.add(point);
        FigureRepository figureRepository = new FigureRepository(figureList);
        figureRepository.removeFigure(point);
        int expectedAnswer = 0;
        int actualAnswer=figureRepository.getFigureList().size();
        Assert.assertEquals(actualAnswer,expectedAnswer, "Error figure isn't remove");
    }
}
