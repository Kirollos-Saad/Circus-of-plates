
package Events;

import Model.GameObjects.Shapes.GameShape;


public class ShapeBeyondScreenBottomEvent implements ShapeRemovalEvent{
        private GameShape removedShape;

    public GameShape getRemovedShape() {
        return removedShape;
    }

    public ShapeBeyondScreenBottomEvent(GameShape removedShape) {
        this.removedShape = removedShape;
    }
}
