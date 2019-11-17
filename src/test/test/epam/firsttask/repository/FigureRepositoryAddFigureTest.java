package test.epam.firsttask.repository;

import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.repository.FigureRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FigureRepositoryAddFigureTest {
    @Test
    public void testAddRepositoryAction() {
        List<Figure> figureList = new ArrayList<>();
        Point point=new Point(1,2);
        FigureRepository figureRepository = new FigureRepository(figureList);
        figureRepository.addFigure(point);
        Assert.assertNotNull(figureRepository,"Error repository is empty");
    }
}
