import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Window {
    private JFrame frame;
    private Image image;

    public Window() {
        frame = new JFrame("Hello, World!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);

        try {
            image = ImageIO.read(getClass().getResource("/Person.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Calculate the scale factor based on the smaller dimension of the window
                double scaleFactor = Math.min(1.0 * getWidth() / 960, 1.0 * getHeight() / 540);

                // Calculate the size of the viewport after scaling
                int viewportWidth = (int) (960 * scaleFactor);
                int viewportHeight = (int) (540 * scaleFactor);

                // Calculate the x and y coordinates to center the viewport
                int viewportX = (getWidth() - viewportWidth) / 2;
                int viewportY = (getHeight() - viewportHeight) / 2;

                // Draw the viewport
                g.drawRect(viewportX, viewportY, viewportWidth, viewportHeight);

                // Calculate the size of the image after scaling
                int imgWidth = (int) (image.getWidth(null) * scaleFactor);
                int imgHeight = (int) (image.getHeight(null) * scaleFactor);

                // Calculate the x and y coordinates to center the image
                int imgX = (getWidth() - imgWidth) / 2;
                int imgY = (getHeight() - imgHeight) / 2;

                // Draw the image
                g.drawImage(image, imgX, imgY, imgWidth, imgHeight, null);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}