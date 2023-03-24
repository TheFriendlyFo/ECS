import java.util.ArrayList;
import java.util.List;

public abstract class Scene {
    private boolean isRunning;
    private final List<GameObject> gameObjects;

    public Scene() {
        gameObjects = new ArrayList<>();
    }

    public void init() {

    }

    public void start() {
        for (GameObject gObject : gameObjects) {
            gObject.start();
        }
    }

    public void addGameObjectToScene(GameObject gObject) {
        if (!isRunning) {
            gameObjects.add(gObject);
        }
        gameObjects.add(gObject);
        gObject.start();
    }
}
