package main.com.epam.firsttask.observer.repository;

import main.com.epam.firsttask.entity.Figure;

import java.util.EventObject;

public class FigureEvent extends EventObject {

    public FigureEvent(Figure source) {
        super(source);
    }

    @Override
    public Figure getSource() {
        return (Figure) super.getSource();
    }
}
