package Test;

import Model.GameObjects.ImageObject;
import Model.GameObjects.BackgroundImage;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

    public static void main(String[] args) {
        
        BufferedImage img = new ImageObject(new String[] {"/Sprites/Clown.png"}, ).getSpriteImages()[0];

        JFrame frame = new JFrame();
        
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
 
        frame.pack();
        frame.setVisible(true);

    }
}
