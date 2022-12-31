package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Plate extends GameShape implements PaintedShape {

    //Original Dimensions were 54, and 30 please don't delete this comment 
    public static final int SPRITE_WIDTH = 54;
    public static final int SPRITE_HEIGHT = 30;
    private PaintedShapeFlyweight shapeFlyweight;

    public Plate(int speed, int x, int y) {
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
    public ImageObject paintShape(Color shapeColor) {
        int horizontalRadius = SPRITE_WIDTH / 2;
        int verticalRadius = SPRITE_HEIGHT / 6;
        Point point1 = new Point(0, verticalRadius);
        Point point2 = new Point(2 * horizontalRadius, verticalRadius);
        Point point3 = new Point((5 * horizontalRadius) / 3, 6 * verticalRadius);
        Point point4 = new Point(horizontalRadius / 3, 6 * verticalRadius);

        BufferedImage[] bufferedImages = new BufferedImage[1];
        bufferedImages[0] = new BufferedImage(SPRITE_WIDTH, SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImages[0].createGraphics();
        g2.setColor(shapeColor);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Drawing Plate Base
        g2.fillPolygon(new int[]{point1.x, point2.x, point3.x, point4.x}, new int[]{point1.y, point2.y, point3.y, point4.y}, 4);

        //Drawing Plate Top
        g2.setColor(Color.BLACK); //Top is always black
        g2.fillOval(0, 0, horizontalRadius * 2, verticalRadius * 2);
        
        
        
        //Debugging
        
        g2.setColor(Color.RED);
        g2.draw(new Rectangle2D.Double(SPRITE_WIDTH/6, 0.8 * SPRITE_HEIGHT ,(2*SPRITE_WIDTH)/3,  0.2 * SPRITE_HEIGHT));
        
        
        g2.dispose();
        
        

       return new ImageObject(bufferedImages);
    }

    @Override
    public void setShapeFlyweight(PaintedShapeFlyweight shapeFlyweight) {
        this.shapeFlyweight = shapeFlyweight;
    }

    @Override
    public void createFlyWeight(Color shapeColor) {
        this.shapeFlyweight = new PaintedShapeFlyweight(paintShape(shapeColor), shapeColor);
    }

    @Override
    public PaintedShapeFlyweight getShapeFlyweight() {
        return shapeFlyweight;
    }

    @Override
    public Shape getIntersectionFrame() {

        int xPos = getX()+(SPRITE_WIDTH/6);
        int yPos = getY()+  (4*SPRITE_HEIGHT)/5;

        return new Rectangle2D.Double(xPos, yPos ,(2*SPRITE_WIDTH)/3,  0.2 * SPRITE_HEIGHT);
    }

}
