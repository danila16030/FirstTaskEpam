package com.epam.firsttask.action.figure;

import com.epam.firsttask.entity.Circle;

public class CircleSquareAction implements Action<Double, Circle> {

    @Override
    public Double execute(Circle circle) {
        return Math.pow(circle.getRadius(), 2) * Math.PI;
    }
}
