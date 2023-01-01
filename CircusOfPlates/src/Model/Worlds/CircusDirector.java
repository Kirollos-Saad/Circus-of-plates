package Model.Worlds;

import Model.Difficulties.ConcreteDifficultyBuilder;
import Model.Difficulties.Difficulty;
import Model.Difficulties.DifficultyBuilder;
import Model.Difficulties.EasySpawner;
import Model.Difficulties.HardSpawner;
import Model.Difficulties.MediumSpawner;
import Model.Factories.DirectlyFallingShapesFactory;
import Model.Factories.RandomlyFallingShapesFactory;
import Model.GameObjects.Clowns.Clown;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.MovableObjects;
import eg.edu.alexu.csd.oop.game.World;

public class CircusDirector {

    public static World getEasyCircus(int width, int height) {
        //Build Difficulty
        DifficultyBuilder difficultyBuilder = new ConcreteDifficultyBuilder();
        difficultyBuilder.buildShapeFactory(new DirectlyFallingShapesFactory());
        difficultyBuilder.buildShapeSpeed(2);
        difficultyBuilder.buildSpawner(new EasySpawner());
        difficultyBuilder.buildHealthBar(10);
        Difficulty easyDifficulty = difficultyBuilder.getResult();

        //Build Circus with Difficulty
        WorldBuilder circusBuilder = new ConcreteCircusBuilder();
        ((CircusBuilder) circusBuilder).setDifficulty(easyDifficulty);
        Clown gameClown = new Clown(100, 430, 30, "/Sprites/Clown 1.png");
        ConstantObjects constantObjects = new ConstantObjects();
        MovableObjects movableObjects = new MovableObjects();
        ControllableObjects controllableObjects = new ControllableObjects(gameClown);
        circusBuilder.buildConstants(constantObjects);
        circusBuilder.buildBackgroundPath("/Sprites/Circus 1.png");
        circusBuilder.buildControllables(controllableObjects);
        circusBuilder.buildMovables(movableObjects);
        circusBuilder.buildDimensions(width, height);
        return circusBuilder.getResult();
    }

    public static World getMediumCircus(int width, int height) {
        //Build Difficulty
        DifficultyBuilder difficultyBuilder = new ConcreteDifficultyBuilder();
        difficultyBuilder.buildShapeFactory(new RandomlyFallingShapesFactory(3));
        difficultyBuilder.buildShapeSpeed(5);
        difficultyBuilder.buildSpawner(new MediumSpawner());
        difficultyBuilder.buildHealthBar(7);
        Difficulty mediumDifficulty = difficultyBuilder.getResult();

        //Build Circus with Difficulty
        WorldBuilder circusBuilder = new ConcreteCircusBuilder();
        ((CircusBuilder) circusBuilder).setDifficulty(mediumDifficulty);
        Clown gameClown = new Clown(100, 430, 30, "/Sprites/Clown 3.png");
        ConstantObjects constantObjects = new ConstantObjects();
        MovableObjects movableObjects = new MovableObjects();
        ControllableObjects controllableObjects = new ControllableObjects(gameClown);
        circusBuilder.buildConstants(constantObjects);
        circusBuilder.buildBackgroundPath("/Sprites/Circus 3.png");
        circusBuilder.buildControllables(controllableObjects);
        circusBuilder.buildMovables(movableObjects);
        circusBuilder.buildDimensions(width, height);
        return circusBuilder.getResult();
    }

    public static World getHardCircus(int width, int height) {
        //Build Difficulty
        DifficultyBuilder difficultyBuilder = new ConcreteDifficultyBuilder();
        difficultyBuilder.buildShapeFactory(new RandomlyFallingShapesFactory(7));
        difficultyBuilder.buildShapeSpeed(7);
        difficultyBuilder.buildSpawner(new HardSpawner());
        difficultyBuilder.buildHealthBar(5);
        Difficulty hardDifficulty = difficultyBuilder.getResult();

        //Build Circus with Difficulty
        WorldBuilder circusBuilder = new ConcreteCircusBuilder();
        ((CircusBuilder) circusBuilder).setDifficulty(hardDifficulty);
        Clown gameClown = new Clown(100, 430, 30, "/Sprites/Clown 2.png");
        ConstantObjects constantObjects = new ConstantObjects();
        MovableObjects movableObjects = new MovableObjects();
        ControllableObjects controllableObjects = new ControllableObjects(gameClown);
        circusBuilder.buildConstants(constantObjects);
        circusBuilder.buildBackgroundPath("/Sprites/Circus 2.png");
        circusBuilder.buildControllables(controllableObjects);
        circusBuilder.buildMovables(movableObjects);
        circusBuilder.buildDimensions(width, height);
        return circusBuilder.getResult();
    }
}
