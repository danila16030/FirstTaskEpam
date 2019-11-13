package com.epam.firsttask.action.figure;

import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;

public class QuadranglePerimeterAction implements Action<Double, Quadrangle>{
    @Override
    public Double execute(Quadrangle quadrangle) {
        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();
        double x1 = a.getX();
        double y1 = a.getY();
        double x2 = b.getX();
        double y2 = b.getY();
        double x3 = c.getX();
        double y3 = c.getY();
        double x4 = d.getX();
        double y4 = d.getY();
        double d1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double d2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double d3 = Math.sqrt(Math.pow(x3 - x4, 2) + Math.pow(y3 - y4, 2));
        double d4 = Math.sqrt(Math.pow(x4 - x1, 2) + Math.pow(y4 - y1, 2));
        return d1 + d2 + d3 + d4;
    }
}
