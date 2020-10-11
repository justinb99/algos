package justinb99.algos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SorterTest {

  private final Random random = new Random();

  @Test
  void mergeSort() {
    //    mergeSort(4);
    //    mergeSort(5);
    testSort(400, Sorter::mergeSort);
    testSort(401, Sorter::mergeSort);
  }

  @FunctionalInterface
  private interface SortMethod {
    void sort(int[] values);
  }

  private void testSort(int size, SortMethod sorter) {
    var values = initRandom(size);
    var copyOfValues = Arrays.copyOf(values, values.length);

    System.out.println(
        "unsorted values="
            + Arrays.toString(values)
            + ", copyOfValues="
            + Arrays.toString(copyOfValues));

    Arrays.sort(values);
    sorter.sort(copyOfValues);

    System.out.println(
        "sorted values="
            + Arrays.toString(values)
            + ", copyOfValues="
            + Arrays.toString(copyOfValues));
    assertArrayEquals(values, copyOfValues);
  }

  private int[] initRandom(int size) {
    var values = new int[size];
    for (var i = 0; i < size; i++) {
      values[i] = random.nextInt(1000);
    }
    return values;
  }

  @Test
  void quickSort() {
    testSort(10, Sorter::quickSort);
//    testSort(501, Sorter::quickSort);

//    var sortedValues = new int[] { 1, 2, 3, 4, 5, 6 };
//    Sorter.quickSort(sortedValues);
  }
}
