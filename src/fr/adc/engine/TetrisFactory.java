package fr.adc.engine;


import fr.adc.sprites.*;

import java.awt.*;

class TetrisFactory {

    public static Tetrimino generate(Point pivot)
    {
        int random = (int)(Math.random() * 7);

        switch (random)
        {
            case 0: return new OTetrimino(pivot);
            case 1: return new ZTetrimino(pivot);
            case 2: return new ITetrimino(pivot);
            case 3: return new TTetrimino(pivot);
            case 4: return new JTetrimino(pivot);
            case 5: return new STetrimino(pivot);
            default: return new LTetrimino(pivot);
        }
    }
}
