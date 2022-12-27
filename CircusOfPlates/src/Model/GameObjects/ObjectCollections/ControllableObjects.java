
package Model.GameObjects.ObjectCollections;

import Model.GameObjects.Clowns.Clown;
import eg.edu.alexu.csd.oop.game.GameObject;


public class ControllableObjects extends GameObjectCollection{
    private Clown clown;

    public Clown getClown() {
        return clown;
    }

    public ControllableObjects(Clown clown) {
        this.clown = clown;
        this.addGameObject(clown);
    }
    
    public int getClownSpeed(){
        return 30;
    }
}
