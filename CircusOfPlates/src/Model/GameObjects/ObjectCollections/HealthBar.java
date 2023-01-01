package Model.GameObjects.ObjectCollections;

import Events.EventHandler;
import Events.HealthBarEmptyEvent;
import Model.GameObjects.Shapes.Heart;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class HealthBar implements GameObject {

    public static final int HEART_OFFSET = 5;
    private int x;
    private int y;
    private int heartCount;
    private Heart[] hearts;
    private boolean visible;

    public HealthBar(int heartCount) {
        this.heartCount = heartCount;
        this.hearts = new Heart[heartCount];
        this.visible = true;
        this.initializeFullHearts();
    }

    private void initializeFullHearts() {
        int heart_x;
        for (int i = 0; i < hearts.length; i++) {
            heart_x = (i + 1) * HEART_OFFSET + i * Heart.SPRITE_WIDTH;
            hearts[i] = new Heart(heart_x, this.y, 1);

        }

    }

    public void loseHeart() {
        heartCount = Integer.max(heartCount - 1, 0);
        if (heartCount == 0) {

            EventHandler.getEventHandler().receiveEvent(new HealthBarEmptyEvent());
        }

    }
    
    public void loseAllHearts(){
        heartCount = 0;
    
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
    public int getWidth() {
        return Heart.SPRITE_WIDTH * heartCount + HEART_OFFSET * (heartCount + 1);
    }

    @Override
    public int getHeight() {
        return Heart.SPRITE_HEIGHT;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return new BufferedImage[]{joinHeartImages()};
    }

    private BufferedImage joinHeartImages() {

        int total_width = this.getWidth();
        int total_height = this.getHeight();
        //create a new buffer and draw two image into the new image
        BufferedImage healthBarImage = new BufferedImage(total_width, total_height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = healthBarImage.createGraphics();

        for (int i = 0; i < heartCount; i++) {
            Heart heart = hearts[i];
            g2.drawImage(heart.getShapeFlyweight().getImage().getSpriteImages()[0], null, heart.getX(), heart.getY());
                        
        }

        g2.dispose();
        return healthBarImage;
    }
}
