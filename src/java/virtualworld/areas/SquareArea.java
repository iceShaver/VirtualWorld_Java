package virtualworld.areas;

import virtualworld.Field;
import virtualworld.Position;
import virtualworld.organisms.Organism;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Kamil on 11.05.2017.
 */
public class SquareArea extends Area {

    private Field[][] fields;

    public SquareArea(int width, int height) {
        super(width, height);
        fields = new Field[height][width];
    }

    @Override
    public Position GetRandomPosition() {
        Random generator = new Random();
        return new Position(generator.nextInt(dimension.getWidth()), generator.nextInt(dimension.getHeight()));
    }

    @Override
    public Position GetRandomPosition(Position position, int range) {
        Position topLeftPosition = new Position(position.getX()-range, position.getY()-range);
        Position bottomRightPosition = new Position(position.getX()+range, position.getY()+range);
        if(topLeftPosition.getX()<0)topLeftPosition.setX(0);
        if(topLeftPosition.getY()<0)topLeftPosition.setY(0);
        if(bottomRightPosition.getX()>=dimension.getWidth()) bottomRightPosition.setX(dimension.getWidth()-1);
        if(bottomRightPosition.getY()>=dimension.getHeight()) bottomRightPosition.setY(dimension.getHeight()-1);
        int availablePositionsWidth = bottomRightPosition.getX()-topLeftPosition.getX();
        int availablePositionsHeight = bottomRightPosition.getY()-topLeftPosition.getY();
        int availablePositionsNumber = availablePositionsHeight*availablePositionsWidth-1;
        if(availablePositionsNumber==0) return null;
        int random = new Random().nextInt(availablePositionsNumber);
        return new Position(random%availablePositionsWidth, random/availablePositionsWidth);
    }

    @Override
    public Position GetEmptyRandomPosition() {
        Random generator = new Random();
        Position result = new Position();
        int counter = dimension.getHeight()*dimension.getWidth()*2;
        while(counter--!=0){
            result.setX(generator.nextInt(dimension.getWidth()));
            result.setY(generator.nextInt(dimension.getHeight()));
            if(GetOrganism(result)==null) return result;
        }

        //Iterate in order and find any place in array
        int x = 0;
        for (Field[] fields : fields) {
            int y = 0;
            for (Field field : fields) {
                if(field.getOrganism()==null) return new Position(x,y);
                    y++;
            }
            x++;
        }
        return null;
    }

    @Override
    public Position GetEmptyRandomPosition(Position position, int range) {
        Position result;
        int counter = (2*range+1)*2;
        while(counter--!=0){
            result = GetRandomPosition();
            if(position==null)return result;
        }

        return null;
    }

    @Override
    public void DrawFields(JPanel worldRepresentationPanel) {
        worldRepresentationPanel.setLayout(new GridLayout(width, height));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fields[i][j] = new Field(null, new JButton());
                fields[i][j].getButton().setContentAreaFilled(false);
                worldRepresentationPanel.add(fields[i][j].getButton());
            }
        }
        worldRepresentationPanel.revalidate();
    }

    @Override
    public Organism GetOrganism(Position position) {
        return fields[position.getY()][position.getX()].getOrganism();
    }

    @Override
    public void pushOrganism(Organism organism) {
        fields[organism.getPosition().getY()][organism.getPosition().getX()].setOrganism(organism);
        fields[organism.getPosition().getY()][organism.getPosition().getX()].getButton().setBackground(organism.getColor());
        fields[organism.getPosition().getY()][organism.getPosition().getX()].getButton().addActionListener(organism);
    }
}
