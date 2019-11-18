package com.epam.firsttask.repository;

import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.observer.repository.FigureEvent;
import com.epam.firsttask.observer.repository.FigureObservable;
import com.epam.firsttask.observer.repository.FigureObserver;
import com.epam.firsttask.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FigureRepository implements FigureObserver, FigureObservable {
    private List<Figure> figureList = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();

    public FigureRepository(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public List<Figure> query(Specification specification) {
        List<Figure> tempList = new ArrayList<>();
        for (Figure figure:figureList){
            if(specification.specify(figure)){
                tempList.add(figure);
            }
        }
        return tempList;
    }

    public void addFigure(Figure figure) {
        logger.info("add " + figure.toString());
        figureList.add(figure);
    }

    public void removeFigure(Figure figure) {
        if (figureList.contains(figure)) {
            figureList.remove(figure);
            logger.info("remove " + figure.toString());
        } else {
            logger.error("cannot find " + figure.toString() + " in repository");
        }
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    @Override
    public void actionPerformed(FigureEvent event) {
        if (!figureList.remove(event.getSource())) {
            figureList.add(event.getSource());
            logger.info("update " + event.getSource().toString());
        }
    }

    @Override
    public void attach(FigureObserver observer) {
        for (Figure figure : figureList) {
            if (figure.getClass() == Point.class) {
                ((Point) figure).attach(observer);
                logger.info("add observer for  " + figure.toString());
            } else if (figure.getClass() == Quadrangle.class) {
                ((Quadrangle) figure).attach(observer);
                logger.info("add observer for  " + figure.toString());
            } else if (figure.getClass() == Circle.class) {
                ((Circle) figure).attach(observer);
                logger.info("add observer for  " + figure.toString());
            }
        }
    }

    @Override
    public void detach(FigureObserver observer) {
        for (Figure figure : figureList) {
            if (figure.getClass() == Point.class) {
                ((Point) figure).detach(observer);
                logger.info("remove observer for  " + figure.toString());
            } else if (figure.getClass() == Quadrangle.class) {
                ((Quadrangle) figure).detach(observer);
                logger.info("remove observer for  " + figure.toString());
            } else if (figure.getClass() == Circle.class) {
                ((Circle) figure).detach(observer);
                logger.info("remove observer for  " + figure.toString());
            }
        }
    }

    @Override
    public void notifyRepositoryObserver() {

    }
}
