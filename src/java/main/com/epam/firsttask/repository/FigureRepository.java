package main.com.epam.firsttask.repository;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.observer.Observable;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.repository.FigureEvent;

import main.com.epam.firsttask.specification.Specification;
import main.com.epam.firsttask.specification.figure.FigureIdSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class FigureRepository implements Observer<FigureEvent>, Observable {
    private List<Figure> figureList = new ArrayList<Figure>();
    private static Logger logger = LogManager.getLogger();

    public FigureRepository(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public List<Figure> query(Specification specification) {
        List<Figure> tempList = new ArrayList<>();
        for (Figure figure : figureList) {
            if (specification.specify(figure)) {
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
        Figure figure = event.getSource();
        int id = figure.getId();
        if (query(new FigureIdSpecification(id, id)) != null) {
            figureList.remove(figure);
            figureList.add(figure);
            logger.info("update " + event.getSource().toString());
        } else {
            figureList.add(figure);
            logger.info("add new " + event.getSource().toString());
        }
    }


    @Override
    public void attach(Observer observer) {
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
    public void detach(Observer observer) {
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
    public void notifyObserver() {

    }
}
