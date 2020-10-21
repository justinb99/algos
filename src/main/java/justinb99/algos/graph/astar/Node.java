package justinb99.algos.graph.astar;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final String name;
    public final int hWeight;
    public final List<Edge> edges = new ArrayList<>();

    public Node(String name, int hWeight) {
        this.name = name;
        this.hWeight = hWeight;
    }

    @Override
    public String toString() {
        return name;
    }
}
