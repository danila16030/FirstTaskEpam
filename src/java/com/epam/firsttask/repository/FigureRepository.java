package com.epam.firsttask.repository;

import com.epam.firsttask.entity.Figure;
import com.epam.firsttask.observer.FigureEvent;
import com.epam.firsttask.observer.FigureObserver;
import com.epam.firsttask.specification.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FigureRepository implements FigureObserver {
    private List<Figure> figureList = new ArrayList<>();

    public FigureRepository(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public List<Figure> query(Specification specification) {
        return figureList.stream()
                .filter(figure -> specification.specify(figure))
                .collect(Collectors.toList());
    }

    public void addFigure(Figure figure) {
        figureList.add(figure);
    }

    public void removeFigure(Figure figure) {
        figureList.remove(figure);
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    @Override
    public void actionPerformed(FigureEvent event) {
        if (!figureList.remove(event.getSource())) {
            figureList.add(event.getSource());
        }
    }
}
