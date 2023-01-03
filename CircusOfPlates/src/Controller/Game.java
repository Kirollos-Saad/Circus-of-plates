package Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import javax.swing.JFrame;

public class Game { //Singleton Design pattern

    public static final int GAME_REFRESH = 10;
    private static Game game;
    private GameEngine.GameController gameController;
    private String gameTitle;
    private final int screenWidth;
    private final int screenHeigt;

    private Game() {
        this.screenWidth = 979;
        this.screenHeigt = 667;
        this.gameTitle = "Circus Of Plates";        
        
        
    }

    public static Game getGameObject() {
        if (game == null) {
            game = new Game();
        }
        return game;

    }

    public void setWorld(World gameWorld){
        GameMenuBar gameMenuBar = new GameMenuBar();
        this.gameController = GameEngine.start(this.gameTitle, gameWorld, gameMenuBar, Color.BLACK);
        gameMenuBar.setActionListeners(gameController);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeigt;
    }

}
