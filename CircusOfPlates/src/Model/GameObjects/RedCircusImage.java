package Model.GameObjects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class RedCircusImage implements GameObject { //Singleton
    //Static Members
    public static final String IMAGE_PATH = "/Sprites/Circus.jpg";
    private static RedCircusImage circusImage;
    
    //Instance Members of the Singleton object
    private BufferedImage[] spriteImages;
    private int x;
    private int y;
    private boolean visible;

    private RedCircusImage(int posX, int posY, BufferedImage resizedCircusimage) {
        this.x = posX;
        this.y = posY;
        this.visible = true;
        this.spriteImages = new BufferedImage[1];
        spriteImages[0] = resizedCircusimage;
    }

    public static synchronized RedCircusImage getCircusImage(int sizeX, int sizeY) {
        if (circusImage == null) {
            try {
                BufferedImage img = ImageIO.read(RedCircusImage.class.getResourceAsStream(IMAGE_PATH));
                Image resultingImage = img.getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT);
                BufferedImage resizedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
                resizedImage.getGraphics().drawImage(resultingImage, 0, 0, null);
                circusImage = new RedCircusImage(0, 0, resizedImage);
            } catch (IOException ex) {
                Logger.getLogger(RedCircusImage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return circusImage;

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
