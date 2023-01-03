package Model.GameObjects.ObjectCollections;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class GameObjectCollection implements Iterable<GameObject>{

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
    
    @Override
    public Iterator<GameObject> iterator() {
        
        Iterator<GameObject> it = new GameObjectCollectionIterator(this) ;
        return it;
    }
}
