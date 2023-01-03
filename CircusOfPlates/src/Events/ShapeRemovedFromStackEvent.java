package Events;

import Model.GameObjects.Shapes.GameShape;

public class ShapeRemovedFromStackEvent{
    private GameShape removedShape;

    public GameShape getRemovedShape() {
        return removedShape;
    }

    public ShapeRemovedFromStackEvent(GameShape removedShape) {
        this.removedShape = removedShape;
    }
    
}
