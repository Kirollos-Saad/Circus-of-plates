package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Heart implements ImageShape, GameObject {

    public static final int SPRITE_WIDTH = 40;
    public static final int SPRITE_HEIGHT = 38;
    private static LinkedList<ImageShapeFlyweight> heartFlyweights = new LinkedList<>();
    private boolean visible;

    private ImageShapeFlyweight shapeFlyweight;
    private int x;
    private int y;

    public Heart(int x, int y, int heartType) {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.checkForFlyWeight(heartType);
        
        
        
        
    }
    
    
    private void checkForFlyWeight(int heartType){
        for(ImageShapeFlyweight flyweight: heartFlyweights){
            if(flyweight.getImageID() == heartType){
                this.shapeFlyweight= flyweight;
                return;
            }
        }
        
        createFlyWeight(heartType);
    }

    @Override    
    public void setShapeFlyweight(ImageShapeFlyweight shapeFlyweight) {
        this.shapeFlyweight = shapeFlyweight;
    }

    @Override
    public void createFlyWeight(int imageId) {
        String path = "/Sprites/Heart " + imageId + ".png";
        //String path = "/Sprites/Heart 1.png";
        //this.shapeFlyweight = new ImageShapeFlyweight(new ImageObject(new String[]{path}, SPRITE_WIDTH, SPRITE_HEIGHT ), imageId);
        this.shapeFlyweight = new ImageShapeFlyweight(new ImageObject(new String[]{path} ), imageId);
    }

    @Override
    public ImageShapeFlyweight getShapeFlyweight() {
        return shapeFlyweight;
    }

    @Override
    public int getWidth() {
        return SPRITE_WIDTH;
    }

    @Override
    public int getHeight() {
        return SPRITE_HEIGHT;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return shapeFlyweight.getImage().getSpriteImages();
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
