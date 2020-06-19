import java.util.*;

public class Graph {
    private int[][] adj_matrix;
    private int[] power_sequence;
    private int vertex_count;
    Vertex[] vertexes;

    public Graph(){
        setSize();
        setAdj_matrix();
        powerSequenceCreating();
        setVertexes();
    }

    private void setSize(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of vertex: ");
        vertex_count = in.nextInt();
    }

    private void setAdj_matrix(){
        System.out.println("Enter adjacency matrix:");
        adj_matrix = new int[vertex_count][];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < vertex_count; i++) {
            adj_matrix[i] = new int[vertex_count];
            for (int j = 0; j < vertex_count; j++) {
                adj_matrix[i][j] = in.nextInt();
            }
        }
    }

    public boolean isConnected() {
        for (int i = 0; i < vertex_count; i++) {
            if (power_sequence[i] == 0){
                System.out.println("\nGraph is NOT connected!\n");
                return false;
            }
        }
        return true;
    }

    private void powerSequenceCreating(){
        power_sequence = new int[vertex_count];
        for (int i = 0; i < vertex_count; i++) {
            power_sequence[i] = 0;
        }
        for (int i = 0; i < vertex_count; i++) {
            for (int j = 0; j < vertex_count; j++) {
                if (this.adj_matrix[j][i] != 0) power_sequence[i]++;
            }
        }
    }

    public void setVertexes(){
        vertexes = new Vertex[vertex_count];
        for (int i = 0; i < vertex_count; i++){
            vertexes[i] = new Vertex();
            vertexes[i].setNumber(i);
        }
        for (int i = 0; i < vertex_count; i++){
            for (int j = 0; j < vertex_count; j++){
                if (adj_matrix[j][i] == 1) {
                    vertexes[i].adjacency.add(j);
                }
            }
        }
    }

    public boolean isBipartite(){
        PriorityQueue<Integer> mark_queue = new PriorityQueue<Integer>();
        int current;
        for (int i = 0; i < vertex_count; i++){
            if (!vertexes[i].isVisited()){
                vertexes[i].setVisited();
                vertexes[i].setMark(1);
            }
            for (int j = 0; j < vertexes[i].adjacency.size(); j++){
                if (vertexes[vertexes[i].adjacency.get(j)].getMark() == vertexes[i].getMark()) {
                    System.out.println("Graph is NOT BIPARTITE!");
                    return false;
                }
                else if (!vertexes[vertexes[i].adjacency.get(j)].isVisited()){
                    current = vertexes[i].adjacency.get(j);
                    vertexes[current].setVisited();
                    vertexes[current].setMark(vertexes[i].getAnotherMark());
                }
            }
        }
        System.out.println("Graph is BIPARTITE!");
        return true;
    }

    public void greatestMatchingSearch(){
        Vertex[] temp = vertexes.clone();
        Arrays.sort(temp, Vertex::compareTo);
        int current;
        int v, u;
        cancelVisit();
        ArrayDeque<Integer> first_part = new ArrayDeque<Integer>();
        for (int i = 0; i < vertex_count; i++){
            if (temp[i].getMark() == 1) first_part.addLast(temp[i].getNumber());
        }
        System.out.print("Greatest matching: ");
        while (!first_part.isEmpty()){
            current = first_part.pollFirst();
            for (int j = 0; j < vertexes[current].adjacency.size(); j++){
                if (!vertexes[vertexes[current].adjacency.get(j)].isVisited()){
                    v = current + 1;
                    u = vertexes[current].adjacency.get(j) + 1;
                    vertexes[u - 1].setVisited();
                    System.out.print(" [" + v + "," + u + "] ");
                    break;
                }
            }
        }
        System.out.print("\n");
    }

    public void cancelVisit(){
        for (int i = 0; i < vertex_count; i++) vertexes[i].setVisited();
    }
}
