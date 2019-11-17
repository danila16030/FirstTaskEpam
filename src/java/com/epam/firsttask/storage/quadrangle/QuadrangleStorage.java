package com.epam.firsttask.storage.quadrangle;

import com.epam.firsttask.action.figure.QuadranglePerimeterAction;
import com.epam.firsttask.action.figure.QuadrangleSquareAction;
import com.epam.firsttask.entity.Quadrangle;
import com.epam.firsttask.observer.storage.quadrangle.QuadrangleEvent;
import com.epam.firsttask.observer.storage.quadrangle.QuadrangleObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleStorage implements QuadrangleObserver {
    private static Logger logger = LogManager.getLogger();
    private static QuadrangleStorage quadrangleStorage = new QuadrangleStorage();
    private static Map<Integer, QuadrangleParameter> map=new HashMap<Integer, QuadrangleParameter>();

    private QuadrangleStorage() {
    }

    public static QuadrangleStorage getQuadrangleStorage() {
        return quadrangleStorage;
    }

    public void update(Quadrangle quadrangle) {
        QuadrangleParameter quadrangleParameter;
        QuadranglePerimeterAction quadranglePerimeterAction = new QuadranglePerimeterAction();
        QuadrangleSquareAction quadrangleSquareAction = new QuadrangleSquareAction();
        double square = quadrangleSquareAction.execute(quadrangle);
        double perimeter = quadranglePerimeterAction.execute(quadrangle);
        if ((quadrangleParameter = map.get(quadrangle.getId())) != null) {
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
