package Model.Difficulties;

import Controller.Game;
import Model.Factories.AbstractShapeFactory;
import Model.GameObjects.ObjectCollections.GameObjectCollection;
import Model.GameObjects.Shapes.GameShape;
import java.awt.Color;
import java.awt.Point;

public class EasySpawner extends Spawner {

//    @Override
//    public GameShape spawnShape() {
//        AbstractShapeFactory shapeFactory = getShapeFactory();
//        int random = generateRandom(10);
//        switch (random) {
//            case 0:
//                return shapeFactory.getBall();
//            case 1:
//                return shapeFactory.getPlate();
//            case 2:
//                return shapeFactory.getTriangle();
//            case 3:
//                return generateRandom(4) == 3 ? shapeFactory.getBomb() : spawnShape();
//            default:
//                return null;
//
//        }
//    }
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
        int random = generateRandom(10);
        switch (random) {
            case 0:
                return shapeFactory.getBall(shapeCoordinates.x, shapeCoordinates.y, generateColor());

            case 1:
                return shapeFactory.getSquare(shapeCoordinates.x, shapeCoordinates.y, generateColor());

            default:
                return null;

        }
    }

    @Override
    protected Color generateColor() {
        int random = generateRandom(4);
        switch (random) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;

            default:
                return null;

        }
    }

    @Override
    protected Point generatePosition() {
        int screenWidth = Game.getGameObject().getScreenWidth();
        int screenHeight = Game.getGameObject().getScreenHeight();

        int xmin = (int) (screenWidth / 4);
        int xmax = (int) (3 * screenWidth / 4);
        int ymin = -10;
        int ymax = (int) (screenWidth / 4);
        return new Point(generateRandom(xmin, xmax), generateRandom(ymin, ymax));
    }

}
