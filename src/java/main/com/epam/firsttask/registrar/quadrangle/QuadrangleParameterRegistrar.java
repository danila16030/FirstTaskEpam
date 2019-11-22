package main.com.epam.firsttask.registrar.quadrangle;

import main.com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import main.com.epam.firsttask.action.figure.QuadrangleSquareAction;
import main.com.epam.firsttask.entity.Quadrangle;
import main.com.epam.firsttask.observer.Observer;
import main.com.epam.firsttask.observer.registrar.circle.CircleEvent;
import main.com.epam.firsttask.observer.registrar.quadrangle.QuadrangleEvent;
import main.com.epam.firsttask.registrar.Registrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleParameterRegistrar implements Observer<QuadrangleEvent>,Registrar<Quadrangle> {
    private static Logger logger = LogManager.getLogger();
    private static QuadrangleParameterRegistrar quadrangleStorage = new QuadrangleParameterRegistrar();
    private static Map<Integer, QuadrangleParameter> map = new HashMap<Integer, QuadrangleParameter>();

    private QuadrangleParameterRegistrar() {
    }

    public static QuadrangleParameterRegistrar getQuadrangleStorage() {
        return quadrangleStorage;
    }

    @Override
    public void update(Quadrangle quadrangle) {
        QuadrangleParameter quadrangleParameter;
        QuadranglePerimeterAction quadranglePerimeterAction = new QuadranglePerimeterAction();
        QuadrangleSquareAction quadrangleSquareAction = new QuadrangleSquareAction();
        double square = quadrangleSquareAction.execute(quadrangle);
        double perimeter = quadranglePerimeterAction.execute(quadrangle);
        if ((map.get(quadrangle.getId())) != null) {
            quadrangleParameter = map.get(quadrangle.getId());
            quadrangleParameter.setSquare(square);
            quadrangleParameter.setPerimeter(perimeter);
        } else {
            quadrangleParameter = new QuadrangleParameter(square, perimeter);
            map.put(quadrangle.getId(), quadrangleParameter);
        }
    }

    public static Map<Integer, QuadrangleParameter> getMap() {
        return map;
    }

    @Override
    public void actionPerformed(QuadrangleEvent event) {
        update(event.getSource());
        logger.info("update" + event.getSource().toString());
    }

}
