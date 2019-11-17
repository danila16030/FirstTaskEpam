package com.epam.firsttask.storage.circle;

import com.epam.firsttask.action.figure.CirclePerimeterAction;
import com.epam.firsttask.action.figure.CircleSquareAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.observer.repository.FigureEvent;
import com.epam.firsttask.observer.storage.circle.CircleEvent;
import com.epam.firsttask.observer.storage.circle.CircleObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class CircleStorage implements CircleObserver {
    private static Logger logger = LogManager.getLogger();
    private static CircleStorage circleStorage = new CircleStorage();
    private Map<Integer, CircleParameter> map;

    private CircleStorage() {
    }

    public static CircleStorage getQuadrangleStorage() {
        return circleStorage;
    }
    public void update(Circle circle){
        CircleParameter circleParameter;
        CirclePerimeterAction circlePerimeterAction=new CirclePerimeterAction();
        CircleSquareAction circleSquareAction=new CircleSquareAction();
        double perimeter=circlePerimeterAction.execute(circle);
        double square=circleSquareAction.execute(circle);
        if ((circleParameter = map.get(circle.getId())) != null) {
            circleParameter.setSquare(square);
            circleParameter.setPerimeter(perimeter);
        } else {
            circleParameter = new CircleParameter(perimeter,square);
            map.put(circle.getId(), circleParameter);
        }
    }

    @Override
    public void actionPerformed(CircleEvent event) {
    update(event.getSource());
    }
}
