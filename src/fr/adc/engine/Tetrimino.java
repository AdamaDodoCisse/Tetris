package fr.adc.engine;

import java.awt.*;
import java.io.Serializable;
import java.util.HashSet;

/**
 * @author Adama Dodo CISSE.
 * description :
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
public abstract class Tetrimino implements Cloneable, Serializable {

    /**
     * the pivot
     */
    private final Point pivot ;
    /**
     * the coordinates
     */
    private HashSet<Point> coordinates;

    /**
     *  a tetrimino color
     */
    private final Color color;

    /**
     * the construstor
     * @param pivot
     */
    protected Tetrimino(Point pivot)
    {
        this.pivot = new Point(pivot.x , pivot.y);
        this.coordinates = new HashSet<Point>();
        this.coordinates.add(this.pivot);

        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b   = (int)(Math.random() * 256);

        this.color = new Color(r,g,b);
    }

    /**
     *
     * @return the coordinates
     */
    public HashSet<Point> getCoordinates() {
        return coordinates;
    }

    /**
     * Performs a coordinate translation
     * @param x
     * @param y
     * @return HashSet - the translation of coordinates
     */
    HashSet<Point> translate(int x, int y)
    {
        HashSet<Point> points = new HashSet<Point>();
        for(Point point : this.getCoordinates())
            points.add(new Point(point.x + x , point.y + y));

        return points;
    }

    /**
     * Performs a coordinate translation to left
     * @return  HashSet - the translation of coordinates to left
     */
    public HashSet<Point> getTranslationLeft()
    {
        return this.translate(-1, 0);
    }

    /**
     * Performs a coordinate translation to right
     * @return  HashSet - the translation of coordinates to right
     */
    public HashSet<Point> getTranslationRight()
    {
        return this.translate(1, 0);
    }


    /**
     * Performs a coordinate translation to down
     * @return  HashSet - the translation of coordinates to down
     */
    public HashSet<Point> getTranslationDown()
    {
        return this.translate(0, 1);
    }

    /**
     * Performs a coordinate translation to down
     * @return  HashSet - the translation of coordinates to down
     */
    public HashSet<Point> getRotation()
    {
        HashSet<Point> points = new HashSet<Point>();
        if(this.pivot == null)
        {
            points.addAll(coordinates);
        }  else
        {
            for(Point point : this.getCoordinates())
                points.add(new Point(this.pivot.x + point.y - this.pivot.y ,this.pivot.y - point.x + this.pivot.x  ));
        }

        return points;
    }

    /**
     * move the tetrimino to left
     */
    public void moveLeft()
    {
        this.coordinates = this.getTranslationLeft();
        if(pivot != null)
            this.pivot.x--;
    }

    /**
     * move the tetrimino to right
     */
    public void moveRight()
    {
        this.coordinates = this.getTranslationRight();
        if(pivot != null)
            this.pivot.x++;
    }

    /**
     * move the tetrimino to down
     */
    public void moveDown()
    {
        this.coordinates = this.getTranslationDown();
        if(pivot != null)
            this.pivot.y++;
    }

    /**
     * rotate the tetrimino
     */
    public void rotate()
    {
        this.coordinates = this.getRotation();
    }

    /**
     *
     * @return color of tetrimino
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @param y
     * @return the column count
     */
    public int colCount(int y)
    {
        int cpt = 0;
        for(Point point : getCoordinates())
            if(point.y == y)
                cpt ++;
        return cpt;
    }

    public boolean collision(Tetrimino tetrimino)
    {
       return this.collision(tetrimino.getCoordinates());
    }

    public boolean collision(HashSet<Point> points)
    {
        for(Point point : points)
            if(getCoordinates().contains(point)) return true;
        return false;
    }

    /**
     * destroy tetrimino row
     * @param y
     */
    public void destroyRow(int y)
    {
        HashSet<Point> points = new HashSet<Point>();

        for(Point point : getCoordinates())
            if(point.y != y)
            {
                if(point.y < y)
                    point.y ++;

                points.add(point);
            }

        this.coordinates = points;
    }

    public HashSet<Integer> getRows()
    {
        HashSet<Integer> integers = new HashSet<Integer>();

        for(Point point : this.getCoordinates())
            integers.add(point.y);
        return integers;
    }
}
