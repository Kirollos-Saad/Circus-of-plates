package Model.Intersections;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;

public class IntersectionDetector { //Singleton

    private static IntersectionDetector intersectionDetector;

    private IntersectionDetector() {

    }

    public static synchronized IntersectionDetector getIntersectionDetector() {
        if (intersectionDetector == null) {
            intersectionDetector = new IntersectionDetector();
        }
        return intersectionDetector;

    }

    public void handleIntersections(ConstantObjects constantObjects, MovableObjects movableObjects, ControllableObjects controllableObjects) {
        checkMovablesWithControllables(movableObjects, controllableObjects);
    }

    private void checkMovablesWithControllables(MovableObjects movableObjects, ControllableObjects controllableObjects) {// Iterator Pattern can be used here.
        for (int i = 0; i < movableObjects.getGameObjectsList().size(); i++) {
            for (int j = 0; j < controllableObjects.getGameObjectsList().size(); j++) {

            }
        }
    }

}
