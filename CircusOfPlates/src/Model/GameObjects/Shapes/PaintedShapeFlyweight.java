package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Color;


public class PaintedShapeFlyweight {
    private ImageObject image;
    private Color shapeColor;

    public PaintedShapeFlyweight(ImageObject image, Color shapeColor) {
        this.image = image;
        this.shapeColor = shapeColor;
    }

    public ImageObject getImage() {
        return image;
    }

    public Color getShapeColor() {
        return shapeColor;
    }
    
}
