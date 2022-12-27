package Model.GameObjects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageObject implements GameObject {

    protected BufferedImage[] spriteImages;
    private int x;
    private int y;
    private boolean visible;

    public ImageObject(int posX, int posY, String path) {
        this(posX, posY, path, 1);
    }

    public ImageObject(int posX, int posY, String path, int spriteCount) {
        this.x = posX;
        this.y = posY;      
        this.visible = true;
        this.spriteImages = new BufferedImage[spriteCount];
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
            System.out.println("Image loaded once");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }



}
