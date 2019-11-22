package main.com.epam.firsttask.comporator;

import main.com.epam.firsttask.entity.Point;

import java.util.Comparator;

public class PointYCoordinateComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double firstY = o1.getY();
        double secondY = o2.getY();
        if (firstY < secondY) {
            return -1;
        } else if (firstY == secondY) {
            return 0;
        } else {
            return 1;
        }
    }
}
