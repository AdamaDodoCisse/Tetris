package fr.adc.views;

import fr.adc.controller.PlateformController;
import fr.adc.engine.Plateform;

import javax.swing.*;
import java.awt.*;

/**
 * the Game frame
 */
public class Window extends JFrame {
    /**
     * @see fr.adc.controller.PlateformController
     * the controller of plateform
     */
    private final PlateformController plateformController;
    /**
     * @see fr.adc.engine.Plateform
     * the plateform
     */
    private final Plateform plateform;
    /**
     * @see fr.adc.views.PlateformView
     * the plateform view
     */
    private final PlateformView plateformView;

    private static final int PLATEFORM_WIDTH = 12;
    private static final int PLATEFORM_HEIGT = 26;
    private static final int PLATEFORM_BOX_SIZE = 20;

    /**
     * the constructor of game window
     */
    public Window()
    {
        this.plateform = new Plateform(new Point(3,4) , PLATEFORM_WIDTH , PLATEFORM_HEIGT);
        this.plateformView = new PlateformView(plateform , PLATEFORM_BOX_SIZE);
        this.plateformController = new PlateformController(this.plateformView);
        add(plateformView);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.plateformController.start();
    }
}
