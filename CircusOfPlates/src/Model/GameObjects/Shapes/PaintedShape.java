
package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;
import java.awt.Color;


public interface PaintedShape {
    ImageObject paintShape(Color shapeColor);
    public void setShapeFlyweight(PaintedShapeFlyweight shapeFlyweight);
    public void createFlyWeight(Color shapeColor);
    public PaintedShapeFlyweight getShapeFlyweight();
    
}
