import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Sprite {
    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;

    public Sprite(String imagePath, int x, int y) {
        this.x = x;
        this.y = y;
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
            this.width = image.getWidth(null);
            this.height = image.getHeight(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, double scaleFactor) {
        int scaledWidth = (int) (width * scaleFactor);
        int scaledHeight = (int) (height * scaleFactor);
        g.drawImage(image, x, y, scaledWidth, scaledHeight, null);
    }
}