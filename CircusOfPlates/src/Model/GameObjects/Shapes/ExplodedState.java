package Model.GameObjects.Shapes;

public class ExplodedState implements ExplosionState {

    private Bomb bomb;

    public ExplodedState(Bomb bomb) {
        this.bomb = bomb;
    }

    @Override
    public void bombTouchedClown() {
        
    }

    @Override
    public boolean doDamage() {
        return false;
    }

}
