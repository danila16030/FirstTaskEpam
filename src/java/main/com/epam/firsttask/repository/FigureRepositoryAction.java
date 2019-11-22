package main.com.epam.firsttask.repository;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FigureRepositoryAction {
    private static Logger logger = LogManager.getLogger();

    private List<Figure> figureList;

    public void changeFirstPointInQuadrangle(Quadrangle quadrangle, Point point) {
        if (figureList.contains(quadrangle)) {
            int circlePosition = figureList.indexOf(quadrangle);
            ((Quadrangle) figureList.get(circlePosition)).setA(point);
            logger.info("change radius of " + quadrangle.toString());
        } else {
            logger.error("cannot find " + quadrangle.toString() + " in repository");
        }
    }

    public void changeCircleRadius(Circle circle, double radius) {
        if (figureList.contains(circle)) {
            int circlePosition = figureList.indexOf(circle);
            ((Circle) figureList.get(circlePosition)).setRadius(radius);
            logger.info("change radius of " + circle.toString());
        } else {
            logger.error("cannot find " + circle.toString() + " in repository");
        }
    }
}
