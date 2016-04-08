package Lesson_03.kp_03.shape;

import javax.swing.*;
import java.awt.*;

public class ShapesTemplate extends JPanel implements Drawable {

    private AbstractShape[] shapes;

    public ShapesTemplate(AbstractShape[] shapes) {
        this.shapes = shapes;
        if (shapes == null || shapes.length < 1) {
            this.shapes = new AbstractShape[0];
        }

        JFrame frame = new JFrame("AbstractShape templates");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (AbstractShape s : shapes) {
            s.draw(g);
        }
    }

    @Override
    public void draw(Graphics g) {

    }
}
