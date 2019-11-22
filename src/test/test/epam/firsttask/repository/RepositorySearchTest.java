package test.epam.firsttask.repository;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.repository.FigureRepository;
import main.com.epam.firsttask.specification.figure.FigureIdSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositorySearchTest {
    @Test
    public void testSearchRepository(){
        List<Figure> testList=new ArrayList<>();
        testList.add(new Point(98,1,2));
        testList.add(new Point(78,1,2));
        testList.add(new Point(8,1,2));
        testList.add(new Point(2,1,2));
        FigureRepository figureRepository = new FigureRepository(testList);
        testList = figureRepository.query(new FigureIdSpecification(1, 50));
        int expectedAnswer=2;
        int actualAnswer=testList.size();
        Assert.assertSame(actualAnswer,expectedAnswer,"Error search  correct");
    }
}
