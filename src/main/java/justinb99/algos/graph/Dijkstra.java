package justinb99.algos.graph;

import java.util.*;

public class Dijkstra {
  public static Map<Node, Integer> dijkstraDistances(List<Node> graph, Node from) {
    var distances = initializeDistances(graph, from);

    var visited = new HashSet<Node>();

    for (var e : from.edges) {
      distances.put(e.to, e.weight);
    }

    var optMinNode = findMinUnvisited(distances, visited);
    while (optMinNode.isPresent()) {
      var minNode = optMinNode.get();
      var fromToMin = distances.get(minNode);
      for (var e : minNode.edges) {
        var possibleDistance = fromToMin + e.weight;
        if (possibleDistance < distances.get(e.to)) {
          distances.put(e.to, possibleDistance);
        }
      }
      visited.add(minNode);
//      System.out.println("Visited " + minNode);
      optMinNode = findMinUnvisited(distances, visited);
    }

    return distances;
  }

  private static void dijkstraRecurse() {}

  private static Map<Node, Integer> initializeDistances(List<Node> graph, Node from) {
    var distances = new HashMap<Node, Integer>();
    for (var node : graph) {
      if (node != from) {
        distances.put(node, Integer.MAX_VALUE);
      }
    }
    return distances;
  }

  private static Optional<Node> findMinUnvisited(Map<Node, Integer> distances, Set<Node> visited) {
    return distances.entrySet().stream()
        .filter(entry -> !visited.contains(entry.getKey()))
        .min(Map.Entry.comparingByValue())
        .filter(entry -> entry.getValue() != Integer.MAX_VALUE)
        .map(Map.Entry::getKey);
  }
}
