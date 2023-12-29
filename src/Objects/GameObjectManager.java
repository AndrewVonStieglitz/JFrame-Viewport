package Objects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {
    private static GameObjectManager instance;
    private List<GameObject> gameObjects;

    private GameObjectManager() {
        gameObjects = new ArrayList<>();
    }

    public static GameObjectManager getInstance() {
        if (instance == null) {
            instance = new GameObjectManager();
        }
        return instance;
    }

    public GameObject createGameObject(String spriteName, int x, int y) {
        GameObject gameObject = new GameObject(spriteName, x, y);
        gameObjects.add(gameObject);
        return gameObject;
    }

    public void drawAll(Graphics g, double scaleFactor) {
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(g, scaleFactor);
        }
    }
}