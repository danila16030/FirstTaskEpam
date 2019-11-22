package main.com.epam.firsttask.entity;

import main.com.epam.firsttask.observer.Observable;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.repository.FigureEvent;


import main.com.epam.firsttask.observer.registrar.quadrangle.QuadrangleEvent;
import main.com.epam.firsttask.repository.FigureRepository;


public class Quadrangle implements Observable, Figure {
    private int id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Observer<FigureEvent> figureRepositoryObserver;
    private Observer<QuadrangleEvent> quadrangleParametersObserver;

    public Quadrangle(final int id, final Point a, final Point b, final Point c, final Point d) {
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
    public void attach(Observer observer) {
        if (observer.getClass() == FigureRepository.class) {
            this.figureRepositoryObserver = observer;
        } else {
            this.quadrangleParametersObserver = observer;
        }
    }

    @Override
    public void detach(Observer observer) {
        this.quadrangleParametersObserver = null;
        this.figureRepositoryObserver=null;
    }

    @Override
    public void notifyObserver() {
        if (figureRepositoryObserver != null) {
            figureRepositoryObserver.actionPerformed(new FigureEvent(this));
        }
        if(quadrangleParametersObserver!=null){
            quadrangleParametersObserver.actionPerformed(new QuadrangleEvent((this)));
        }
    }


    public void setA(Point a) {
        this.a = a;
        notifyObserver();
     }

    public void setB(Point b) {
        this.b = b;
        notifyObserver();
    }

    public void setC(Point c) {
        this.c = c;
        notifyObserver();
    }

    public void setD(Point d) {
        this.d = d;
        notifyObserver();
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
        notifyObserver();
    }
}
