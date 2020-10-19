package justinb99.algos;

import org.junit.jupiter.api.Test;

import static justinb99.algos.StringSearcher.buildKMPTable;
import static justinb99.algos.StringSearcher.indexOfKMP;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSearcherTest {

  @Test
  void buildKMPTable_1() {
    var pattern = "abcdabca";
    var expectedTable = new int[] {-1, 0, 0, 0, 0, 1, 2, 3, 1};
    assertArrayEquals(expectedTable, buildKMPTable(pattern));
  }

  @Test
  void buildKMPTable_2() {
    var pattern = "abababa";
    var expectedTable = new int[] {-1, 0, 0, 1, 2, 3, 4, 5};
    assertArrayEquals(expectedTable, buildKMPTable(pattern));
  }

  @Test
  void buildKMPTable_3() {
    var pattern = "aabcadaabe";
    var expectedTable = new int[] {-1, 0, 1, 0, 0, 1, 0, 1, 2, 3, 0};
    assertArrayEquals(expectedTable, buildKMPTable(pattern));
  }

  @Test
  void buildKMPTable_4() {
    var pattern = "aaaabaabd";
    var expectedTable = new int[] {-1, 0, 1, 2, 3, 0, 1, 2, 0, 0};
    assertArrayEquals(expectedTable, buildKMPTable(pattern));
  }

  @Test
  void buildKMPTable_5() {
    var pattern = "abcxxxabcy";
    var expectedTable = new int[] {-1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 0};
    assertArrayEquals(expectedTable, buildKMPTable(pattern));
  }

  @Test
  void findAWord_1() {
    var string = "xyz abcxxxab abcxxxabcy zyx";
    var pattern = "abcxxxabcy";
    assertEquals(string.indexOf(pattern), indexOfKMP(string, pattern));
  }

  @Test
  void findAWord_2() {
    var string = "aaaaaaaaab";
    var pattern = "aaab";
    assertEquals(string.indexOf(pattern), indexOfKMP(string, pattern));
  }

  @Test
  void findAWord_3() {
    var string = "abdabdabdabc";
    var pattern = "abc";
    assertEquals(string.indexOf(pattern), indexOfKMP(string, pattern));
  }

  @Test
  void findAWord_not_in() {
    var string = "abdabdabdabd";
    var pattern = "abc";
    assertEquals(string.indexOf(pattern), indexOfKMP(string, pattern));
  }

  @Test
  void findAWord_4() {
    var string = "abcxxxabcxxxabcyzyx";
    var pattern = "abcxxxabcy";
    assertEquals(string.indexOf(pattern), indexOfKMP(string, pattern));
  }
}
