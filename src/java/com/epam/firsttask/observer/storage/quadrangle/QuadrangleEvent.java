package com.epam.firsttask.observer.storage.quadrangle;

import com.epam.firsttask.entity.Quadrangle;

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
