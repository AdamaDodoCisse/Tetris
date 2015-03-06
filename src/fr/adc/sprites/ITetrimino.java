package fr.adc.sprites;

import fr.adc.engine.Tetrimino;

import java.awt.*;

/**
 * Created by Adama Dodo CISSE.
 */
public class ITetrimino extends Tetrimino {

    /**
     * the construstor
     *
     * @param pivot
     */
    public ITetrimino(Point pivot) {
        super(pivot);
        this.getCoordinates().add(new Point(pivot.x  , pivot.y - 1 ));
        this.getCoordinates().add(new Point(pivot.x  , pivot.y + 1));
        this.getCoordinates().add(new Point(pivot.x  , pivot.y + 2 ));
    }
}