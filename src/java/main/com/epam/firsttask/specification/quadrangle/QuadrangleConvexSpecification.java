package main.com.epam.firsttask.specification.quadrangle;

import main.com.epam.firsttask.action.figure.CheckIsQuadrangleIsConvexAction;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.specification.Specification;

public class QuadrangleConvexSpecification implements Specification {
    private final  CheckIsQuadrangleIsConvexAction checkIsQuadrangleIsConvexAction=new CheckIsQuadrangleIsConvexAction();
    @Override
    public boolean specify(Figure figure) {
        if(figure.getClass()== Quadrangle.class){
            return checkIsQuadrangleIsConvexAction.execute(((Quadrangle) figure));
        }
        return false;
    }
}
