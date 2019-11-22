package main.com.epam.firsttask.action.loading;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.entity.Point;

public class CreateFigureFromLineAction {
    public static final String SPLIT_REGEX = "\\s+";
    public Point getPointFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int id=Integer.parseInt(parameters[0]);
        double x = Double.parseDouble(parameters[1]);
        double y = Double.parseDouble(parameters[2]);
        return new Point(id,x, y);
    }

    public Circle getCircleFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int id=Integer.parseInt(parameters[0]);
        double x = Double.parseDouble(parameters[1]);
        double y = Double.parseDouble(parameters[2]);
        double radius = Double.parseDouble(parameters[3]);
        return new Circle(id,new Point(x, y), radius);
    }

    public Quadrangle getQuadrangleFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int id=Integer.parseInt(parameters[0]);
        double x1 = Double.parseDouble(parameters[1]);
        double y1 = Double.parseDouble(parameters[2]);
        double x2 = Double.parseDouble(parameters[3]);
        double y2 = Double.parseDouble(parameters[4]);
        double x3 = Double.parseDouble(parameters[5]);
        double y3 = Double.parseDouble(parameters[6]);
        double x4 = Double.parseDouble(parameters[7]);
        double y4 = Double.parseDouble(parameters[8]);
        return new Quadrangle(id,new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), new Point(x4, y4));
    }

}
