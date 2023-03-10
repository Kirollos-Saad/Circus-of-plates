package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Bomb extends GameShape implements ImageShape {

    private static LinkedList<ImageShapeFlyweight> explosionFlyweights = new LinkedList<>();
    public static final int TYPES_NUMBER = 3;
    public static final int SPRITE_WIDTH = 100;
    public static final int SPRITE_HEIGHT = 100;
    private ImageShapeFlyweight shapeFlyweight;
    private ExplosionState explosionState;

    public Bomb(int speed, int x, int y) {
        super(speed, x, y);
        this.explosionState = new UnExplodedState(this);
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
        return new Ellipse2D.Float(this.getX() + 28, this.getY() + 35, SPRITE_WIDTH / 2, SPRITE_HEIGHT / 2);
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

    public void setExplosionState(ExplosionState explosionState) {
        this.explosionState = explosionState;
    }

    public void bombTouchedClown() {
        explosionState.bombTouchedClown();
    }

    public boolean doDamage() {

        return explosionState.doDamage();
    }

    protected void changeToExplosionFlyWeight() {
        for (int i = 0; i < explosionFlyweights.size(); i++) {
            if (explosionFlyweights.get(i).getImageID() == this.shapeFlyweight.getImageID()) {
                this.setShapeFlyweight(explosionFlyweights.get(i));
            }
        }
        
        createExplosionFlyWeight(this.shapeFlyweight.getImageID());

    }

    
    protected void createExplosionFlyWeight(int imageId) {
        String path = "/Sprites/Explosion " + imageId + ".png";
        this.shapeFlyweight = new ImageShapeFlyweight(new ImageObject(new String[]{path}), imageId);

    }

}
