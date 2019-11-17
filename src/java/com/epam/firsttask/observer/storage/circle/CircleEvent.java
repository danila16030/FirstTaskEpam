package com.epam.firsttask.observer.storage.circle;

import com.epam.firsttask.entity.Circle;

import java.util.EventObject;

public class CircleEvent extends EventObject {

    public CircleEvent(Object source) {
        super(source);
    }
    @Override
    public Circle getSource() {
        return (Circle) super.getSource();
    }
}
