package Events;

import Model.GameObjects.Shapes.GameShape;

public class ShapeRemovedFromStackEvent implements Event{
    private GameShape removedShape;

    public GameShape getRemovedShape() {
        return removedShape;
    }

    public ShapeRemovedFromStackEvent(GameShape removedShape) {
        this.removedShape = removedShape;
    }
    
}
