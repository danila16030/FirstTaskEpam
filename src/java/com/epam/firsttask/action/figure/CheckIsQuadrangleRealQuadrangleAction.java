package com.epam.firsttask.action.figure;

import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;

public class CheckIsQuadrangleRealQuadrangleAction implements Action<Boolean, Quadrangle> {
    @Override
    public Boolean execute(Quadrangle quadrangle) {
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
        return (x3 - x1) / (x2 - x1) != (y3 - y1) / (y2 - y1) && (x4 - x1) / (x2 - x1) != (y4 - y1) / (y2 - y1);
    }
}
