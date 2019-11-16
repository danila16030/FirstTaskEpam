package com.epam.firsttask.specification.figure;

import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.entity.Point;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.specification.Specification;

public class FigureIdSpecification implements Specification {

    private int minBorder;
    private int manBorder;

    public FigureIdSpecification(int minBorder, int manBorder) {
        this.minBorder = minBorder;
        this.manBorder = manBorder;
    }

    @Override
    public boolean specify(Figure figure) {
        if(figure.getClass()== Quadrangle.class){
            int id=((Quadrangle) figure).getId();
            return id>this.minBorder&&id<this.manBorder;
        }else {
            if(figure.getClass()== Point.class){
                int id=((Point) figure).getId();
                return id>this.minBorder&&id<this.manBorder;
            }else if(figure.getClass()== Circle.class){
                int id=((Circle) figure).getId();
                return id>this.minBorder&&id<this.manBorder;
            }
        }
        return false;
    }
}
