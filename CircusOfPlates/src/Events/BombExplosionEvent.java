/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Events;

import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.GameShape;

/**
 *
 * @author User
 */
public class BombExplosionEvent implements Event{
    private Bomb bomb;
    
    public GameShape getRemovedShape() {
        return bomb;
    }

    public BombExplosionEvent(Bomb bomb) {
        this.bomb = bomb;
    }
    
    
    
    
    
    
    
    
}
