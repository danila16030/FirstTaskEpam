package com.epam.firsttask.specification.figure;

import com.epam.firsttask.action.figure.CircleSquareAction;
import com.epam.firsttask.action.figure.QuadrangleSquareAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.specification.Specification;

public class FigureSquareSpecification implements Specification {
    private double minSquare;
    private double maxSquare;

    public FigureSquareSpecification(double minSquare, double maxSquare) {
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    @Override
    public boolean specify(Figure figure) {
        if (figure.getClass()== Point.class){
            return false;
        }else if (figure.getClass()== Circle.class){
            CircleSquareAction squareAction=new CircleSquareAction();
            double square=squareAction.execute((Circle) figure);
            return this.minSquare < square && this.maxSquare > square;
        }else if (figure.getClass()== Quadrangle.class){
            QuadrangleSquareAction quadrangleSquareAction=new QuadrangleSquareAction();
            double square=quadrangleSquareAction.execute((Quadrangle) figure);
            return this.minSquare < square && this.maxSquare > square;
        }
        return false;
    }
}
