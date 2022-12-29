package Model.GameObjects.Clowns;

import Model.GameObjects.GameImageObject;
import Model.GameObjects.ObjectCollections.ShapeStack;
import Model.Intersections.Intersectable;
import java.awt.Shape;

public class Clown extends GameImageObject implements Intersectable {

    private int speed;

    public ShapeStack getRightStack() {
        return rightStack;
    }

    public ShapeStack getLeftStack() {
        return leftStack;
    }
    private ShapeStack rightStack;
    private ShapeStack leftStack;

    public Clown(int x, int y, int speed, String path) {
        super(x, y, new String[]{path});
        this.speed = speed;

    }

    @Override
    public void setY(int mY) {
        //Do nothing

    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public Shape getIntersectionFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
