package com.epam.firsttask.specification.circle;

import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.specification.Specification;

public class CircleRadiusSpecification implements Specification {

    private int minRadius;
    private int maxRadius;

    public CircleRadiusSpecification(int minRadius, int maxRadius) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
    }

    @Override
    public boolean specify(Figure figure) {
        if(figure.getClass()== Circle.class){
          double radius=((Circle) figure).getRadius();
          return radius<maxRadius&&radius>minRadius;
        }
        return false;
    }
}
