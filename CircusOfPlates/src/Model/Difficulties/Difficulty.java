package Model.Difficulties;

import Model.GameObjects.ObjectCollections.HealthBar;
import Model.GameObjects.Shapes.GameShape;


public class Difficulty {
    private Spawner spawner; //Strategy Design Pattern
    private HealthBar healthBar;
   

    public Difficulty(Spawner spawner, HealthBar healthBar) {
        this.spawner = spawner;
        this.healthBar = healthBar;
        
    }

    public Spawner getSpawner() {
        return spawner;
    }

    public HealthBar getHealthBar() {
        return healthBar;
    }
    
    
    
                
}
