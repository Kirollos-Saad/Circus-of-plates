package Model.GameObjects.ObjectCollections;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;


public class GameObjectCollectionIterator implements Iterator<GameObject>{

    GameObjectCollection gameObjCollection;
    
    
    private int currentIndex = 0;

    public GameObjectCollectionIterator(GameObjectCollection gameObjCollection) {
        this.gameObjCollection = gameObjCollection;
    }
    
    
    
    @Override
    public boolean hasNext() {
        
        return currentIndex < gameObjCollection.getGameObjectsList().size() && gameObjCollection.getGameObjectsList().get(currentIndex) != null;

    }

    @Override
    public GameObject next() {
        return gameObjCollection.getGameObjectsList().get(currentIndex++);
    }
    
}
