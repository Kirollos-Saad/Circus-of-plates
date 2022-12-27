package Model.GameObjects.ObjectCollections;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.LinkedList;

public abstract class GameObjectCollection {

    private LinkedList<GameObject> gameObjectsList;
    
    protected GameObjectCollection(){
        gameObjectsList = new LinkedList<>();
    }

    public void addGameObject(GameObject gameObject) {
        gameObjectsList.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        gameObjectsList.remove(gameObject);
    }

    public LinkedList<GameObject> getGameObjectsList() {
        return gameObjectsList;
    }
    
    

}
