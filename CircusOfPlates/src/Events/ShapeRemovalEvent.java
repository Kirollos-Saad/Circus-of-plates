
package Events;

import Model.GameObjects.Shapes.GameShape;


public interface ShapeRemovalEvent extends Event{
    public GameShape getRemovedShape();
}
