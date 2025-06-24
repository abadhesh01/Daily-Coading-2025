package sample.graph;

import java.util.HashMap;
import java.util.List;

public class Graph {

    private final HashMap<Integer, List<Integer>> adjacentList;
    private final int numberOfNodes;

    public HashMap<Integer, List<Integer>> getAdjacentList() {
        return adjacentList;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public Graph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        adjacentList = new HashMap<>();
    }
    
}
