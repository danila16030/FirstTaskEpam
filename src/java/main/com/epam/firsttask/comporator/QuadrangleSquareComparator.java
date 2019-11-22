package main.com.epam.firsttask.comporator;

import main.com.epam.firsttask.action.figure.QuadrangleSquareAction;
import main.com.epam.firsttask.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleSquareComparator implements Comparator<Quadrangle> {
    private QuadrangleSquareAction quadrangleSquareAction=new QuadrangleSquareAction();
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
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
