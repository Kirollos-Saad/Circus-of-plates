package Model.GameObjects.Shapes;

public class FallingMovingState implements MovingState {

    private GameShape gameShape;

    public FallingMovingState(GameShape gameShape) {
        this.gameShape = gameShape;
    }

    @Override
    public void move() {
        gameShape.setY(gameShape.getY()+gameShape.getSpeed());
    }
    
    public void shapeCaught(){
        gameShape.setMovingState(new CaughtMovingState(gameShape));
    
    }
    
    

}
