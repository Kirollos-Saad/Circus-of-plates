package Model.Worlds;

import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.image.BufferedImage;


public interface WorldBuilder {
    void buildDimensions(int width, int heigth);
    void buildConstants(ConstantObjects constantObjects);
    void buildMovables(MovableObjects movableObjects);
    void buildControllables(ControllableObjects controllableObjects);
    World getResult();
}
