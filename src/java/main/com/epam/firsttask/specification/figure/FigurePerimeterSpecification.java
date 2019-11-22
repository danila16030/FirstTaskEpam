package main.com.epam.firsttask.specification.figure;

import main.com.epam.firsttask.action.figure.CirclePerimeterAction;
import main.com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.specification.Specification;

public class FigurePerimeterSpecification implements Specification {
    private int minPerimeter;
    private int maxPerimeter;

    public FigurePerimeterSpecification(int minPerimeter, int maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Figure figure) {
        if (figure.getClass() == Point.class) {
            return false;
        } else if (figure.getClass() == Circle.class) {
            CirclePerimeterAction perimeterAction = new CirclePerimeterAction();
            double square = perimeterAction.execute((Circle) figure);
            return this.minPerimeter <= square && this.maxPerimeter >= square;
        } else if (figure.getClass() == Quadrangle.class) {
            QuadranglePerimeterAction quadranglePerimeterAction = new QuadranglePerimeterAction();
            double square = quadranglePerimeterAction.execute((Quadrangle) figure);
            return this.minPerimeter <= square && this.maxPerimeter >= square;
        }
        return false;
    }
}
