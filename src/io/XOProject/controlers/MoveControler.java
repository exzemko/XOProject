package io.XOProject.controlers;

import io.XOProject.model.Exceptions.AlreadyOccupiedException;
import io.XOProject.model.Exceptions.InvalidPointException;
import io.XOProject.model.Field;
import io.XOProject.model.Figure;

import java.awt.*;

public class MoveControler {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure)throws InvalidPointException,
                                                    AlreadyOccupiedException{
        if (field.getFigure(point) != null){
        throw new AlreadyOccupiedException();
    }

        field.setFigure(point, figure);

    }

}
