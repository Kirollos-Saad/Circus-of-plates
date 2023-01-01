package Model.Difficulties;

import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.ObjectCollections.HealthBar;

public class EasyDifficultyBuilder implements DifficultyBuilder {

    private AbstractShapeFactory shapeFactory;
    private Spawner spawner;
    private int shapeSpeed;
    private HealthBar healthBar;

    public EasyDifficultyBuilder() {
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
    public void buildShapeSpeed(int shapeSpeed) {
        this.shapeSpeed = shapeSpeed;
    }

    @Override
    public void buildHealthBar() {
        this.healthBar = new HealthBar(5);
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
