package Model.Difficulties;

import Controller.Game;
import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.ObjectCollections.GameObjectCollection;
import Model.GameObjects.Shapes.Bomb;
import Model.GameObjects.Shapes.GameShape;
import java.awt.Color;
import java.awt.Point;

public class MediumSpawner extends Spawner {

    @Override
    public void spawnShapeInContainer(GameObjectCollection container) {
        GameShape spawnedShape = this.spawnShape();
        if (spawnedShape != null) {
            container.addGameObject(spawnedShape);
        }
    }

    @Override
    public GameShape spawnShape() {
        AbstractShapeFactory shapeFactory = getShapeFactory();
        Point shapeCoordinates = generatePosition();
        int random = generateRandom(100);
        switch (random) {
            case 0:
                return shapeFactory.getBall(shapeCoordinates.x, shapeCoordinates.y, generateColor());

            case 1:
                return shapeFactory.getSquare(shapeCoordinates.x, shapeCoordinates.y, generateColor());

            case 2:
                return shapeFactory.getPlate(shapeCoordinates.x, shapeCoordinates.y, generateColor());
            case 3:
                return generateRandom(3, 5) == 3 ? shapeFactory.getBomb(shapeCoordinates.x, shapeCoordinates.y, generateRandom(1, Bomb.TYPES_NUMBER)) : spawnShape();

            default:
                return null;

        }
    }

    @Override
    protected Color generateColor() {
        int random = generateRandom(5);
        switch (random) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.WHITE;
            default:
                return null;

        }
    }

    @Override
    protected Point generatePosition() {
        int screenWidth = Game.getGameObject().getScreenWidth();
        int screenHeight = Game.getGameObject().getScreenHeight();

        int xmin = (int) (screenWidth / 10);
        int xmax = (int) (9 * screenWidth / 10);
        int ymin = -40;
        int ymax = (int) (screenWidth / 10);
        return new Point(generateRandom(xmin, xmax), generateRandom(ymin, ymax));
    }
}
