package test.epam.firsttask.action.load;

import com.epam.firsttask.action.load.LoadFiguresAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.exception.FileIsEmptyException;
import com.epam.firsttask.exception.FileNotFoundException;
import com.epam.firsttask.exception.NotFoundFiguresException;
import com.epam.firsttask.observer.FigureObserver;
import com.epam.firsttask.repository.FigureRepository;
import com.epam.firsttask.specification.figure.FigureIdSpecification;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadFiguresActionTest {
    private static final String FILE_PATH = "src/test/resource/data/info.txt";

    @Test
    public void testLoadFiguresFromFile() throws FileNotFoundException, NotFoundFiguresException,
            FileIsEmptyException {
        LoadFiguresAction loadFiguresAction = new LoadFiguresAction();
        List<Figure> testList = loadFiguresAction.loadFiguresFromFile(FILE_PATH);
        assertNotNull(testList, "Error in loading figures from file");
    }
}
