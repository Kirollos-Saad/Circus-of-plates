package Model.Worlds;

import Events.EventHandler;
import Model.Difficulties.Difficulty;
import Model.GameObjects.BackgroundImage;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.HealthBar;
import Model.GameObjects.ObjectCollections.MovableObjects;
import Model.GameObjects.Shapes.ScoreBoard;
import eg.edu.alexu.csd.oop.game.World;

public class ConcreteCircusBuilder implements CircusBuilder, WorldBuilder {

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
        //Background    
        constantObjects.addGameObject(BackgroundImage.getBackgroundImage(width, height, backgroundPath));
       
        //Healthbar
        HealthBar healthBar = circusDifficulty.getHealthBar();        
        healthBar.setX(HEALTH_BAR_X);
        healthBar.setY(HEALTH_BAR_Y);        
        constantObjects.addGameObject(healthBar);
        
        //Score
        ScoreBoard scoreBoard = new ScoreBoard();
        constantObjects.addGameObject(scoreBoard);
        
        //Adjusting EventHandler
        EventHandler eventHandler = EventHandler.getEventHandler();
        eventHandler.setMovableObjects(movableObjects);
        eventHandler.setHealthBar(healthBar);
        Circus builtCircus = new Circus(circusDifficulty, width, height, constantObjects, movableObjects, controllableObjects);
        eventHandler.setGameCircus(builtCircus);
        eventHandler.setScoreBoard(scoreBoard);
        
        return builtCircus;
    }

}
