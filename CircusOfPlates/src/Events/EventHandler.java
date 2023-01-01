package Events;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import Model.GameObjects.Shapes.Bomb;

public class EventHandler { //Singleton

    private static EventHandler eventHandler;

    private EventHandler() {
    }
    
    public static synchronized EventHandler getEventHandler(){
        if(eventHandler == null){
            eventHandler = new EventHandler();
        }
        return eventHandler;
    
    }

    private MovableObjects movableObjects;
    private ControllableObjects controllableObjects;
    private ConstantObjects constantObjects;

    public void setMovableObjects(MovableObjects movableObjects) {
        this.movableObjects = movableObjects;
    }

    public void setControllableObjects(ControllableObjects controllableObjects) {
        this.controllableObjects = controllableObjects;
    }

    public void setConstantObjects(ConstantObjects constantObjects) {
        this.constantObjects = constantObjects;
    }

    public void receiveEvent(ShapeRemovedFromStackEvent e) {
        
            movableObjects.removeGameObject(e.getRemovedShape());
        }

    
    public void recieveEvent(BombExplosionEvent e)
    {
         movableObjects.removeGameObject(e.getRemovedShape());
        
        //notify healthbar.
        //notify score.
    }
}
