package Events;

import Model.GameObjects.Shapes.GameShape;

public class ShapeBeyondScreenBottomEvent{

    private GameShape removedShape;

    public GameShape getRemovedShape() {
        return removedShape;
    }

    public ShapeBeyondScreenBottomEvent(GameShape removedShape) {
        this.removedShape = removedShape;
    }
}
