package Model.GameObjects.Shapes;

public interface ImageShape {

    public void setShapeFlyweight(ImageShapeFlyweight shapeFlyweight);

    public void createFlyWeight(int imageId);

    public ImageShapeFlyweight getShapeFlyweight();
}
