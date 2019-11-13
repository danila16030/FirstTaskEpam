package com.epam.firsttask.action.figure;

import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;

public class CheckIsQuadrangleIsConvexAction implements Action<Boolean, Quadrangle> {
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
        double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double bc = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double cd = Math.sqrt(Math.pow(x3 - x4, 2) + Math.pow(y3 - y4, 2));
        double ac = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double ad = Math.sqrt(Math.pow(x4 - x1, 2) + Math.pow(y4 - y1, 2));
        double bd = Math.sqrt(Math.pow(x4 - x2, 2) + Math.pow(y4 - y2, 2));
        double pDAB = (ab + ad + bd) / 2;
        double pDBC = (bc + cd + bd) / 2;
        double pDCA = (ac + cd + ad) / 2;
        double pABC = (ab + bc + ac) / 2;
        double squareDAB = Math.sqrt(pDAB * (pDAB - ab) * (pDAB - ad) * (pDAB - bd));
        double squareDBC = Math.sqrt(pDBC * (pDBC - bc) * (pDBC - cd) * (pDBC - bd));
        double squareDCA = Math.sqrt(pDCA * (pDCA - cd) * (pDCA - ac) * (pDCA - ad));
        double squareABC = Math.sqrt(pABC * (pABC - ab) * (pABC - bc) * (pABC - ac));
        return squareDAB + squareDBC + squareDCA > squareABC;
    }
}
