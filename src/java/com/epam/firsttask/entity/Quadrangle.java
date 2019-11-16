package com.epam.firsttask.entity;

import com.epam.firsttask.observer.FigureEvent;
import com.epam.firsttask.observer.FigureObservable;
import com.epam.firsttask.observer.FigureObserver;

public class Quadrangle implements FigureObservable, Figure {
    private int id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private FigureObserver observer;

    public Quadrangle(int id, Point a, Point b, Point c, Point d) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrangle that = (Quadrangle) o;

        if (id != that.id) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;
        if (c != null ? !c.equals(that.c) : that.c != null) return false;
        return d != null ? d.equals(that.d) : that.d == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
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

    public void setId(int id) {
        notifyObserver();
        this.id = id;
        notifyObserver();

    }

    public void setA(Point a) {
        notifyObserver();
        this.a = a;
        notifyObserver();
    }

    public void setB(Point b) {
        this.b = b;
        notifyObserver();
    }

    public void setC(Point c) {
        notifyObserver();
        this.c = c;
        notifyObserver();
    }

    public void setD(Point d) {
        notifyObserver();
        this.d = d;
        notifyObserver();
    }

    public int getId() {
        return id;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }
}
