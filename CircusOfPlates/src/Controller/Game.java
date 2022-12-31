package Controller;

import Events.EventHandler;
import eg.edu.alexu.csd.oop.game.GameEngine;

public class Game { //Lazy or Nonlazy Singleton Design pattern

    public static final int GAME_REFRESH = 10;
    private static Game game = new Game("Circus Of Plates", 979, 667); //Non Lazy Singleton
    private GameEngine.GameController gameController;
    private final int screenWidth;
    private final int screenHeigt;

    public static void main(String[] args) {

    }

    private Game(String title, int gameScreenWidth, int gameScreenHeight) {
        this.screenWidth = gameScreenWidth;
        this.screenHeigt = gameScreenHeight;
        this.gameController = GameInitializer.startGame(title, gameScreenWidth, gameScreenHeight);

    }

    public static Game getGameObject() {

        return game;

    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeigt;
    }

}
