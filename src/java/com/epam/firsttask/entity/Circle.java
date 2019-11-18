package com.epam.firsttask.entity;

import com.epam.firsttask.observer.repository.FigureEvent;
import com.epam.firsttask.observer.repository.FigureObservable;
import com.epam.firsttask.observer.repository.FigureObserver;
import com.epam.firsttask.observer.storage.circle.CircleEvent;
import com.epam.firsttask.observer.storage.circle.CircleObservable;
import com.epam.firsttask.observer.storage.circle.CircleObserver;

public class Circle implements FigureObservable, CircleObservable, Figure {
    private int id;
    private Point center;
    private double radius;
    private FigureObserver figureRepositoryObserver;
    private CircleObserver circleStorageObserver;

    public Circle(final int id, final Point center, final double radius) {
        this.id = id;
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (id != circle.id) return false;
        if (Double.compare(circle.radius, radius) != 0) return false;
        return center != null ? center.equals(circle.center) : circle.center == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (center != null ? center.hashCode() : 0);
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "id=" + id +
                ", center=" + center +
                ", radius=" + radius +
                '}';
    }

    public void setId(int id) {
        notifyRepositoryObserver();
        this.id = id;
        notifyRepositoryObserver();
    }

    public void setCenter(Point center) {
        notifyRepositoryObserver();
        this.center = center;
        notifyRepositoryObserver();
        notifyStorageObserver();
    }

    public void setRadius(double radius) {
        notifyRepositoryObserver();
        this.radius = radius;
        notifyRepositoryObserver();
        notifyStorageObserver();
    }

    public int getId() {
        return id;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void attach(FigureObserver observer) {
        this.figureRepositoryObserver = observer;
    }

    @Override
    public void detach(FigureObserver observer) {
        this.figureRepositoryObserver = null;
    }

    @Override
    public void attach(CircleObserver observer) {
        this.circleStorageObserver = observer;
    }

    @Override
    public void detach(CircleObserver observer) {
        this.circleStorageObserver = null;
    }


    @Override
    public void notifyRepositoryObserver() {
        if (figureRepositoryObserver != null) {
            figureRepositoryObserver.actionPerformed(new FigureEvent(this));
        }
    }

    @Override
    public void notifyStorageObserver() {
        if (circleStorageObserver != null) {
            circleStorageObserver.actionPerformed(new CircleEvent(this));
        }
    }
}
