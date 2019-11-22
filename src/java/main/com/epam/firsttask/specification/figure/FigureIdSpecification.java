package main.com.epam.firsttask.specification.figure;

import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.entity.Figure;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.entity.Point;
import main.com.epam.firsttask.specification.Specification;

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
            int id=figure.getId();
            return id>=this.minBorder&&id<=this.manBorder;
        }else {
            if(figure.getClass()== Point.class){
                int id=figure.getId();
                return id>=this.minBorder&&id<=this.manBorder;
            }else if(figure.getClass()== Circle.class){
                int id=figure.getId();
                return id>=this.minBorder&&id<=this.manBorder;
            }
        }
        return false;
    }
}
