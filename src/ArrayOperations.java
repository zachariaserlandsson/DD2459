import java.lang.IllegalArgumentException;

public class ArrayOperations {
  public static void main(String[] args) {
    int[] a = new int[]{0, -1, 132, 1024, 402, 1, 1, 0};
    sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  /**
  * Method that sorts an integer-array of arbitrary length using the algorithm
  * Selection Sort.
  * @param A integer-array of arbitrary length 
  */
  public static void sort(int[] A) {
    if (A.length == 0) {
      throw new IllegalArgumentException("Array must not be empty");
    }
    int currMin;
    int currMinIdx;
    int pivotValueOld;
    for (int pivot = 0; pivot < A.length-1; pivot++){
      currMin = A[pivot];
      currMinIdx = pivot;
      pivotValueOld = A[pivot];
      for (int i = pivot; i < A.length; i++){
        if (A[i] < currMin) {
          currMin = A[i];
          currMinIdx = i;
        }
      }
      A[pivot] = currMin;
      A[currMinIdx] = pivotValueOld;
    }
    return;
  }
}
