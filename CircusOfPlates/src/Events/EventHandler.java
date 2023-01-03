package Events;

import Controller.Game;
import Model.GameObjects.ObjectCollections.ConstantObjects;
import Model.GameObjects.ObjectCollections.ControllableObjects;
import Model.GameObjects.ObjectCollections.HealthBar;
import Model.GameObjects.ObjectCollections.MovableObjects;
import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.ScoreBoard;
import Model.Worlds.Circus;

public class EventHandler { //Singleton

    private static EventHandler eventHandler;

    private EventHandler() {
    }

    public static synchronized EventHandler getEventHandler() {
        if (eventHandler == null) {
            eventHandler = new EventHandler();
        }
        return eventHandler;

    }

    private MovableObjects movableObjects;
    private HealthBar healthBar;
    private Circus gameCircus;
    private ScoreBoard scoreBoard;

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void setGameCircus(Circus gameCircus) {
        this.gameCircus = gameCircus;
    }

    public void setHealthBar(HealthBar healthBar) {
        this.healthBar = healthBar;
    }

    public void setMovableObjects(MovableObjects movableObjects) {
        this.movableObjects = movableObjects;
    }

//    public void receiveEvent(Event e) {
//        System.out.println("hello event worked");
// 
//    }

    public void receiveEvent(ShapeRemovedFromStackEvent e) {

        movableObjects.removeGameObject(e.getRemovedShape());
        scoreBoard.incrementScore();
    }

    public void receiveEvent(ShapeBeyondScreenBottomEvent e) {

        movableObjects.removeGameObject(e.getRemovedShape());
    }

    public void recieveEvent(BombExplosionEvent e) {
        if (((Bomb) e.getBomb()).doDamage()) {
            healthBar.loseHeart();
        }

        //notify score.
    }

    public void receiveEvent(HealthBarEmptyEvent e) {
        healthBar.loseAllHearts();
        Game.getGameObject().getMenu().setVisible(false);
        gameCircus.loseGame();

    }

}
