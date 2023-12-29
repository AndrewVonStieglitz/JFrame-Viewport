package Graphics;

import javax.swing.*;

import java.awt.*;

public class Window {
    private JFrame frame;

    public Window() {
        frame = new JFrame("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        Sprite sprite = new Sprite("/Sprites/Person.png", 0, 0);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                double scaleFactor = Math.min(1.0 * getWidth() / 960, 1.0 * getHeight() / 540);

                // Calculate the viewport dimensions and position
                int viewportWidth = (int) (960 * scaleFactor);
                int viewportHeight = (int) (540 * scaleFactor);
                int viewportX = (getWidth() - viewportWidth) / 2;
                int viewportY = (getHeight() - viewportHeight) / 2;

                // Draw the sprite relative to the viewport
                Graphics gViewport = g.create(viewportX, viewportY, viewportWidth, viewportHeight);
                sprite.draw(gViewport, scaleFactor);

                // Draw rectangle representing the viewport
                g.drawRect(viewportX, viewportY, viewportWidth, viewportHeight);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}