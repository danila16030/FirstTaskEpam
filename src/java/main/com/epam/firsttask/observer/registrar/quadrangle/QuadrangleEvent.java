package main.com.epam.firsttask.observer.registrar.quadrangle;

import main.com.epam.firsttask.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {
    public QuadrangleEvent(Quadrangle source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle) super.getSource();
    }
}
