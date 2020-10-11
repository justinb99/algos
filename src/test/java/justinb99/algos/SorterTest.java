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
    mergeSort(400);
    mergeSort(401);
  }

  private void mergeSort(int size) {
    var values = initRandom(size);
    var copyOfValues = Arrays.copyOf(values, values.length);

    System.out.println(
        "values=" + Arrays.toString(values) + ", copyOfValues=" + Arrays.toString(copyOfValues));

    Arrays.sort(values);
    Sorter.mergeSort(copyOfValues);

    String message =
        "Expected=" + Arrays.toString(values) + ", actual=" + Arrays.toString(copyOfValues);
    assertArrayEquals(values, copyOfValues, message);
  }

  private int[] initRandom(int size) {
    var values = new int[size];
    for (var i = 0; i < size; i++) {
      values[i] = random.nextInt(1000);
    }
    return values;
  }
}
