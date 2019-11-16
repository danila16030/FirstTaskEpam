package com.epam.firsttask.comporator;

import com.epam.firsttask.action.figure.QuadrangleSquareAction;
import com.epam.firsttask.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleSquareCompare implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        QuadrangleSquareAction quadrangleSquareAction=new QuadrangleSquareAction();
        double firstSquare = quadrangleSquareAction.execute(o1);
        double secondSquare = quadrangleSquareAction.execute(o2);
        if (firstSquare < secondSquare) {
            return -1;
        } else if (firstSquare == secondSquare) {
            return 0;
        } else {
            return 1;
        }
    }
}
