package main.com.epam.firsttask.comporator;

import main.com.epam.firsttask.entity.Point;

import java.util.Comparator;

public class PointXCoordinateComparator implements Comparator<Point> {


    @Override
    public int compare(Point o1, Point o2) {
        double firstX = o1.getX();
        double secondX = o2.getX();
        if (firstX < secondX) {
            return -1;
        } else if (firstX == secondX) {
            return 0;
        } else {
            return 1;
        }
    }
}
