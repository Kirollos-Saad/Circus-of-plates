
package Model.Worlds;

import Events.EventHandler;
import Model.Difficulties.Difficulty;
import Model.Difficulties.DifficultyBuilder;
import Model.Difficulties.EasyDifficultyBuilder;
import Model.Difficulties.EasySpawner;
import Model.Factories.EasyShapeFactory;
import Model.GameObjects.Clowns.Clown;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;

public class CircusDirector {    
    public static World getEasyCircus(int width, int height){
        //Build Difficulty
        DifficultyBuilder difficultyBuilder = new EasyDifficultyBuilder();
        difficultyBuilder.buildShapeFactory(new EasyShapeFactory());
        difficultyBuilder.buildShapeSpeed(2);
        difficultyBuilder.buildSpawner(new EasySpawner());
        Difficulty easyDifficulty = difficultyBuilder.getResult();
        
        
        
        //Build Circus with Difficulty
        WorldBuilder circusBuilder = new BasicCircusBuilder();
        ((CircusBuilder) circusBuilder).setDifficulty(easyDifficulty);
        Clown gameClown = new Clown(100, 430, 30, "/Sprites/Clown.png");
        ConstantObjects constantObjects = new ConstantObjects();
        MovableObjects movableObjects = new MovableObjects();
        ControllableObjects controllableObjects = new ControllableObjects(gameClown);
        circusBuilder.buildConstants(constantObjects);
        circusBuilder.buildBackgroundPath("/Sprites/Circus.png");
        circusBuilder.buildControllables(controllableObjects);
        circusBuilder.buildMovables(movableObjects);
        circusBuilder.buildDimensions(width, height);
        
        
        //Adjusting EventHandler
        EventHandler eventHandler = EventHandler.getEventHandler();
        eventHandler.setConstantObjects(constantObjects);
        eventHandler.setControllableObjects(controllableObjects);
        eventHandler.setMovableObjects(movableObjects);
        
        return circusBuilder.getResult();
        
    
    }
}
