package Model.GameObjects.Shapes;

public class ExplodingState implements ExplosionState {

    private Bomb bomb;
    //private int explosionTime;

    public ExplodingState(Bomb bomb) {
        this.bomb = bomb;
        
    }

    @Override
    public void bombTouchedClown() {
        bomb.setExplosionState(new ExplodedState(bomb));
    }

    @Override
    public boolean doDamage() {
        return true;
    }

}
