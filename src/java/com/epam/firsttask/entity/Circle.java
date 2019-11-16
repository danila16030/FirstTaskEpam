package com.epam.firsttask.entity;

import com.epam.firsttask.observer.FigureEvent;
import com.epam.firsttask.observer.FigureObservable;
import com.epam.firsttask.observer.FigureObserver;

public class Circle implements FigureObservable, Figure {
    private int id;
    private Point center;
    private double radius;
    private FigureObserver observer;

    public Circle(int id, Point center, double radius) {
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
        notifyObserver();
        this.id = id;
        notifyObserver();
    }

    public void setCenter(Point center) {
        notifyObserver();
        this.center = center;
        notifyObserver();
    }

    public void setRadius(double radius) {
        notifyObserver();
        this.radius = radius;
        notifyObserver();
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
        this.observer=observer;
    }

    @Override
    public void detach(FigureObserver observer) {
        this.observer=null;
    }

    @Override
    public void notifyObserver() {
        observer.actionPerformed(new FigureEvent(this));
    }
}
