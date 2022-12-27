package Model.Difficulties;
public interface DifficultyBuilder {
        void buildShapeFactory();
        void buildSpawner(Spawner spawner);
        void buildShapeSpeed(int shapeSpeed);
        Difficulty getResult();                
}
