package main.com.epam.firsttask.observer;

public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();
}
