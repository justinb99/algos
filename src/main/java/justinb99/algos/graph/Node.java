package justinb99.algos.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
  public final List<Edge> edges = new ArrayList<>();
  public final String name;

  public Node(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
