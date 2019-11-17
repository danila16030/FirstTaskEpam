package com.epam.firsttask.observer.storage.circle;

public interface CircleObservable {
    void attach(CircleObserver observer);

    void detach(CircleObserver observer);

    void notifyStorageObserver();
}
