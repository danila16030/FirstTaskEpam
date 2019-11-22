package test.epam.firsttask.action.load;

import main.com.epam.firsttask.action.loading.LoadFiguresAction;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.exception.FileIsEmptyException;
import main.com.epam.firsttask.exception.TxtFileNotFoundException;
import main.com.epam.firsttask.exception.NotFoundFiguresException;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoadFiguresActionTest {
    private static final String FILE_PATH = "src/test/resource/data/info.txt";

    @Test
    public void testLoadFiguresFromFile() throws TxtFileNotFoundException, NotFoundFiguresException,
            FileIsEmptyException {
        LoadFiguresAction loadFiguresAction = new LoadFiguresAction();
        List<Figure> testList = loadFiguresAction.loadFiguresFromFile(FILE_PATH);
        assertNotNull(testList, "Error in loading figures from file");
    }
}
