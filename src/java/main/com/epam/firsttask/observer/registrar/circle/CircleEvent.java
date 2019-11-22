package main.com.epam.firsttask.observer.registrar.circle;

import main.com.epam.firsttask.entity.Circle;

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
