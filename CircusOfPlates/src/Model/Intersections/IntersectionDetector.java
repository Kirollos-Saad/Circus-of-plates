package Model.Intersections;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import Model.GameObjects.ObjectCollections.ShapeStack;
import Model.GameObjects.Shapes.GameShape;
import java.awt.geom.Rectangle2D;
import Model.GameObjects.Shapes.Bomb;

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
        checkIntersectionsWithStack(movableObjects, controllableObjects);
    }

    private void checkIntersectionsWithStack(MovableObjects movableObjects, ControllableObjects controllableObjects) {// Iterator Pattern can be used here.
//        for (int i = 0; i < movableObjects.getGameObjectsList().size(); i++) {
//            for (int j = 0; j < controllableObjects.getGameObjectsList().size(); j++) {
//                
//            }
//        }
        ShapeStack leftStack = controllableObjects.getClown().getLeftStack();
        ShapeStack rightStack = controllableObjects.getClown().getRightStack();

        for (int i = 0; i < movableObjects.getGameObjectsList().size(); i++) {            
            GameShape gameShape = (GameShape) movableObjects.getGameObjectsList().get(i);
            if(gameShape instanceof Bomb){
                continue;
            }
            
            if (leftStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                leftStack.addToStack(gameShape);
            } else if (rightStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                rightStack.addToStack(gameShape);
            }

        }

    }

}
