package Controller;

import eg.edu.alexu.csd.oop.game.GameEngine;



public class Game {
    
    private static GameEngine.GameController gameController; 
    public static final int GAME_REFRESH =10;    
    public static void main(String[] args) {
        gameController = GameInitializer.startGame("Circus Of Plates",979, 667);
        
    }
}
