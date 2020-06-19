import java.util.Scanner;

public class Runner {
    public  static void main(String[] argv){
        Graph graph = new Graph();

        if (graph.isConnected()) {
            if (graph.isBipartite()) {
                graph.greatestMatchingSearch();
            }
        }
    }
}