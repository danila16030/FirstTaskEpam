package main.com.epam.firsttask.action.figure;

import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.entity.Point;

public class CheckIsQuadrangleIsTrapezoidAction implements Action<Boolean, Quadrangle> {
    @Override
    public Boolean execute(Quadrangle quadrangle) {
        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();
        double y1 = a.getY();
        double y2 = b.getY();
        double y3 = c.getY();
        double y4 = d.getY();
      return y1==y4&&y2==y3;
    }
}
