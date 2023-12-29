package Objects;

import java.awt.Graphics;
import Graphics.Sprite;

public class GameObject {
    private Sprite sprite;

    public GameObject(String spriteName, int x, int y) {
        this.sprite = new Sprite(spriteName, x, y);
    }

    public void draw(Graphics g, double scaleFactor) {
        sprite.draw(g, scaleFactor);
    }

}