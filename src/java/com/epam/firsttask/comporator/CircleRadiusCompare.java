package com.epam.firsttask.comporator;

import com.epam.firsttask.entity.Circle;

import java.util.Comparator;

public class CircleRadiusCompare implements Comparator<Circle> {

    @Override
    public int compare(Circle o1, Circle o2) {
        double firstRadius = o1.getRadius();
        double secondRadius = o2.getRadius();
        if (firstRadius < secondRadius) {
            return -1;
        } else if (firstRadius == secondRadius) {
            return 0;
        } else {
            return 1;
        }
    }
}
