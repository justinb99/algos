package justinb99.algos;

public class StringSearcher {

  public static int indexOfKMP(String source, String target) {
    var iTarget = 0;
    var iSource = 0;
    var kmpTable = buildKMPTable(target);
    while (iSource < source.length()) {
      System.out.println("source=" + source + ", target=" + target + ", iSource=" + iSource + ", iTarget=" + iTarget);
      if (target.charAt(iTarget) == source.charAt(iSource)) {
        iTarget++;
        iSource++;
        if (iTarget == target.length()) {
          return iSource - iTarget;
        }
      } else {
        iTarget = kmpTable[iTarget];
        if (iTarget < 0) {
          iSource++;
          iTarget++;
        }
      }
    }
    return -1;
  }

  static int[] buildKMPTable(String target) {
    var table = new int[target.length() + 1];
    table[0] = -1;
    table[1] = 0;
    var iTargetPrefix = 0;
    for (var iTarget = 1; iTarget < target.length(); iTarget++) {
      if (target.charAt(iTarget) == target.charAt(iTargetPrefix)) {
        table[iTarget + 1] = iTargetPrefix + 1;
        iTargetPrefix++;
      } else {
        iTargetPrefix = 0;
        if (target.charAt(iTarget) == target.charAt(iTargetPrefix))
          table[iTarget + 1] = iTargetPrefix + 1;
        else
          table[iTarget + 1] = 0;
      }
    }
    return table;
  }
}
