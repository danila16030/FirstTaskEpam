package com.epam.firsttask.observer.repository;

public interface FigureObservable {
    void attach(FigureObserver observer);

    void detach(FigureObserver observer);

    void notifyRepositoryObserver();
}
