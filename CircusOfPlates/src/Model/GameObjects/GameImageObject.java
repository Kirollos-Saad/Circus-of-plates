package Model.GameObjects;


import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;


public class GameImageObject implements GameObject {

    protected ImageObject imageObject;
    private int x;
    private int y;
    private boolean visible;

    public GameImageObject(int posX, int posY, String[] spritePaths) {
        this.imageObject = new ImageObject(spritePaths);
        this.x = posX;
        this.y = posY;
        this.visible = true;
    }

    public GameImageObject(int posX, int posY, int sizeX, int sizeY, String[] spritePaths) {
        this.imageObject = new ImageObject(spritePaths, sizeX, sizeY);
        this.x = posX;
        this.y = posY;
        this.visible = true;
    }
    
    
    

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        this.x = mX;
        
    }

    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public void setY(int mY) {
        this.y = mY;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return imageObject.getSpriteImages();
    }

    @Override
    public int getWidth() {
        return imageObject.getSpriteImages()[0].getWidth();
    }

    @Override
    public int getHeight() {
        return imageObject.getSpriteImages()[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
