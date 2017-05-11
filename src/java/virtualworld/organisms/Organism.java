package virtualworld.organisms;

import virtualworld.Position;
import virtualworld.World;

/**
 * Created by Kamil on 11.05.2017.
 */
public abstract class Organism {
    public abstract void Act();




    protected int strength;
    protected Position position;
    protected int age;
    protected World world;
    private int initiative;
}
