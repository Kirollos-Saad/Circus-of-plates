package Model.GameObjects.Shapes;

import Model.GameObjects.ImageObject;


public class ImageShapeFlyweight {

    private ImageObject image;
    private int imageID;

    public ImageShapeFlyweight(ImageObject image, int imageID) {
        this.image = image;
        this.imageID = imageID;
    }

    public ImageObject getImage() {
        return image;
    }

    public int getImageID() {
        return imageID;
    }
}
