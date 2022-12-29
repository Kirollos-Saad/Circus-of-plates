
package Controller;

import Model.Worlds.CircusDirector;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;


public class GameInitializer {
    
    public static GameEngine.GameController startGame(String title, int gameWidth, int gameHeight){
        GameMenuBar gameMenuBar = new GameMenuBar();
        World initialGameWorld = CircusDirector.getEasyCircus(gameWidth, gameHeight);
        GameEngine.GameController gameController = GameEngine.start(title, initialGameWorld, gameMenuBar, Color.BLACK);		
        gameMenuBar.setActionListeners(gameController);
        return gameController;
    }
              
}
