package justinb99.algos.graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

  private static final Node one = new Node("one");
  private static final Node two = new Node("two");
  private static final Node three = new Node("three");
  private static final Node four = new Node("four");
  private static final Node five = new Node("five");
  private static final Node six = new Node("six");
  private static final List<Node> graph = List.of(one, two, three, four, five, six);

  @Test
  void dijkstraDistances() {
    one.edges.add(new Edge(one, two, 50));
    one.edges.add(new Edge(one, three, 45));
    one.edges.add(new Edge(one, four, 10));
    two.edges.add(new Edge(two, three, 10));
    two.edges.add(new Edge(two, four, 15));
    three.edges.add(new Edge(three, five, 30));
    four.edges.add(new Edge(four, five, 15));
    five.edges.add(new Edge(five, two, 20));
    five.edges.add(new Edge(five, three, 35));
    six.edges.add(new Edge(six, five, 3));

    var distances = Dijkstra.dijkstraDistances(graph, one);
    var expected =
        Map.of(
            two, 45,
            three, 45,
            four, 10,
            five, 25,
            six, Integer.MAX_VALUE);
    distances.forEach(
        (key, value) -> {
          System.out.println("distances: key=" + key + ", value=" + value);
        });
    assertEquals(expected, distances);
  }

  @Test
  void dijkstraDistances_2() {
    one.edges.add(new Edge(one, two, 2));
    one.edges.add(new Edge(one, three, 4));
    two.edges.add(new Edge(two, three, 1));
    two.edges.add(new Edge(two, four, 7));
    three.edges.add(new Edge(three, five, 3));
    four.edges.add(new Edge(four, six, 1));
    five.edges.add(new Edge(five, four, 2));
    five.edges.add(new Edge(five, six, 5));

    var expected =
        Map.of(
            two, 2,
            three, 3,
            four, 8,
            five, 6,
            six, 9);

    var distances = Dijkstra.dijkstraDistances(graph, one);
    assertEquals(expected, distances);
  }
}
