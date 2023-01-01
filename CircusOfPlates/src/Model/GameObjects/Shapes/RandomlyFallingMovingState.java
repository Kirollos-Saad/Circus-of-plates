package Model.GameObjects.Shapes;

import Controller.Game;
import java.util.Random;

public class RandomlyFallingMovingState implements MovingState {

    private GameShape gameShape;
    private int randomRange;

    public RandomlyFallingMovingState(GameShape gameShape, int range) {
        this.gameShape = gameShape;
        this.randomRange = range;
    }

    @Override
    public void move() {
        gameShape.setY(gameShape.getY() + gameShape.getSpeed());
        int max = randomRange;
        int min = -randomRange;
        int nextX = gameShape.getX() + new Random().nextInt(max + 1 - min) + min;
        if (nextX < 0 || nextX > Game.getGameObject().getScreenWidth() - gameShape.getWidth()) {

            return;
        }
        gameShape.setX(nextX);
        
        
        if(new Random().nextInt(100) == 1){
            gameShape.setMovingState(new FallingMovingState(gameShape));
        
        }

    }

    @Override
    public void shapeCaught() {
        gameShape.setMovingState(new CaughtMovingState(gameShape));
    }

}
