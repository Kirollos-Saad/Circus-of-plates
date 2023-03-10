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

public interface AbstractShapeFactory {

    void setShapeSpeed(int shapeSpeed);

    Bomb getBomb(int xPos, int yPos, int imageId);

    Plate getPlate(int xPos, int yPos, Color shapeColor);

    Ball getBall(int xPos, int yPos, Color shapeColor);

    Square getSquare(int xPos, int yPos, Color shapeColor);

    void checkPaintedShapeFlyWeights(LinkedList<PaintedShapeFlyweight> flyWeightLinkedList, Color color, PaintedShape paintedShape);

    void checkImageShapeFlyWeights(LinkedList<ImageShapeFlyweight> flyWeightLinkedList, int imageID, ImageShape paintedShape);
    }
