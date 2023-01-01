package Events;

import Model.GameObjects.Shapes.GameShape;

public class ShapeBeyondScreenBottomEvent implements Event {

    private GameShape removedShape;

    public GameShape getRemovedShape() {
        return removedShape;
    }

    public ShapeBeyondScreenBottomEvent(GameShape removedShape) {
        this.removedShape = removedShape;
    }
}
