package Model.Worlds;

import Controller.Game;
import Model.Difficulties.Difficulty;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.List;

public class Circus implements World {

    private Difficulty circusDifficulty;
    private int width;
    private int height;
    private ConstantObjects constantObjects;
    private MovableObjects movableObjects;
    private ControllableObjects controllableObjects;

    public Circus(Difficulty circusDifficulty, int width, int height, ConstantObjects constantObjects, MovableObjects movableObjects, ControllableObjects controllableObjects) {
        this.circusDifficulty = circusDifficulty;
        this.width = width;
        this.height = height;     
        this.constantObjects = constantObjects;
        this.movableObjects = movableObjects;
        this.controllableObjects = controllableObjects;
    }



    @Override
    public List<GameObject> getConstantObjects() {
        return  constantObjects.getGameObjectsList();
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movableObjects.getGameObjectsList();
    }

    @Override
    public List<GameObject> getControlableObjects() {
       return controllableObjects.getGameObjectsList();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        return true;
    }

    @Override
    public String getStatus() {
        return "Not Sure What This Does";
    }

    @Override
    public int getSpeed() {
        return Game.GAME_REFRESH;
    }

    @Override
    public int getControlSpeed() {
        return controllableObjects.getClownSpeed();
    }

}
