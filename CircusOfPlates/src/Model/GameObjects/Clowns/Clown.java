package Model.GameObjects.Clowns;


import Model.GameObjects.GameImageObject;


public class Clown extends GameImageObject{
    private int speed;
    
    public Clown(int x, int y, int speed, String path) {
        super(x, y, new String[] {path});
        this.speed = speed;

    }

    @Override
    public void setY(int mY) {
        //Do nothing
    }

    public int getSpeed() {
        return speed;
    }

}
