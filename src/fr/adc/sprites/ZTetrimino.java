package fr.adc.sprites;

import fr.adc.engine.Tetrimino;

import java.awt.*;

/**
 * Created by Adama Dodo CISSE.
 */
public class ZTetrimino extends Tetrimino {

    /**
     * the construstor
     *
     * @param pivot
     */
    public ZTetrimino(Point pivot) {
        super(pivot);
        this.getCoordinates().add(new Point(pivot.x + 1 , pivot.y ));
        this.getCoordinates().add(new Point(pivot.x - 1 , pivot.y - 1 ));
        this.getCoordinates().add(new Point(pivot.x  , pivot.y  - 1 ));
    }
}