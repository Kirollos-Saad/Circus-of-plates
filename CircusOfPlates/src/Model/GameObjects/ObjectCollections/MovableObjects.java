package Model.GameObjects.ObjectCollections;

import Model.GameObjects.Shapes.GameShape;
import eg.edu.alexu.csd.oop.game.GameObject;




public class MovableObjects extends GameObjectCollection{

    public void moveAll() { //May be iterator
        for(GameObject movableObject : this.getGameObjectsList() ){
            ((GameShape)movableObject).getMovingState().move();
        }
    }


    
}
