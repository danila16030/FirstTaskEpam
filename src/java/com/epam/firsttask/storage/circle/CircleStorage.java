package com.epam.firsttask.storage.circle;

import com.epam.firsttask.action.figure.CirclePerimeterAction;
import com.epam.firsttask.action.figure.CircleSquareAction;
import com.epam.firsttask.entity.Circle;
import com.epam.firsttask.observer.repository.FigureEvent;
import com.epam.firsttask.observer.storage.circle.CircleEvent;
import com.epam.firsttask.observer.storage.circle.CircleObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class CircleStorage implements CircleObserver {
    private static Logger logger = LogManager.getLogger();
    private static CircleStorage circleStorage = new CircleStorage();
    private static Map<Integer, CircleParameter> map = new HashMap<Integer, CircleParameter>();

    private CircleStorage() {
    }

    public static CircleStorage getCircleStorage() {
        return circleStorage;
    }

    public void update(Circle circle) {
        CircleParameter circleParameter;
        CirclePerimeterAction circlePerimeterAction = new CirclePerimeterAction();
        CircleSquareAction circleSquareAction = new CircleSquareAction();
        double perimeter = circlePerimeterAction.execute(circle);
        double square = circleSquareAction.execute(circle);
        if ((map.get(circle.getId())) != null) {
            circleParameter = map.get(circle.getId());
            circleParameter.setSquare(square);
            circleParameter.setPerimeter(perimeter);
        } else {
            circleParameter = new CircleParameter(perimeter, square);
            map.put(circle.getId(), circleParameter);
        }
    }

    public static Map<Integer, CircleParameter> getMap() {
        return map;
    }

    @Override
    public void actionPerformed(CircleEvent event) {
        update(event.getSource());
        logger.info("update" + event.getSource().toString());
    }
}
