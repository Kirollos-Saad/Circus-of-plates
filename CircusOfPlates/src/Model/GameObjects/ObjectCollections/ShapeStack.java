package Model.GameObjects.ObjectCollections;

import Events.EventHandler;
import Events.ShapeRemovedFromStackEvent;
import Model.GameObjects.Clowns.Clown;
import Model.GameObjects.Shapes.GameShape;
import Model.GameObjects.Shapes.PaintedShape;
import Model.Intersections.Intersectable;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.LinkedList;

public class ShapeStack implements Intersectable {

    public static final int STACK_WIDTH = 38;
    private Clown clown;
    private LinkedList<GameShape> stackOfShapes;
    private Point relativePosition; //Position of top left corner of the base of the stack relative to top left corner of total clown image    
    private int stackTopRelative; //Y coordinate of the top of the stack

    public ShapeStack(Clown clown, Point relativePosition) {
        stackOfShapes = new LinkedList<>();
        this.clown = clown;
        this.relativePosition = relativePosition;
        stackTopRelative = relativePosition.y;
    }

    public void addToStack(GameShape gameShape) {
        gameShape.getMovingState().shapeCaught();
        stackOfShapes.add(gameShape);
        stackTopRelative -= gameShape.getHeight();
        checkSameColor();
    }

    public void checkSameColor() {
        int shapeCount = stackOfShapes.size();
        if (shapeCount < 3) {
            return;
        }
        for (int i = shapeCount - 1; i > shapeCount - 3; i--) {
            PaintedShape shape1 = (PaintedShape) stackOfShapes.get(i);
            PaintedShape shape2 = (PaintedShape) stackOfShapes.get(i - 1);
            if (shape1.getShapeFlyweight().getShapeColor().equals(shape2.getShapeFlyweight().getShapeColor())) {

            } else {
                return;
            }

        }
        
        removeFromStack(3);

    }

    public void removeFromStack(int numberOfShapes) {// numberOfShapes equals 3 in the game
        for (int i = 0; i < numberOfShapes; i++) {

            GameShape gameShape = stackOfShapes.remove(stackOfShapes.size()-1);     //Might require observer pattern
            stackTopRelative += gameShape.getHeight();
            EventHandler.getEventHandler().receiveEvent(new ShapeRemovedFromStackEvent(gameShape));
        }
    }

    public void updateStack() {
        int clownX = clown.getX();
        int clownY = clown.getY();
        int shapeY = relativePosition.y + clownY; //Y coordinate of each shape        
        for (int i = 0; i < stackOfShapes.size(); i++) {
            GameShape gameShape = stackOfShapes.get(i);
            shapeY -= gameShape.getHeight();
            gameShape.setX(clownX + relativePosition.x + STACK_WIDTH/2 - gameShape.getWidth()/2);
            gameShape.setY(shapeY);

        }

    }

    @Override
    public Shape getIntersectionFrame() {
        int x1 = clown.getX() + relativePosition.x + 5;
        int y1 = clown.getY() + stackTopRelative;

        int x2 = clown.getX() + relativePosition.x + STACK_WIDTH - 5;
        int y2 = y1;

        return new Line2D.Float(x1, y1, x2, y2);
    }

}
