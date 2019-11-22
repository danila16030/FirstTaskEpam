package main.com.epam.firsttask.registrar.circle;

import main.com.epam.firsttask.action.figure.CirclePerimeterAction;
import main.com.epam.firsttask.action.figure.CircleSquareAction;
import main.com.epam.firsttask.entity.Circle;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.registrar.circle.CircleEvent;
import main.com.epam.firsttask.registrar.Registrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CircleParameterRegistrar implements Observer<CircleEvent>, Registrar<Circle> {
    private static Logger logger = LogManager.getLogger();
    private static CircleParameterRegistrar circleStorage = new CircleParameterRegistrar();
    private static Map<Integer, CircleParameter> map = new HashMap<Integer, CircleParameter>();

    private CircleParameterRegistrar() {
    }

    public static CircleParameterRegistrar getCircleStorage() {
        return circleStorage;
    }

    @Override
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
