package virtualworld.areas;

import virtualworld.Position;

/**
 * Created by Kamil on 11.05.2017.
 */
public class HexagonalArea extends Area {

    public HexagonalArea(int width, int height) {
        super(width, height);
    }

    @Override
    public Position GetRandomPosition() {
        return null;
    }

    @Override
    public Position GetRandomPosition(Position position, int range) {
        return null;
    }

    @Override
    public Position GetEmptyRandomPosition() {
        return null;
    }

    @Override
    public Position GetEmptyRandomPosition(Position position, int range) {
        return null;
    }

}