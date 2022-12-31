package Model.GameObjects.Shapes;

public class CaughtMovingState implements MovingState{

    private GameShape gameShape;

    public CaughtMovingState(GameShape gameShape) {
        this.gameShape = gameShape;
    }

    @Override
    public void move() {
        
    }

    @Override
    public void shapeCaught() {
        
    }

}
