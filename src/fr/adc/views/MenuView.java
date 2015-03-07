package fr.adc.views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JPanel {

    private JButton exit;

    private JButton start;


    public MenuView(int width , int height)
    {
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        initUI();
        this.setPreferredSize(new Dimension(width , height));
        this.setSize(width, height);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        jPanel.setBackground(new Color(0x000000));
        jPanel.add(this.start);
        jPanel.add(this.exit);

        JPanel scoreContainer = new JPanel();
        scoreContainer.setLayout(new GridLayout(2,1));
        scoreContainer.setBackground(getBackground());
        JLabel infoScore = new JLabel("<html> <p style='text-align:center;'><span style='color:#39C6C5'>Tetris</span> - <span style='color:#CE3535'>Game</span> <br> <br>Score <br> <br> <span style='font-size:12px; color:#CE3535'>10</span> <p> </html>", SwingConstants.CENTER);

        infoScore.setFont(new Font("Webdings", Font.BOLD , 24));
        infoScore.setForeground(new Color(0xFFFFFF));

        //JLabel score = new JLabel("0" , SwingConstants.CENTER);

       // score.setFont(new Font("Yu Gothic", Font.BOLD , 48));
       // score.setForeground(new Color(0xCE3535));



        scoreContainer.add(infoScore);
        //scoreContainer.add(score);
        this.add(BorderLayout.CENTER , scoreContainer);
        this.add(BorderLayout.SOUTH , jPanel);

        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for ( int i = 0; i < fonts.length; i++ )
        {
            System.out.println(fonts[i]);
        }

    }


    public void initUI()
    {

        this.exit = new JButton("Exit");
        this.start = new JButton("Start");

        this.exit.setFont(new Font("Calibri", Font.BOLD, 14));
        this.exit.setBackground(new Color(0xCE3535));
        this.exit.setForeground(new Color(0x590200));
        this.exit.setUI(new StyledButtonUI());

        this.start.setFont(new Font("Calibri", Font.BOLD, 14));
        this.start.setBackground(new Color(0x1DCE94));
        this.start.setForeground(new Color(0x065933));
        this.start.setUI(new StyledButtonUI());

        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
