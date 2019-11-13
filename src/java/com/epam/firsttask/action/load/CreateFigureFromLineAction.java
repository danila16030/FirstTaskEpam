package com.epam.firsttask.action.load;

import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;

public class CreateFigureFromLineAction {
    public static final String SPLIT_REGEX = "\\s+";
    public Point getPointFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        double x = Double.parseDouble(parameters[0]);
        double y = Double.parseDouble(parameters[1]);
        return new Point(x, y);
    }

    public Circle getCircleFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        double x = Double.parseDouble(parameters[0]);
        double y = Double.parseDouble(parameters[1]);
        double radius = Double.parseDouble(parameters[2]);
        return new Circle(new Point(x, y), radius);
    }

    public Quadrangle getQuadrangleFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        double x1 = Double.parseDouble(parameters[0]);
        double y1 = Double.parseDouble(parameters[1]);
        double x2 = Double.parseDouble(parameters[2]);
        double y2 = Double.parseDouble(parameters[3]);
        double x3 = Double.parseDouble(parameters[4]);
        double y3 = Double.parseDouble(parameters[5]);
        double x4 = Double.parseDouble(parameters[6]);
        double y4 = Double.parseDouble(parameters[7]);
        return new Quadrangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));
    }

}
