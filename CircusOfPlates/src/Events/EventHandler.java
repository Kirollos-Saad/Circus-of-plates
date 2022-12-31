package Events;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;

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

    public void receiveEvent(Event e) {
        if (e instanceof ShapeRemovedFromStackEvent) {
            movableObjects.removeGameObject(((ShapeRemovedFromStackEvent) e).getRemovedShape());
        }

    }
}
