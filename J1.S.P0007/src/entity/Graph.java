package entity;

import java.util.Arrays;

public class Graph {
    private boolean[][]  adjacencyMatrix;
    private int numberOfVerteces;

    public Graph(int numberOfVerteces) {
        this.numberOfVerteces = numberOfVerteces;
        this.adjacencyMatrix = new boolean[numberOfVerteces][numberOfVerteces];
    }

    public void addEdge(int v1, int v2){
            adjacencyMatrix[v1][v2] = true;
            adjacencyMatrix[v2][v1] = true;

    }

    public boolean isEdge(int v1, int v2){
            return (adjacencyMatrix[v1][v2]|| adjacencyMatrix[v2][v1]);
    }
}
