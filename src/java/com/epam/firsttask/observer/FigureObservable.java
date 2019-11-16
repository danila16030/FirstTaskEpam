package com.epam.firsttask.observer;

public interface FigureObservable {
    void attach(FigureObserver observer);

    void detach(FigureObserver observer);

    void notifyObserver();
}
