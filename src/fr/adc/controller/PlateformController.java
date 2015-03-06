package fr.adc.controller;


import fr.adc.engine.Direction;
import fr.adc.views.PlateformView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Plateform Controller
 */
public class PlateformController implements ActionListener , KeyListener{
    /**
     * @see fr.adc.views.PlateformView
     * the plateform view
     */
    private final PlateformView plateformView;

    /**
     * timer
     */
    private final Timer timer ;

    public PlateformController(PlateformView plateformView)
    {
        this.plateformView = plateformView;
        this.plateformView.setFocusable(true);
        this.plateformView.addKeyListener(this);
        this.timer = new Timer(1 , this);
    }

    public void start()
    {
        this.timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.plateformView.getPlateform().checkDirection();
        this.plateformView.getPlateform().update();
        this.plateformView.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                this.plateformView.getPlateform().setDirection(Direction.LEFT); break;
            case KeyEvent.VK_RIGHT:
                this.plateformView.getPlateform().setDirection(Direction.RIGHT);break;
            case KeyEvent.VK_UP:
                this.plateformView.getPlateform().setDirection(Direction.ROTATE);break;
            case KeyEvent.VK_SPACE:
                this.plateformView.getPlateform().setDirection(Direction.DOWN);break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
