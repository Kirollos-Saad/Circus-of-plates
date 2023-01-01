package Model.Worlds;

import Model.Difficulties.Difficulty;


public interface CircusBuilder {
    public static final int HEALTH_BAR_X = 0;
    public static final int HEALTH_BAR_Y = 10;
    
    void setDifficulty(Difficulty difficulty);
}
