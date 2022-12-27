package Model.Difficulties;

import Model.GameObjects.Shapes.GameShape;


public class Difficulty {
    private Spawner spawner; //Strategy Design Pattern

    public Difficulty(Spawner spawner) {
        this.spawner = spawner;
        
    }

    public Spawner getSpawner() {
        return spawner;
    }
    
    
    
                
}
