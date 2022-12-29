
package Model.GameObjects.ObjectCollections;

import Model.Factories.AbstractShapeFactory;
import Model.Factories.EasyShapeFactory;
import Model.GameObjects.Clowns.Clown;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;


public class ControllableObjects extends GameObjectCollection{
    private Clown clown;

    public Clown getClown() {
        return clown;
    }

    public ControllableObjects(Clown clown) {
        this.clown = clown;
        this.addGameObject(clown);
    }
    
    public int getControlSpeed(){
        return clown.getSpeed();
    }
        
    
}
