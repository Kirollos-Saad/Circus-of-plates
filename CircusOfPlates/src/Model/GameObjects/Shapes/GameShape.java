package Model.GameObjects.Shapes;

import Model.Intersections.Intersectable;
import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class GameShape implements GameObject, Intersectable {

    protected int speed;
    protected int x;
    protected int y;
    protected boolean visible;
    private MovingState movingState;

    public MovingState getMovingState() {
        return movingState;
    }

    public void setMovingState(MovingState movingState) {
        this.movingState = movingState;
    }

    public GameShape(int speed, int x, int y) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.visible = true;
    }

    public int getSpeed() {
        return speed;
    }
    


    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}
