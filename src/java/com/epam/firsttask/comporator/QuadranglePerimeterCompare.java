package com.epam.firsttask.comporator;

import com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import com.epam.firsttask.entity.Quadrangle;

import java.util.Comparator;

public class QuadranglePerimeterCompare implements Comparator<Quadrangle> {
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
        QuadranglePerimeterAction quadranglePerimeterAction=new QuadranglePerimeterAction();
        double firstPerimeter = quadranglePerimeterAction.execute(o1);
        double secondPerimeter = quadranglePerimeterAction.execute(o2);
        if (firstPerimeter < secondPerimeter) {
            return -1;
        } else if (firstPerimeter == secondPerimeter) {
            return 0;
        } else {
            return 1;
        }
    }
}
