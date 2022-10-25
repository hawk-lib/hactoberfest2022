package GraphAlgos;

import java.util.*;

public class WeightedNode implements Comparable<WeightedNode> {
    String name;
    int index;
    WeightedNode parent;
    boolean isVisited = false;
    int distance = Integer.MAX_VALUE;
    ArrayList<WeightedNode> neighbors = new ArrayList<>();
    HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    String psf = "";

    public WeightedNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public int compareTo(WeightedNode other) {
        return this.distance - other.distance;
    }

    public String toString() {
        return name;
    }
}
