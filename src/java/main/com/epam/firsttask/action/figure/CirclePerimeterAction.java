package main.com.epam.firsttask.action.figure;

import main.com.epam.firsttask.entity.Circle;

public class CirclePerimeterAction implements Action<Double, Circle> {
    @Override
    public Double execute(Circle circle) {
        return Math.PI * 2 * circle.getRadius();
    }
}
