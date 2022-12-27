package Model.Difficulties;

import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.Shapes.GameShape;
import java.util.ArrayList;


public class EasySpawner extends Spawner { 

    @Override
    public GameShape spawnShape() {
        AbstractShapeFactory shapeFactory = getShapeFactory();
        int random = generateRandom(10);
        switch (random) {
            case 0:
                return shapeFactory.getBall();
            case 1:
                return shapeFactory.getPlate();
            case 2:
                return shapeFactory.getTriangle();
            case 3:
                return generateRandom(4) == 3 ? shapeFactory.getBomb() : spawnShape();
            default:
                return null;

        }
    }

}
