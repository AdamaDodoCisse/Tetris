package fr.adc.sprites;

import fr.adc.engine.Tetrimino;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Adama Dodo CISSE.
 */
public class OTetrimino extends Tetrimino{
    /**
     * the construstor
     *
     * @param pivot
     */
    public OTetrimino(Point pivot) {
        super(pivot);
        this.getCoordinates().add(new Point(pivot.x + 1 , pivot.y ));
        this.getCoordinates().add(new Point(pivot.x + 1, pivot.y - 1));
        this.getCoordinates().add(new Point(pivot.x  , pivot.y - 1));
    }

    @Override
    public HashSet<Point> getRotation() {
        return super.getCoordinates();
    }
}