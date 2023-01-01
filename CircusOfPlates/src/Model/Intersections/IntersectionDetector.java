package Model.Intersections;

import Controller.Game;
import Events.EventHandler;
import Events.ShapeBeyondScreenBottomEvent;

import Model.GameObjects.Clowns.Clown;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import Model.GameObjects.ObjectCollections.ShapeStack;
import Model.GameObjects.Shapes.GameShape;
import Model.GameObjects.Shapes.Bomb;
import eg.edu.alexu.csd.oop.game.GameObject;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;

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
        removeShapesFromScreenBottom(movableObjects);
        checkIntersectionsWithStack(movableObjects, controllableObjects);
        checkIntersectionsWithClown(movableObjects, controllableObjects, constantObjects);
    }

    private void checkIntersectionsWithStack(MovableObjects movableObjects, ControllableObjects controllableObjects) {

        ShapeStack leftStack = controllableObjects.getClown().getLeftStack();
        ShapeStack rightStack = controllableObjects.getClown().getRightStack();

        Iterator<GameObject> iterator = movableObjects.getGameObjectsList().iterator();
        while (iterator.hasNext()) {
            GameShape gameShape = (GameShape) iterator.next();
            if (gameShape instanceof Bomb) {
                continue;
            }

            if (leftStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                leftStack.addToStack(gameShape);
            } else if (rightStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                rightStack.addToStack(gameShape);

            }
        }

    }

    private void removeShapesFromScreenBottom(MovableObjects movableObjects) {
        for (int i = 0; i < movableObjects.getGameObjectsList().size(); i++) { // Iterator Pattern can be used here. E3melo el iterator henaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa           
            GameShape gameShape = (GameShape) movableObjects.getGameObjectsList().get(i);
            if (gameShape.getY() > Game.getGameObject().getScreenHeight()) {
                EventHandler.getEventHandler().receiveEvent(new ShapeBeyondScreenBottomEvent(gameShape));
            }

        }

    }

    private void checkIntersectionsWithClown(MovableObjects movableObjects, ControllableObjects controllableObjects, ConstantObjects constantObjects) {

        Clown clown = controllableObjects.getClown();

        Iterator<GameObject> itr = movableObjects.getGameObjectsList().iterator();
        while (itr.hasNext()) {

            GameShape gameShape = (GameShape) itr.next();
            if (gameShape instanceof Bomb) {

                for (int j = 1; j >= 0; j--) {
                    if (gameShape.getIntersectionFrame().intersects((Rectangle2D) clown.getMorethanOneIntersectionFrame()[j])) {
                        System.out.println("Bomb has hit frame " + j);
                    }
                }

            }
        }

    }

}
