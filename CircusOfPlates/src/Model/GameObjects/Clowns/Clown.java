package Model.GameObjects.Clowns;

import Model.GameObjects.GameImageObject;
import Model.GameObjects.ObjectCollections.ShapeStack;
import static Model.GameObjects.Shapes.Ball.SPRITE_HEIGHT;
import static Model.GameObjects.Shapes.Ball.SPRITE_WIDTH;
import static Model.GameObjects.Shapes.Plate.SPRITE_HEIGHT;
import static Model.GameObjects.Shapes.Plate.SPRITE_WIDTH;
import Model.Intersections.Intersectable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Clown extends GameImageObject implements Intersectable {

    private int speed;

    public ShapeStack getRightStack() {
        return rightStack;
    }

    public ShapeStack getLeftStack() {
        return leftStack;
    }
    private ShapeStack rightStack;
    private ShapeStack leftStack;

    public Clown(int x, int y, int speed, String path) {
        super(x, y, new String[]{path});
        this.speed = speed;
        initializeStacks();
    }

    private void initializeStacks() {
        this.rightStack = new ShapeStack(this, new Point(3, 34));
        this.leftStack = new ShapeStack(this, new Point(174, 34));

    }

    @Override
    public void setX(int mX) {
        super.setX(mX);

        rightStack.updateStack();
        leftStack.updateStack();

    }

    @Override
    public void setY(int mY) {
        //Do nothing

    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public Shape getIntersectionFrame() {
        
        
        return null;
    }
    
    public Shape[] getMorethanOneIntersectionFrame()
    {
        Rectangle2D r1 = new Rectangle2D.Double(this.getX() + 6,this.getY() + 56,202,22);
        Rectangle2D r2 = new Rectangle2D.Double(this.getX()+76 ,this.getY() + 4 ,59 ,191);
        Rectangle2D[] r = new Rectangle2D[2];
        
//        BufferedImage[] bufferedImages = new BufferedImage[1];
//        bufferedImages[0] = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = bufferedImages[0].createGraphics();
//        g2.fillPolygon(new int[]{this.getX() + 6, this.getX() + 6, this.getX() + 208, this.getX() + 208}, new int[]{this.getY() + 56,this.getY() + 78, this.getY() + 78, this.getY() + 56}, 4);
        r[0] = r1;
        r[1] = r2;
        return r;
    }

}
