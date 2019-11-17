package com.epam.firsttask.entity;

import com.epam.firsttask.observer.repository.FigureEvent;
import com.epam.firsttask.observer.repository.FigureObservable;
import com.epam.firsttask.observer.repository.FigureObserver;
import com.epam.firsttask.observer.storage.quadrangle.QuadrangleEvent;
import com.epam.firsttask.observer.storage.quadrangle.QuadrangleObservable;
import com.epam.firsttask.observer.storage.quadrangle.QuadrangleObserver;

public class Quadrangle implements FigureObservable, QuadrangleObservable, Figure {
    private int id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private FigureObserver figureRepositoryObserver;
    private QuadrangleObserver quadrangleStorageObserver;

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
        this.figureRepositoryObserver = observer;
    }

    @Override
    public void detach(FigureObserver observer) {
        this.figureRepositoryObserver = null;
    }

    @Override
    public void notifyRepositoryObserver() {
        if (figureRepositoryObserver != null) {
            figureRepositoryObserver.actionPerformed(new FigureEvent(this));
        }
    }


    @Override
    public void attach(QuadrangleObserver observer) {
        this.quadrangleStorageObserver = observer;
    }

    @Override
    public void detach(QuadrangleObserver observer) {
        this.quadrangleStorageObserver = null;
    }

    @Override
    public void notifyStorageObserver() {
        if (quadrangleStorageObserver != null) {
            quadrangleStorageObserver.actionPerformed(new QuadrangleEvent(this));
        }
    }

    public void setId(int id) {
        notifyRepositoryObserver();
        this.id = id;
        notifyRepositoryObserver();
    }

    public void setA(Point a) {
        notifyRepositoryObserver();
        this.a = a;
        notifyRepositoryObserver();
        notifyStorageObserver();
    }

    public void setB(Point b) {
        notifyRepositoryObserver();
        this.b = b;
        notifyRepositoryObserver();
        notifyStorageObserver();
    }

    public void setC(Point c) {
        notifyRepositoryObserver();
        this.c = c;
        notifyRepositoryObserver();
        notifyStorageObserver();
    }

    public void setD(Point d) {
        notifyRepositoryObserver();
        this.d = d;
        notifyRepositoryObserver();
        notifyStorageObserver();
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
