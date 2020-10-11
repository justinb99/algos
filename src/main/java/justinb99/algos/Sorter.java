package justinb99.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {

  public static void mergeSort(int[] values) {
    var copyOfValues = Arrays.copyOf(values, values.length);
    splitAndMergeSort(copyOfValues, 0, values.length, values);
  }

  private static void splitAndMergeSort(int[] values2, int iBegin, int iEnd, int[] values1) {
//    System.out.println("splitAndMergeSort values2=" + Arrays.toString(values2) + ", iBegin=" + iBegin + ", iEnd=" + iEnd + ", values1=" + Arrays.toString(values1));
//    System.out.println("splitAndMergeSort iBegin=" + iBegin + ", iEnd=" + iEnd);
    if (iEnd - iBegin <= 1)
      return;

    var iMiddle = (iBegin + iEnd) / 2;
    splitAndMergeSort(values1, iBegin, iMiddle, values2);
    splitAndMergeSort(values1, iMiddle, iEnd, values2);

    mergeSort(values2, iBegin, iMiddle, iEnd, values1);
  }

  private static void mergeSort(int[] inValues, int iBegin, int iMiddle, int iEnd, int[] mergedValues) {
//    System.out.println("mergeSort iBegin=" + iBegin + ", iMiddle=" + iMiddle + ", iEnd=" + iEnd);
    var iter1 = iBegin;
    var iter2 = iMiddle;

    for (var mergedIter = iBegin; mergedIter < iEnd; mergedIter++) {
      if (iter1 < iMiddle && (iter2 >= iEnd || inValues[iter1] <= inValues[iter2])) {
        mergedValues[mergedIter] = inValues[iter1];
        iter1 += 1;
      } else {
        mergedValues[mergedIter] = inValues[iter2];
        iter2 += 1;
      }
    }
  }
}
