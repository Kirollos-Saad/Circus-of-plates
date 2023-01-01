package Model.GameObjects.Shapes;

import Controller.Game;
import Model.GameObjects.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;

public class ScoreBoard implements GameObject {

    public static final int CHAR_WIDTH = 30;
    private int x;
    private int y;
    private boolean visible;
    private int score;

    public ScoreBoard() {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.score = 0;        
    }

    public void incrementScore(int increment) {
        score += increment;        

    }

    public void decrementScore(int decrement) {
        score -= decrement;
        score = Integer.max(0, score);      
    }
    
    public void calculateCoordinates(){
        setX(Game.getGameObject().getScreenWidth()-this.getWidth());
        setY(0);
        
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
        return (7 + String.valueOf(score).length()) * (CHAR_WIDTH/2);

    }

    @Override
    public int getHeight() {
        return CHAR_WIDTH;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        calculateCoordinates();
        BufferedImage[] bufferedImages = new BufferedImage[1];
        bufferedImages[0] = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImages[0].createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(java.awt.Color.BLACK);
        Font font = new Font("Serif", Font.BOLD, CHAR_WIDTH);
        g2.setFont(font);

        g2.drawString("Score: " +score, 0, 30);

        return bufferedImages;
    }

}
