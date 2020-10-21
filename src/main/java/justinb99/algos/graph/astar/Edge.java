package justinb99.algos.graph.astar;

public class Edge {
  public final Node from;
  public final Node to;
  public final int weight;

  public Edge(Node from, Node to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}
