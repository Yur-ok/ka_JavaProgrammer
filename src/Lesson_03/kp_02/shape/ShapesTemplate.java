package Lesson_03.kp_02.shape;

import javax.swing.*;
import java.awt.*;

public class ShapesTemplate extends JPanel {

    private Shape[] shapes;

    public ShapesTemplate(Shape[] shapes) {
        this.shapes = shapes;
        if (shapes == null || shapes.length < 1) {
            this.shapes = new Shape[0];
        }

        JFrame frame = new JFrame("Shape templates");
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
        for (Shape s : shapes) {
            s.draw(g);
        }
    }
}
