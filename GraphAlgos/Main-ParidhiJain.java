package GraphAlgos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        // nodeList.add(new WeightedNode("E", 4));
        // nodeList.add(new WeightedNode("F", 5));
        // nodeList.add(new WeightedNode("G", 6));
        WeightedGraph newGraph = new WeightedGraph(nodeList);
        // newGraph.addWeightedDirectedEdge(0, 1, 2);
        // newGraph.addWeightedDirectedEdge(0, 2, 5);
        // newGraph.addWeightedDirectedEdge(1, 2, 6);
        // newGraph.addWeightedDirectedEdge(1, 3, 1);
        // newGraph.addWeightedDirectedEdge(1, 4, 3);
        // newGraph.addWeightedDirectedEdge(2, 5, 8);
        // newGraph.addWeightedDirectedEdge(3, 4, 4);
        // newGraph.addWeightedDirectedEdge(4, 6, 9);
        // newGraph.addWeightedDirectedEdge(5, 6, 7);
        // System.out.println("Printing Dijkstra from source: A");
        // newGraph.dijkstra(nodeList.get(0));

        // newGraph.addWeightedDirectedEdge(0, 2, 6);
        // newGraph.addWeightedDirectedEdge(0, 3, -6);
        // newGraph.addWeightedDirectedEdge(1, 0, 3);
        // newGraph.addWeightedDirectedEdge(2, 3, 1);
        // newGraph.addWeightedDirectedEdge(3, 2, 2);
        // newGraph.addWeightedDirectedEdge(3, 1, 1);
        // newGraph.addWeightedDirectedEdge(4, 1, 4);
        // newGraph.addWeightedDirectedEdge(4, 3, 2);

        // newGraph.bellmanFord(nodeList.get(0));
        newGraph.addWeightedDirectedEdge(0, 3, 1);
        newGraph.addWeightedDirectedEdge(0, 1, 8);
        newGraph.addWeightedDirectedEdge(1, 2, 1);
        newGraph.addWeightedDirectedEdge(2, 0, 4);
        newGraph.addWeightedDirectedEdge(3, 1, 2);
        newGraph.addWeightedDirectedEdge(3, 2, 9);
        System.out.println("Printing Floyd Warshall Algorithm from source: A");
        newGraph.floydWarshall();
    }
}
