package Model.Factories;

import Model.GameObjects.Shapes.Ball;
import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.Plate;
import Model.GameObjects.Shapes.Triangle;


public class EasyShapeFactory implements AbstractShapeFactory{
    private int shapeSpeed;

    @Override
    public void setShapeSpeed(int shapeSpeed) {
        this.shapeSpeed = shapeSpeed;
    }
    
    @Override
    public Bomb getBomb() {
        return new Bomb(shapeSpeed);
    }

    @Override
    public Plate getPlate() {
        return new Plate(shapeSpeed);
    }

    @Override
    public Ball getBall() {
        return new Ball(shapeSpeed);
    }

    @Override
    public Triangle getTriangle() {
        return new Triangle(shapeSpeed);
    }
    
}
