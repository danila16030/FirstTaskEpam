package main.com.epam.firsttask.comporator;

import main.com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import main.com.epam.firsttask.entity.Quadrangle;

import java.util.Comparator;

public class QuadranglePerimeterComparator implements Comparator<Quadrangle> {
   private  QuadranglePerimeterAction quadranglePerimeterAction=new QuadranglePerimeterAction();
    @Override
    public int compare(Quadrangle o1, Quadrangle o2) {
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
