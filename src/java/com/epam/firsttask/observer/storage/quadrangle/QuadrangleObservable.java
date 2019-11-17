package com.epam.firsttask.observer.storage.quadrangle;

public interface QuadrangleObservable {
    void attach(QuadrangleObserver observer);

    void detach(QuadrangleObserver observer);

    void notifyStorageObserver();
}
