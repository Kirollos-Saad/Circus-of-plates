package Model.Factories;

import Model.GameObjects.Shapes.Ball;
import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.Plate;
import Model.GameObjects.Shapes.Triangle;




public interface AbstractShapeFactory {
    void setShapeSpeed(int shapeSpeed);
    Bomb getBomb();
    Plate getPlate();
    Ball getBall();
    Triangle getTriangle();
    
    
}
