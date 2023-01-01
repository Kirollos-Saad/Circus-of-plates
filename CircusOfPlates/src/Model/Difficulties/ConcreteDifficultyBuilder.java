package Model.Difficulties;

import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.ObjectCollections.HealthBar;

public class ConcreteDifficultyBuilder implements DifficultyBuilder {

    private AbstractShapeFactory shapeFactory;
    private Spawner spawner;
    private HealthBar healthBar;
    private int shapeSpeed;
  

    public ConcreteDifficultyBuilder() {
    }

    @Override
    public void buildShapeFactory(AbstractShapeFactory abstractShapeFactory) {
        this.shapeFactory = abstractShapeFactory;
    }

    @Override
    public void buildSpawner(Spawner spawner) {
        this.spawner = spawner;
    }

    @Override
    public void buildHealthBar(int heartCount) {
        this.healthBar = new HealthBar(heartCount);
    }
    
        @Override
    public void buildShapeSpeed(int shapeSpeed) {
        this.shapeSpeed = shapeSpeed;
    }

    @Override
    public Difficulty getResult() {
        try {
            shapeFactory.setShapeSpeed(shapeSpeed);
            spawner.setShapeFactory(shapeFactory);
            return new Difficulty(spawner, healthBar);
        } catch (NullPointerException npe) {
            throw new NullPointerException("Error Encoutered while building difficulty class");
        }
    }



}
