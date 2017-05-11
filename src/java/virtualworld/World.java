package virtualworld;
import com.google.common.collect.TreeMultiset;
import virtualworld.areas.Area;
import virtualworld.areas.HexagonalArea;
import virtualworld.areas.SquareArea;
import virtualworld.organisms.Organism;
/**
 * Created by Kamil on 11.05.2017.
 */
public class World {
    private Area area;
    public World(GameInitializer gameInitializer) {
        if(gameInitializer.areaType == AreaType.SQUARE) area = new SquareArea(gameInitializer.width, gameInitializer.height);
        else if(gameInitializer.areaType==AreaType.HEX) area = new HexagonalArea(gameInitializer.width, gameInitializer.height);
    }

    public void Collide(Organism attacker, Organism attacked){

    }
    TreeMultiset<Organism> organisms;
}
