package justinb99.algos.graph.astar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AStar {

  private static class Path {
    List<Node> nodes;
    int gWeight;
    int hWeight;
    Integer totalWeight;

    @Override
    public String toString() {
      return "nodes="
          + nodes
          + ", gWeight="
          + gWeight
          + ", hWeight="
          + hWeight
          + ", totalWeight="
          + totalWeight;
    }

    public boolean isComplete(Node goal) {
      if (nodes.isEmpty()) return false;
      return nodes.get(nodes.size() - 1).equals(goal);
    }
  }
  ;

  public static List<Node> findMinPath(Node start, Node goal) {

    var startPath = new Path();
    startPath.nodes = List.of(start);
    startPath.gWeight = 0;
    startPath.hWeight = 0;
    startPath.totalWeight = 0;

    return findMinPathRec(startPath, List.of(), goal).nodes;

//    var holdPaths = new ArrayList<Path>();
//    var nextPathsSorted = nextPathsSorted(startPath);
//    var bestPotentialPath = nextPathsSorted.remove(0);
//    holdPaths.addAll(nextPathsSorted);
//
//    System.out.println("bestPotentialPath=" + bestPotentialPath);
//    System.out.println("holdPaths=" + holdPaths);
//
//    return bestPotentialPath.nodes;

    //    var potentialPaths =
    //        start.edges.stream()
    //            .map(
    //                e -> {
    //                  var path = new Path();
    //                  path.nodes = List.of(start, e.to);
    //                  path.gWeight = e.weight;
    //                  path.hWeight = e.to.hWeight;
    //                  path.totalWeight = path.gWeight + path.hWeight;
    //                  return path;
    //                })
    //            .sorted(Comparator.comparing(p -> p.totalWeight))
    //            .collect(Collectors.toList());
    //
    //    var bestPotentialPath = potentialPaths.remove(0);
    //    System.out.println("bestPotentialPath=" + bestPotentialPath.toString());
    //
    //    var lastNodeOfBestPotentialPath =
    //        bestPotentialPath.nodes.get(bestPotentialPath.nodes.size() - 1);
    //
    //    var morePotentialPaths =
    //        lastNodeOfBestPotentialPath.edges.stream()
    //            .map(
    //                e -> {
    //                  var path = new Path();
    //                  path.nodes = new ArrayList<>();
    //                  path.nodes.addAll(bestPotentialPath.nodes);
    //                  path.nodes.add(e.to);
    //                  path.gWeight = bestPotentialPath.gWeight + e.weight;
    //                  path.hWeight = e.to.hWeight;
    //                  path.totalWeight = path.gWeight + path.hWeight;
    //                  return path;
    //                })
    //            .sorted(Comparator.comparing(p -> p.totalWeight))
    //            .collect(Collectors.toList());
    //
    //    var bestPotentialPath2 = morePotentialPaths.remove(0);
    //    System.out.println("bestPotentialPath2=" + bestPotentialPath2.toString());
    //
    //    return bestPotentialPath2.nodes;
  }

  private static List<Path> nextPathsSorted(Path existingPath) {
    var lastNodeOfPath = existingPath.nodes.get(existingPath.nodes.size() - 1);
    return lastNodeOfPath.edges.stream()
        .map(
            e -> {
              var path = new Path();
              path.nodes = new ArrayList<>();
              path.nodes.addAll(existingPath.nodes);
              path.nodes.add(e.to);
              path.gWeight = existingPath.gWeight + e.weight;
              path.hWeight = e.to.hWeight;
              path.totalWeight = path.gWeight + path.hWeight;
              return path;
            })
        .sorted(Comparator.comparing(p -> p.totalWeight))
        .collect(Collectors.toList());
  }

  private static Path findMinPathRec(Path existingPath, List<Path> holdPaths, Node goalNode) {
    var nextPathsSorted = nextPathsSorted(existingPath);
    var bestPotentialPath = nextPathsSorted.remove(0);
    if (bestPotentialPath.isComplete(goalNode)) {
      holdPaths.sort(Comparator.comparing(p -> p.totalWeight));
      var bestHoldPath = holdPaths.remove(0);
      if (bestHoldPath.totalWeight < bestPotentialPath.totalWeight) {
          List<Path> newHoldPaths = new ArrayList<>(holdPaths);
          newHoldPaths.add(bestPotentialPath);
          newHoldPaths.addAll(nextPathsSorted);
        return findMinPathRec(bestHoldPath, newHoldPaths, goalNode);
      } else {
        return bestPotentialPath;
      }
    } else {
      List<Path> newHoldPaths = new ArrayList<>(holdPaths);
      newHoldPaths.addAll(nextPathsSorted);
      return findMinPathRec(bestPotentialPath, newHoldPaths, goalNode);
    }
  }
}
