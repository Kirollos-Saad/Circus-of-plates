
package Events;

import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.GameShape;


public class BombExplosionEvent implements Event{
    private Bomb bomb;
    
    public GameShape getRemovedShape() {
        return bomb;
    }

    public BombExplosionEvent(Bomb bomb) {
        this.bomb = bomb;
    }
    
    
    
    
    
    
    
    
}
