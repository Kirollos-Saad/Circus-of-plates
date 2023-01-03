package Model.Worlds;

import Model.Difficulties.Difficulty;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;

public interface CircusBuilder {

    public static final int HEALTH_BAR_X = 0;
    public static final int HEALTH_BAR_Y = 10;

    void setDifficulty(Difficulty difficulty);

    void setScoreIncrement(int scoreIncrement);

    void buildDimensions(int width, int heigth);

    void buildConstants(ConstantObjects constantObjects);

    void buildMovables(MovableObjects movableObjects);

    void buildControllables(ControllableObjects controllableObjects);

    void buildBackgroundPath(String backgroundPath);

    World getResult();
}
