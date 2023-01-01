
package Events;

import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.GameShape;


public class BombExplosionEvent implements Event{
    private GameShape bomb;
    
    public GameShape getBomb() {
        return bomb;
    }

    public BombExplosionEvent(GameShape bomb) {
        this.bomb = bomb;
    }
    
    
    
    
    
    
    
    
}
