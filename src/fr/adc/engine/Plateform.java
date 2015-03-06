package fr.adc.engine;


import java.awt.*;
import java.util.HashSet;

/**
 * @author Adama Dodo CISSE
 * Game Plateform
 */
public class Plateform {
    /**
     * all tetriminos stable
     */
    private final HashSet<Tetrimino> tetriminos;

    /**
     * the current tetrimino
     * @see fr.adc.engine.Tetrimino
     */
    private Tetrimino current;

    /**
     * the pivot
     */
    private final Point pivot;

    /**
     * plateform width
     */
    private final int width;

    /**
     * plateform height
     */
    private final int height;

    /**
     * game speed
     */
    private final int time = 200;

    private int timeCount = 0;

    /**
     * direction
     */
    private Direction direction;

    public Plateform(Point pivot , int width , int height) {
        this.pivot = new Point(pivot.x , pivot.y);
        this.width  = width;
        this.height = height;
        this.current = TetrisFactory.generate(this.pivot);
        this.tetriminos = new HashSet<Tetrimino>();
    }

    /**
     *
     * @return height of plateform
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return width of plateform
     */
    public int getWidth() {
        return width;
    }

    public void checkDirection()
    {
        if(this.direction != null)
        {
            switch (this.direction)
            {
                case LEFT:
                    if(notCollision(this.current.getTranslationLeft()))
                        this.current.moveLeft(); break;
                case RIGHT:
                    if(notCollision(this.current.getTranslationRight()))
                        this.current.moveRight(); break;
                case ROTATE:
                    if(notCollision(this.current.getRotation()))
                        this.current.rotate(); break;
                case DOWN:
                    if(notCollision(this.current.getTranslationDown()))
                        next(); break;
            }
        }
    }

    private void next()
    {
        boolean collision = false;
        if(notCollision(this.current.getTranslationDown()))
            this.current.moveDown();
        else
            collision = true;

        if(collision || this.current.colCount(this.getHeight() - 1) > 0 )
        {
            HashSet<Integer> rows = this.current.getRows();
            this.getTetriminos().add(this.current);

            for(int row : rows) updateRow(row);

            this.current = TetrisFactory.generate(new Point(this.pivot.x , this.pivot.y));
        }
    }

   private int countCol(int row)
   {
       int cpt = 0;

       for(Tetrimino tetrimino : getTetriminos())
       {
           cpt += tetrimino.colCount(row);
       }
       return cpt;
   }


    private void updateRow(int row)
    {
        int cpt = countCol(row);

        if(cpt >= getWidth())
        {
            for(Tetrimino tetrimino : getTetriminos())
            {
                tetrimino.destroyRow(row);
            }
        }
    }

    public void update()
    {

        if(this.timeCount == 0) next();

        this.timeCount = (this.timeCount + 1) % this.time ;

        this.direction = null;
    }

    /**
     *
     * @param points
     * @return boolean
     */
    boolean notCollision(HashSet<Point> points)
    {
        for(Tetrimino tetrimino : getTetriminos())
            if(tetrimino.collision(points))
                return false;
        for (Point point : points)
            if(point.x < 0 || point.x >= getWidth())
                return false;
        return true;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     *
     * @return the tetrimnos
     */
    public HashSet<Tetrimino> getTetriminos() {
        return tetriminos;
    }

    /**
     * @see fr.adc.engine.Tetrimino
     * @return current tetrimino
     */
    public Tetrimino getCurrent() {
        return current;
    }
}
