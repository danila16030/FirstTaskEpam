package main.com.epam.firsttask.entity;

import main.com.epam.firsttask.observer.Observable;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.registrar.circle.CircleEvent;
import main.com.epam.firsttask.observer.repository.FigureEvent;
import main.com.epam.firsttask.repository.FigureRepository;


public class Circle implements Observable, Figure {
    private int id;
    private Point center;
    private double radius;
    private Observer<FigureEvent> figureRepositoryObserver;
    private Observer<CircleEvent> circleParameterObserver;
    private FigureRepository figureRepository;

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


    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void attach(Observer observer) {
        if (observer.getClass() == FigureRepository.class) {
            this.figureRepositoryObserver = observer;
        } else {
            this.circleParameterObserver = observer;
        }
    }

    @Override
    public void detach(Observer observer) {
        this.figureRepositoryObserver = null;
        this.circleParameterObserver = null;
    }


    @Override
    public void notifyObserver() {
        if (figureRepositoryObserver != null) {
            figureRepositoryObserver.actionPerformed(new FigureEvent(this));
        }
        if(circleParameterObserver!=null){
            circleParameterObserver.actionPerformed(new CircleEvent((this)));
        }
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
