
package Model.Worlds;

import Model.Difficulties.Difficulty;
import Model.Difficulties.DifficultyBuilder;
import Model.Difficulties.EasyDifficultyBuilder;
import Model.Difficulties.EasySpawner;
import Model.GameObjects.Clowns.Clown;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;

public class CircusChooser {  //Factory  
    public static World getEasyCircus(int width, int height){
        //Build Difficulty
        DifficultyBuilder difficultyBuilder = new EasyDifficultyBuilder();
        difficultyBuilder.buildShapeFactory();
        difficultyBuilder.buildShapeSpeed(10);
        difficultyBuilder.buildSpawner(new EasySpawner());
        Difficulty easyDifficulty = difficultyBuilder.getResult();
        
        
        
        //Build Circus with Difficulty
        WorldBuilder redCircusBuilder = new RedCircusBuilder();
        ((CircusBuilder) redCircusBuilder).setDifficulty(easyDifficulty);
        Clown gameClown = new Clown(100, 430, "/Sprites/Clown.png");
        ConstantObjects constantObjects = new ConstantObjects();
        MovableObjects movableObjects = new MovableObjects();
        ControllableObjects controllableObjects = new ControllableObjects(gameClown);
        redCircusBuilder.buildConstants(constantObjects);
        redCircusBuilder.buildControllables(controllableObjects);
        redCircusBuilder.buildMovables(movableObjects);
        redCircusBuilder.buildDimensions(width, height);
        return redCircusBuilder.getResult();
        
    
    }
}
