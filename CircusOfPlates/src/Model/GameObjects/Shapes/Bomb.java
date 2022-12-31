package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Bomb extends GameShape implements ImageShape{
    public static final int TYPES_NUMBER = 3;
    public static final int SPRITE_WIDTH = 100;
    public static final int SPRITE_HEIGHT = 100;
    private ImageShapeFlyweight shapeFlyweight;

    public Bomb(int speed, int x, int y) {
        super(speed, x, y);
    }

    @Override
    public int getWidth() {
        return shapeFlyweight.getImage().getSpriteImages()[0].getWidth();
    }

    @Override
    public int getHeight() {
        return shapeFlyweight.getImage().getSpriteImages()[0].getHeight();
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return shapeFlyweight.getImage().getSpriteImages();
    }

    @Override
    public Shape getIntersectionFrame() {
        return new Ellipse2D.Float(this.getX(), this.getY(), SPRITE_WIDTH, SPRITE_HEIGHT);
    }

    // Used when creating shape from already existing flyweight
    @Override
    public void setShapeFlyweight(ImageShapeFlyweight shapeFlyweight) {
        this.shapeFlyweight = shapeFlyweight;
    }

    // Used when creating shape for without already existing flyweight
    @Override
    public void createFlyWeight(int imageId) {
        String path = "/Sprites/Bomb " + imageId + ".png";
        this.shapeFlyweight = new ImageShapeFlyweight(new ImageObject(new String[]{path}), imageId);

    }

    @Override
    public ImageShapeFlyweight getShapeFlyweight() {
        return shapeFlyweight;
    }

}
