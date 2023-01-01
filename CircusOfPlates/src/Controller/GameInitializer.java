package Controller;

import Events.EventHandler;
import Model.Worlds.CircusDirector;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;

public class GameInitializer {

    public static GameEngine.GameController startEasyGame(String title, int gameWidth, int gameHeight) {
        GameMenuBar gameMenuBar = new GameMenuBar();
        World initialGameWorld = CircusDirector.getEasyCircus(gameWidth, gameHeight);
        GameEngine.GameController gameController = GameEngine.start(title, initialGameWorld, gameMenuBar, Color.BLACK);
        gameMenuBar.setActionListeners(gameController);

        return gameController;
    }

    public static GameEngine.GameController startMediumGame(String title, int gameWidth, int gameHeight) {
        GameMenuBar gameMenuBar = new GameMenuBar();
        World initialGameWorld = CircusDirector.getMediumCircus(gameWidth, gameHeight);
        GameEngine.GameController gameController = GameEngine.start(title, initialGameWorld, gameMenuBar, Color.BLACK);
        gameMenuBar.setActionListeners(gameController);

        return gameController;
    }

    public static GameEngine.GameController startHardGame(String title, int gameWidth, int gameHeight) {
        GameMenuBar gameMenuBar = new GameMenuBar();
        World initialGameWorld = CircusDirector.getHardCircus(gameWidth, gameHeight);
        GameEngine.GameController gameController = GameEngine.start(title, initialGameWorld, gameMenuBar, Color.BLACK);
        gameMenuBar.setActionListeners(gameController);

        return gameController;
    }

}
