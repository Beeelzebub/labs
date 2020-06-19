import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    private int number;
    private int mark;
    public ArrayList<Integer> adjacency;
    private boolean visited;
    private int max_eccentricity;
    private boolean centre;

    public Vertex(){
        adjacency = new ArrayList<Integer>();
        visited = false;
        centre = false;
        mark = 0;
    }

    public void setMax_eccentricity(int value){
        max_eccentricity = value;
    }

    public int getAnotherMark(){
        if (this.mark == 1) return 2;
        else return 1;
    }

    public void setVisited() {
        visited = !visited;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.adjacency.size() - o.adjacency.size();
    }

    public void setMark(int mark){
        this.mark = mark;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setCentre(){
        centre = true;
    }

    public boolean isCentre(){
        return centre;
    }

    public boolean isVisited(){
        return visited;
    }

    public int getMark() {
        return mark;
    }

    public int getNumber(){
        return number;
    }

    public int getMax_eccentricity(){
        return max_eccentricity;
    }
}
