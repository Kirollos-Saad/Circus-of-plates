package Model.Factories;

import Model.GameObjects.Shapes.Ball;
import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.ImageShape;
import Model.GameObjects.Shapes.ImageShapeFlyweight;
import Model.GameObjects.Shapes.PaintedShape;
import Model.GameObjects.Shapes.PaintedShapeFlyweight;
import Model.GameObjects.Shapes.Plate;
import Model.GameObjects.Shapes.Square;
import java.awt.Color;
import java.util.LinkedList;

public class EasyShapeFactory implements AbstractShapeFactory {

    private int shapeSpeed;
    private LinkedList<ImageShapeFlyweight> bombFlyWeights;
    private LinkedList<PaintedShapeFlyweight> ballFlyWeights;
    private LinkedList<PaintedShapeFlyweight> squareFlyweights;
    private LinkedList<PaintedShapeFlyweight> plateFlyweights;

    public EasyShapeFactory() {
        ballFlyWeights = new LinkedList<>();
        squareFlyweights = new LinkedList<>();
        plateFlyweights = new LinkedList<>();
        bombFlyWeights = new LinkedList<>();
    }

    @Override
    public void setShapeSpeed(int shapeSpeed) {
        this.shapeSpeed = shapeSpeed;
    }

    @Override
    public Bomb getBomb(int xPos, int yPos, int imageId) {
        Bomb bomb = new Bomb(shapeSpeed, xPos, yPos);
        checkImageShapeFlyWeights(bombFlyWeights, imageId, bomb);
        return bomb;

    }

    @Override
    public Plate getPlate(int xPos, int yPos, Color shapeColor) {
        Plate plate = new Plate(shapeSpeed, xPos, yPos);
        checkPaintedShapeFlyWeights(plateFlyweights, shapeColor, plate);
        return plate;

    }

    @Override
    public Ball getBall(int xPos, int yPos, Color shapeColor) {
        Ball ball = new Ball(shapeSpeed, xPos, yPos);
        checkPaintedShapeFlyWeights(ballFlyWeights, shapeColor, ball);
        return ball;
    }

    @Override
    public Square getSquare(int xPos, int yPos, Color shapeColor) {
        Square square = new Square(shapeSpeed, xPos, yPos);
        checkPaintedShapeFlyWeights(squareFlyweights, shapeColor, square);
        return square;
    }

    @Override
    public void checkPaintedShapeFlyWeights(LinkedList<PaintedShapeFlyweight> flyWeightLinkedList, Color color, PaintedShape paintedShape) {
        for (int i = 0; i < flyWeightLinkedList.size(); i++) {
            if (flyWeightLinkedList.get(i).getShapeColor().equals(color)) {
                paintedShape.setShapeFlyweight(flyWeightLinkedList.get(i));
                return;
            }
        }

        paintedShape.createFlyWeight(color);
        flyWeightLinkedList.add(paintedShape.getShapeFlyweight());
    }

    @Override
    public void checkImageShapeFlyWeights(LinkedList<ImageShapeFlyweight> flyWeightLinkedList, int imageID, ImageShape imageShape) {
        for (int i = 0; i < flyWeightLinkedList.size(); i++) {
            if (flyWeightLinkedList.get(i).getImageID()==imageID) {
                imageShape.setShapeFlyweight(flyWeightLinkedList.get(i));
                return;
            }
        }

        imageShape.createFlyWeight(imageID);
        flyWeightLinkedList.add(imageShape.getShapeFlyweight());
    }

}
