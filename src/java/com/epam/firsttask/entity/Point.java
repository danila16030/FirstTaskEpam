package com.epam.firsttask.entity;

import com.epam.firsttask.observer.FigureEvent;
import com.epam.firsttask.observer.FigureObservable;
import com.epam.firsttask.observer.FigureObserver;

public class Point implements Figure, FigureObservable {
    private int id;
    private double x;
    private double y;
    private FigureObserver observer;

    public Point(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (id != point.id) return false;
        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public void setId(int id) {
        notifyObserver();
        this.id = id;
        notifyObserver();
    }

    public void setX(double x) {
        notifyObserver();
        this.x = x;
        notifyObserver();
    }

    public void setY(double y) {
        notifyObserver();
        this.y = y;
        notifyObserver();
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void attach(FigureObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(FigureObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        observer.actionPerformed(new FigureEvent(this));
    }
}