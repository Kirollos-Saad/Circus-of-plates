package Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;
import javax.swing.JFrame;

public class Game { //Lazy or Nonlazy Singleton Design pattern

    public static final int GAME_REFRESH = 10;
    private static Game game;  //Non Lazy Singleton
    private GameEngine.GameController gameController;
    private final int screenWidth;
    private final int screenHeigt;
    static String gameMode = "Easy";
    private JFrame menu;

    private Game(String title, int gameScreenWidth, int gameScreenHeight) {
        this.screenWidth = gameScreenWidth;
        this.screenHeigt = gameScreenHeight;

        if (gameMode.equals("Easy")) {
            this.gameController = GameInitializer.startEasyGame(title, gameScreenWidth, gameScreenHeight);
        } else if (gameMode.equals("Medium")) {
            this.gameController = GameInitializer.startMediumGame(title, gameScreenWidth, gameScreenHeight);
            System.out.println("Medium");
        } else if (gameMode.equals("Hard")) {
            this.gameController = GameInitializer.startHardGame(title, gameScreenWidth, gameScreenHeight);
        }

    }

    public JFrame getMenu() {
        return menu;
    }

    public void setMenu(JFrame menu) {
        this.menu = menu;
    }
    

    protected static void setDifficulty(String gameModeString) {
        if (gameModeString.equals("Easy")) {
            gameMode = "Easy";
        } else if (gameModeString.equals("Medium")) {
            gameMode = "Medium";
        } else if (gameModeString.equals("Hard")) {
            gameMode = "Hard";
        }

    }

    public static Game getGameObject() {
        if (game == null) {
            game = new Game("Circus Of Plates", 979, 667);
        }
        return game;

    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeigt;
    }

}
