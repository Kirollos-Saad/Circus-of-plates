package Model.Difficulties;

import Model.Factories.AbstractShapeFactory;

public interface DifficultyBuilder {
        void buildShapeFactory(AbstractShapeFactory abstractShapeFactory);
        void buildSpawner(Spawner spawner);
        void buildShapeSpeed(int shapeSpeed);
        void buildHealthBar(int heartCount);
        Difficulty getResult();                
}
