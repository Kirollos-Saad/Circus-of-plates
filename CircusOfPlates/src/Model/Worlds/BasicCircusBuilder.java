package Model.Worlds;

import Model.Difficulties.Difficulty;
import Model.GameObjects.BackgroundImage;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;

public class BasicCircusBuilder implements CircusBuilder, WorldBuilder {

    private Difficulty circusDifficulty;
    private int width;
    private int height;
    private String backgroundPath;
    private ConstantObjects constantObjects;
    private MovableObjects movableObjects;
    private ControllableObjects controllableObjects;

    @Override
    public void setDifficulty(Difficulty difficulty) {
        circusDifficulty = difficulty;
    }

    @Override
    public void buildDimensions(int width, int heigth) {
        this.width = width;
        this.height = heigth;
    }

    @Override
    public void buildConstants(ConstantObjects constantObjects) {
        this.constantObjects = constantObjects;
    }

    @Override
    public void buildMovables(MovableObjects movableObjects) {
        this.movableObjects = movableObjects;
    }

    @Override
    public void buildControllables(ControllableObjects controllableObjects) {
        this.controllableObjects = controllableObjects;
    }

    @Override
    public void buildBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath;
    }

    @Override
    public World getResult() {
            
        constantObjects.addGameObject(BackgroundImage.getBackgroundImage(width, height, backgroundPath));
        return new Circus(circusDifficulty, width, height, constantObjects, movableObjects, controllableObjects);
    }

}
