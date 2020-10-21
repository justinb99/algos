package justinb99.algos.graph.astar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AStarTest {

  @Test
  void test1() {
    var start = new Node("S", 5);
    var a = new Node("A", 3);
    var b = new Node("B", 4);
    var c = new Node("C", 2);
    var d = new Node("D", 6);
    var g = new Node("G", 0);

    start.edges.add(new Edge(start, a, 1));
    start.edges.add(new Edge(start, g, 10));
    a.edges.add(new Edge(a, b, 2));
    a.edges.add(new Edge(a, c, 1));
    b.edges.add(new Edge(b, d, 5));
    c.edges.add(new Edge(c, d, 3));
    c.edges.add(new Edge(c, g, 4));
    d.edges.add(new Edge(d, g, 2));

    var minPath = AStar.findMinPath(start, g);
    assertEquals(List.of(start, a, c, g), minPath);
  }

  @Test
  void test2() {
    var s = new Node("S", 10);
    var a = new Node("A", 9);
    var b = new Node("B", 7);
    var c = new Node("C", 8);
    var d = new Node("D", 8);
    var f = new Node("F", 6);
    var g = new Node("G", 3);
    var h = new Node("H", 6);
    var l = new Node("L", 6);
    var i = new Node("I", 4);
    var j = new Node("J", 4);
    var k = new Node("K", 3);
    var e = new Node("E", 0);

    s.edges.add(new Edge(s, a, 7));
    s.edges.add(new Edge(s, b, 2));
    s.edges.add(new Edge(s, c, 8));
    a.edges.add(new Edge(a, b, 3));
    a.edges.add(new Edge(a, d, 4));
    d.edges.add(new Edge(d, b, 4));
    d.edges.add(new Edge(d, f, 5));
    b.edges.add(new Edge(b, h, 1));
    f.edges.add(new Edge(f, h, 3));
    h.edges.add(new Edge(h, g, 2));
    g.edges.add(new Edge(g, e, 2));
    c.edges.add(new Edge(c, l, 2));
    l.edges.add(new Edge(l, i, 4));
    l.edges.add(new Edge(l, j, 4));
    i.edges.add(new Edge(i, j, 6));
    i.edges.add(new Edge(i, k ,4));
    j.edges.add(new Edge(j, k, 4));
    k.edges.add(new Edge(k, e, 5));

    var minPath = AStar.findMinPath(s, e);
    assertFalse(minPath.isEmpty());
    System.out.println("minPath=" + minPath);
  }
}
