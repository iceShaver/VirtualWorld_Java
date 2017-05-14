package virtualworld.areas;

import virtualworld.Position;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Kamil on 11.05.2017.
 */
public class HexagonalArea extends Area implements Serializable {

    public HexagonalArea(int width, int height, JPanel worldRepresentationPanel) {
        super(width, height, worldRepresentationPanel);
    }

    @Override
    public Position GetRandomPosition() {
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

    @Override
    public void DrawFields() {

    }

    @Override
    public Organism GetOrganism(Position position) {
        return null;
    }

    @Override
    public void pushOrganism(Organism organism) {

    }

    @Override
    public void deleteOrganism(Position position) {

    }

    @Override
    public Position GetRandomPosition(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode) {
        return null;
    }

    @Override
    public Vector<Position> getAllNeighbourPositions(Position position, int range, NeighbourPlaceSearchMode neighbourPlaceSearchMode) {
        return null;
    }
}
