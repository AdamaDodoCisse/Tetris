package fr.adc.views;

import fr.adc.engine.Plateform;
import fr.adc.engine.Tetrimino;

import javax.swing.*;
import java.awt.*;

/**
 * @author Adama Dodo CISSE <email><strong> < adama.dodo.cisse@gmail.com ></strong></email>.
 * Description :
 *
 * The horizontal line represents {x}
 * The vertical line represents {y}
 *
 *          0 1 2 3 4 5 6
 *        0 *************
 *        1 *
 *        2 *
 *        3 *
 *        4 *
 *        5 *
 *        6 *
 *
 */
public class PlateformView extends JPanel {

    /**
     *  the game plateform
     */
    private final Plateform plateform;
    /**
     * tretrimino box size
     */
    private final int boxSize ;

    /**
     * the constructor
     * @see fr.adc.engine.Plateform
     * @param plateform
     * @param boxSize
     */
    public PlateformView(Plateform plateform, int boxSize)
    {
        this.plateform = plateform;
        this.boxSize = boxSize;
        int w = plateform.getWidth() * boxSize;
        int h = plateform.getHeight() * boxSize;
        this.setPreferredSize(new Dimension( w, h));
        this.setSize(w , h);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fill3DRect(0, 0, getWidth(), getHeight(), true);
        for(Tetrimino tetrimino : plateform.getTetriminos())
            paint(g , tetrimino);

        paint(g, plateform.getCurrent());
    }

    /**
     * Paint tetrimino
     * @see fr.adc.engine.Tetrimino
     * @param graphics
     * @param tetrimino
     */
    private void paint(Graphics graphics , Tetrimino tetrimino)
    {
        Color color = graphics.getColor();

        for(Point point : tetrimino.getCoordinates())
        {
            graphics.setColor(tetrimino.getColor());
            graphics.fill3DRect(point.x * this.boxSize, point.y * this.boxSize, this.boxSize, this.boxSize , true);

            graphics.setColor(color);
            graphics.fill3DRect(point.x * this.boxSize + this.boxSize/4, point.y * this.boxSize + this.boxSize/4 , this.boxSize/2, this.boxSize/2 , true);
          //  graphics.setColor(tetrimino.getColor());
           // graphics.fill3DRect(point.x * this.boxSize + this.boxSize/4 + this.boxSize/8, point.y * this.boxSize + this.boxSize/4  + this.boxSize/8 , this.boxSize/4, this.boxSize/4 , true);
        }

        graphics.setColor(color);
    }

    /**
     * @see fr.adc.engine.Plateform
     * @return the Plateform
     */
    public Plateform getPlateform() {
        return plateform;
    }

}
