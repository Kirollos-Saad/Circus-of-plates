package Model.Difficulties;

import Model.GameObjects.Shapes.GameShape;
import Model.Factories.AbstractShapeFactory;
import java.util.Random;

public abstract class Spawner {

    private AbstractShapeFactory shapeFactory;
    

    protected void setShapeFactory(AbstractShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }
    

    protected AbstractShapeFactory getShapeFactory() {
        return shapeFactory;
    }
    
    

    protected abstract GameShape spawnShape();

    protected int generateRandom(int upperbound) {
        return new Random().nextInt(upperbound);                                
        
    }

}
