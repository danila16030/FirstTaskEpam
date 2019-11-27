package main.com.epam.firsttask.observer;

public interface Observable<E> {
    void attach(Observer<E> observer);

    void detach(Observer<E> observer);

    void notifyObserver();
}
