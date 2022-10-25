package GraphAlgos;

import java.util.*;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedDirectedEdge(int i, int j, int weight) {
        WeightedNode parent = nodeList.get(i);
        WeightedNode child = nodeList.get(j);
        parent.neighbors.add(child);
        parent.weightMap.put(child, weight);
    }

    public void dijkstra(WeightedNode source) {
        PriorityQueue<WeightedNode> pq = new PriorityQueue<>();
        source.distance = 0;
        source.psf = "" + source.name;
        pq.add(source);
        pq.addAll(nodeList);
        while (!pq.isEmpty()) {
            WeightedNode currentNode = pq.remove();
            if (!currentNode.isVisited) {
                currentNode.isVisited = true;
                System.out.println("Route of " + currentNode.name + " from " + source.name + " has path "
                        + currentNode.psf + " at distance " + currentNode.distance);
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if (!neighbor.isVisited) {
                        if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                            neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                            neighbor.parent = currentNode;
                            neighbor.psf = currentNode.psf + neighbor.name;
                            pq.add(neighbor);
                        }
                    }
                }
            }

        }
        for (WeightedNode node : nodeList) {
            System.out.print("The path for " + node.name + ": ");
            pathPrint(node);
            System.out.print("and the length of the path is: " + node.distance);
            System.out.println();
        }
    }

    public void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    // BellMan Ford Algorithm
    void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 1; i < nodeList.size(); i++) {
            for (WeightedNode node : nodeList) {
                for (WeightedNode neighbor : node.neighbors) {
                    if (node.distance != Integer.MAX_VALUE
                            && neighbor.distance > node.distance + node.weightMap.get(neighbor)) {
                        neighbor.distance = node.distance + node.weightMap.get(neighbor);
                        neighbor.parent = node;
                    }
                }
            }
        }

        System.out.println("Checking negative cycle!");
        for (WeightedNode node : nodeList) {
            for (WeightedNode neighbor : node.neighbors) {
                if (node.distance != Integer.MAX_VALUE
                        && neighbor.distance > node.distance + node.weightMap.get(neighbor)) {
                    System.out.println("The Graph has a negative cycle!");
                    System.out.println("Vertex name: " + neighbor.name);
                    System.out.println("Old cost: " + neighbor.distance);
                    int newDistance = node.distance + node.weightMap.get(neighbor);
                    System.out.println("new cost: " + newDistance);
                    return;
                }
            }
        }

        System.out.println("No negative cycle present");
        for (WeightedNode node : nodeList) {
            System.out.print("The path for " + node.name + ": ");
            pathPrint(node);
            System.out.print("and the length of the path is: " + node.distance);
            System.out.println();
        }
    }

    // All Pair Shortest Path Problem : Floyd Warshall Algorithm - Uses a via node
    void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];
        for (int i = 0; i < nodeList.size(); i++) {
            WeightedNode node = nodeList.get(i);
            for (int j = 0; j < nodeList.size(); j++) {
                if (node.weightMap.containsKey(nodeList.get(j))) {
                    V[i][j] = node.weightMap.get(nodeList.get(j));
                } else if (i == j) {
                    V[i][j] = 0;
                } else {
                    V[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }
        for (int i = 0; i < nodeList.size(); i++) {
            // WeightedNode via=nodeList.get(i);
            for (int j = 0; j < nodeList.size(); j++) {
                for (int k = 0; k < nodeList.size(); k++) {
                    if (V[j][i] + V[i][k] < V[j][k]) {
                        V[j][k] = V[j][i] + V[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println("Printing distance list for node " + nodeList.get(i) + " : ");
            for (int j = 0; j < nodeList.size(); j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }

    }
}
