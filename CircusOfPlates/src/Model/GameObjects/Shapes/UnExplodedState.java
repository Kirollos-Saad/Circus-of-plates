
package Model.GameObjects.Shapes;


public class UnExplodedState implements ExplosionState{
    private Bomb bomb;

    public UnExplodedState(Bomb bomb) {
        this.bomb = bomb;
    }

    @Override
    public void bombTouchedClown() {
        
       bomb.setExplosionState(new ExplodingState(bomb));
            
    }

    @Override
    public boolean doDamage() {
        return false;
    }
    
    
}
