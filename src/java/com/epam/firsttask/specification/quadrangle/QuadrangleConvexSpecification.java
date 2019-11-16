package com.epam.firsttask.specification.quadrangle;

import com.epam.firsttask.action.figure.CheckIsQuadrangleIsConvexAction;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.specification.Specification;

public class QuadrangleConvexSpecification implements Specification {

    @Override
    public boolean specify(Figure figure) {
        if(figure.getClass()==Quadrangle.class){
            CheckIsQuadrangleIsConvexAction checkIsQuadrangleIsConvexAction=new CheckIsQuadrangleIsConvexAction();
            return checkIsQuadrangleIsConvexAction.execute(((Quadrangle) figure));
        }
        return false;
    }
}
