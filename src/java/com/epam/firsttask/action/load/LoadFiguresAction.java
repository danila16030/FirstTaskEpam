package com.epam.firsttask.action.load;


import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.exception.FileIsEmptyException;
import com.epam.firsttask.exception.TxtFileNotFoundException;
import com.epam.firsttask.exception.NotFoundFiguresException;
import com.epam.firsttask.pattern.SetOfPatterns;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LoadFiguresAction {
    private static Logger logger = LogManager.getLogger();
    private static CreateFigureFromLineAction createFigureFromLine = new CreateFigureFromLineAction();
    private static LineValidationAction lineValidationAction = new LineValidationAction();

    public List<Figure> loadFiguresFromFile(String filePath) throws FileIsEmptyException,
            TxtFileNotFoundException, NotFoundFiguresException {
        logger.info("loading figures from " + filePath);
        List<String> listOfLines = new ArrayList<>();
        List<Figure> listOfFigures = new ArrayList<>();
        boolean flag = checkFile(filePath);
        if (flag) {
            throw new TxtFileNotFoundException("Check file path");
        } else {
            Path path = Paths.get(filePath);
            try (Stream<String> stringStream = Files.lines(path)) {
                stringStream.forEach(listOfLines::add);
            } catch (IOException ex) {
                throw new FileIsEmptyException(ex);
            }
            for (String line : listOfLines) {
                if (lineValidationAction.pointComplianceCheck(line, SetOfPatterns.POINT_PATTERN)) {
                    Point point = createFigureFromLine.getPointFromLine(line);
                    listOfFigures.add(point);
                } else if (lineValidationAction.circleComplianceCheck(line, SetOfPatterns.CIRCLE_PATTERN)) {
                    Circle circle = createFigureFromLine.getCircleFromLine(line);
                    listOfFigures.add(circle);
                } else if (lineValidationAction.quadrangleComplianceCheck(line, SetOfPatterns.QUADRANGLE_PATTERN)) {
                    Quadrangle quadrangle = createFigureFromLine.getQuadrangleFromLine(line);
                    listOfFigures.add(quadrangle);
                } else {
                    logger.warn("incorrect line in position "+(listOfLines.lastIndexOf(line)+1));
                }
            }
            if (listOfFigures.isEmpty()) {
                logger.error("list of figures is empty");
                throw new NotFoundFiguresException("list of figures from file " + filePath + " is empty");
            }
           return listOfFigures;
        }
    }


    private boolean checkFile(String filePath) {
        File testFile = new File(filePath);
        if (testFile.length() == 0 || !testFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

}
