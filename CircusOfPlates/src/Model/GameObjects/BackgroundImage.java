package Model.GameObjects;

public class BackgroundImage extends GameImageObject{ //Singleton with modifications. Singleton might be removed from here
    //Static Members
    private static BackgroundImage backgroundImage;
    
    //Instance Members of the Singleton object
    private int sizeX;
    private int sizeY;
    
    
    
    private BackgroundImage(int sizeX, int sizeY, String path) {
        super(0, 0, sizeX, sizeY, new String[] {path});
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        

    }

    public static synchronized BackgroundImage getBackgroundImage(int sizeX, int sizeY, String path) {
        if (backgroundImage == null) {                
                backgroundImage = new BackgroundImage(sizeX,  sizeY,  path);
           
        }
        return backgroundImage;
    }
    
    public synchronized void changeImage(String path){
        this.imageObject = new ImageObject(new String[] {path});           
    }


}
