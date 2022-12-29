package Model.Difficulties;

import Model.GameObjects.Shapes.GameShape;
import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.ObjectCollections.GameObjectCollection;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Spawner {

    private AbstractShapeFactory shapeFactory;

    protected void setShapeFactory(AbstractShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    protected AbstractShapeFactory getShapeFactory() {
        return shapeFactory;
    }

    public abstract GameShape spawnShape();
    public abstract void spawnShapeInContainer(GameObjectCollection container);
    
    protected abstract Color generateColor();

    protected abstract Point generatePosition();

    protected int generateRandom(int upperbound) {
        return new Random().nextInt(upperbound);

    }

    protected int generateRandom(int min, int max) {
        return generateRandom(max + 1 - min) + min;

    }

}
