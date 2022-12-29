package Model.GameObjects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageObject {

    private BufferedImage[] spriteImages;

    public ImageObject(String[] spritePaths) {
        spriteImages = new BufferedImage[spritePaths.length];
        for (int i = 0; i < spritePaths.length; i++) {
            spriteImages[i] = readImage(spritePaths[i]);
        }
    }

    public ImageObject(String[] spritePaths, int sizeX, int sizeY) {
        this(spritePaths);
        for (int i = 0; i < spritePaths.length; i++) {
            spriteImages[i] = getResizedImage(spriteImages[i], sizeX, sizeY);
        }
    }
    
    public ImageObject(BufferedImage[] spriteImages){
        this.spriteImages = spriteImages;
    }

    private BufferedImage readImage(String path) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Logger.getLogger(ImageObject.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    private BufferedImage getResizedImage(BufferedImage originalImage, int sizeX, int sizeY) {
        Image resultingImage = originalImage.getScaledInstance(sizeX, sizeY, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
        resizedImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return resizedImage;
    }

    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

}
