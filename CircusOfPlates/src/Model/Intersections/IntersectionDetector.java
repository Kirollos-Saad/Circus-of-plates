package Model.Intersections;

import Controller.Game;
import Events.BombExplosionEvent;
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
import java.util.LinkedList;

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

        LinkedList<GameShape> addedToLeftStack = new LinkedList<>();
        LinkedList<GameShape> addedToRightStack = new LinkedList<>();

        for (GameObject gameObj : movableObjects) {
            if (gameObj instanceof Bomb) {
                continue;
            }

            GameShape gameShape = (GameShape) gameObj;
            if (leftStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                addedToLeftStack.add(gameShape);
            } else if (rightStack.getIntersectionFrame().intersects((Rectangle2D) gameShape.getIntersectionFrame())) {
                addedToRightStack.add(gameShape);

            }
        }
        
        
        for (GameShape gameShape : addedToLeftStack) {
            leftStack.addToStack(gameShape);
        }

        for (GameShape gameShape : addedToRightStack) {
            rightStack.addToStack(gameShape);
        }

    }

    private void removeShapesFromScreenBottom(MovableObjects movableObjects) {

        for (GameObject gameObj : movableObjects) {

            if (gameObj.getY() > Game.getGameObject().getScreenHeight()) {
                EventHandler.getEventHandler().receiveEvent(new ShapeBeyondScreenBottomEvent((GameShape) gameObj));
            }
        }

    }

    private void checkIntersectionsWithClown(MovableObjects movableObjects, ControllableObjects controllableObjects, ConstantObjects constantObjects) {

        Clown clown = controllableObjects.getClown();

        for (GameObject gameObj : movableObjects) {

            if (gameObj instanceof Bomb) {

                Bomb bomb = (Bomb) gameObj;
                for (int j = 1; j >= 0; j--) {
                    if (bomb.getIntersectionFrame().intersects((Rectangle2D) clown.getMorethanOneIntersectionFrame()[j])) {
                        bomb.bombTouchedClown();
                        EventHandler.getEventHandler().recieveEvent(new BombExplosionEvent(bomb));
                    }
                }
            }
        }

    }

}
