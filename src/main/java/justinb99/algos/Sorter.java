package justinb99.algos;

import java.util.Arrays;

public class Sorter {

  public static void mergeSort(int[] values) {
    var copyOfValues = Arrays.copyOf(values, values.length);
    splitAndMergeSort(copyOfValues, 0, values.length, values);
  }

  private static void splitAndMergeSort(int[] values2, int iBegin, int iEnd, int[] values1) {
    //    System.out.println("splitAndMergeSort values2=" + Arrays.toString(values2) + ", iBegin=" +
    // iBegin + ", iEnd=" + iEnd + ", values1=" + Arrays.toString(values1));
    //    System.out.println("splitAndMergeSort iBegin=" + iBegin + ", iEnd=" + iEnd);
    if (iEnd - iBegin <= 1) return;

    var iMiddle = (iBegin + iEnd) / 2;
    splitAndMergeSort(values1, iBegin, iMiddle, values2);
    splitAndMergeSort(values1, iMiddle, iEnd, values2);

    mergeSort(values2, iBegin, iMiddle, iEnd, values1);
  }

  private static void mergeSort(
      int[] inValues, int iBegin, int iMiddle, int iEnd, int[] mergedValues) {
    //    System.out.println("mergeSort iBegin=" + iBegin + ", iMiddle=" + iMiddle + ", iEnd=" +
    // iEnd);
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

  public static void quickSort(int[] values) {
    quickSort(values, 0, values.length - 1);
  }

  private static void quickSort(int[] values, int iStart, int iEnd) {
    if (iStart < iEnd) {
      var pivotIndex = quickSortPartition(values, iStart, iEnd);
      quickSort(values, iStart, pivotIndex - 1);
      quickSort(values, pivotIndex + 1, iEnd);
    }
  }

  private static int quickSortPartition(int[] values, int iStart, int iEnd) {
    System.out.println(
        "quickSortPartition: iStart="
            + iStart
            + ", iEnd="
            + iEnd
            + ", values="
            + Arrays.toString(values));

    var pivot = values[iEnd];
    var pivotIndex = iStart;
    System.out.println("quickSortPartition: pivot=" + pivot + ", pivotIndex=" + pivotIndex);

    for (var iter = iStart; iter <= iEnd; iter++) {
      System.out.println(
          "quickSortPartition: iter="
              + iter
              + ", values[iter]="
              + values[iter]
              + ", pivot="
              + pivot);
      if (values[iter] < pivot) {
        swap(values, iter, pivotIndex);
        pivotIndex += 1;
        System.out.println(
            "quickSortPartition: SWAP values="
                + Arrays.toString(values)
                + ", pivotIndex="
                + pivotIndex);
      }
    }
    swap(values, pivotIndex, iEnd);
    System.out.println(
        "quickSortPartition: DONE values="
            + Arrays.toString(values)
            + ", pivotIndex="
            + pivotIndex);
    System.out.println("-------------------");
    return pivotIndex;
  }

  private static void swap(int[] values, int index1, int index2) {
    if (index1 == index2) {
      System.out.println("SKIP SWAP");
    } else {
      var temp = values[index1];
      values[index1] = values[index2];
      values[index2] = temp;
    }
  }

  public static void heapSort(int[] values) {
    heapify(values);
    var iEnd = values.length - 1;
    while (iEnd > 0) {
      swap(values, iEnd, 0);
      System.out.print(values[iEnd] + ", ");
      iEnd -= 1;
      siftDown(values, 0, iEnd);
    }
    System.out.println();
  }

  public static void heapify(int[] values) {
    heapify(values, values.length);
  }

  private static void heapify(int[] values, int length) {
    var iStart = heapParentIndexOf(length - 1);
    while (iStart >= 0) {
      siftDown(values, iStart, length - 1);
      iStart -= 1;
    }
  }

  private static void siftDown(int[] values, int iStart, int iEnd) {
    var iRoot = iStart;
    while (heapLeftChildIndexOf(iRoot) <= iEnd) {
      var iChild = heapLeftChildIndexOf(iRoot);
      var iSwap = iRoot;

      if (values[iSwap] < values[iChild]) {
        iSwap = iChild;
      }

      if (iChild + 1 <= iEnd && values[iSwap] < values[iChild + 1]) {
        iSwap = iChild + 1;
      }

      if (iSwap == iRoot) {
        return;
      } else {
        swap(values, iRoot, iSwap);
        iRoot = iSwap;
      }
    }
  }

  private static int heapParentIndexOf(int index) {
    return (index - 1) / 2;
  }

  private static int heapLeftChildIndexOf(int index) {
    return 2 * index + 1;
  }

  private static int heapRightChildIndexOf(int index) {
    return 2 * index + 2;
  }
}
