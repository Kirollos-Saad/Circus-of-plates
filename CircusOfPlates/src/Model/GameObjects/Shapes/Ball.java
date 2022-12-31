package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends GameShape implements PaintedShape {

    public static final int SPRITE_WIDTH = 40;
    public static final int SPRITE_HEIGHT = 40;

    private PaintedShapeFlyweight shapeFlyweight;

    public PaintedShapeFlyweight getShapeFlyweight() {
        return shapeFlyweight;
    }

    public Ball(int speed, int x, int y) {
        super(speed, x, y);
    }

    // Used when creating shape from already existing flyweight
    public void setShapeFlyweight(PaintedShapeFlyweight shapeFlyweight) {
        this.shapeFlyweight = shapeFlyweight;
    }

    // Used when creating shape for without already existing flyweight
    public void createFlyWeight(Color shapeColor) {
        this.shapeFlyweight = new PaintedShapeFlyweight(paintShape(shapeColor), shapeColor);

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
    public ImageObject paintShape(Color shapeColor) {
        BufferedImage[] bufferedImages = new BufferedImage[1];
        bufferedImages[0] = new BufferedImage(SPRITE_WIDTH, SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImages[0].createGraphics();
        g2.setColor(shapeColor);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillOval(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT);

        //Debugging
        g2.setColor(Color.RED);
        g2.draw(new Rectangle2D.Double(0, 0.8 * SPRITE_HEIGHT, SPRITE_WIDTH-2, 0.2 * SPRITE_HEIGHT-2));

        g2.dispose();
        return new ImageObject(bufferedImages);
    }

    @Override
    public Shape getIntersectionFrame() {
        return new Rectangle2D.Double(this.getX(), this.getY() + 0.8 * SPRITE_HEIGHT, SPRITE_WIDTH, 0.2 * SPRITE_HEIGHT);
    }

}
