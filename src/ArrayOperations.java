import java.lang.IllegalArgumentException;

public class ArrayOperations {
  public static void main(String[] args) {
    int[] a = new int[]{0, -1, 132, 1024, 402, 1, 1, 0};
    sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
    System.out.println(search(a, 1024));
    System.out.println(search(a, 2024));
    System.out.println(membership(a, 1024));
    System.out.println(membership(a, 2024));
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

  /**
  * Method that searchs a sorted integer-array of arbitrary size for a value key
  * using the binary search algorithm.
  * @param A integer array of arbitrary length. Needs to be sorted.
  * @param key integer value to be searched for in the sorted array A
  * @return returns the index of the value key if it exists in the array, otherwise
  * it returns -1.
  */
  public static int search(int[] A, int key) {
    if (A.length == 0) {
      throw new IllegalArgumentException("Array must not be empty");
    }
    int x;
    int l = 1;
    int r = A.length - 1;

    do {
      x = (l+r) / 2;
      if (key < A[x]) {
        r = x - 1;
      } else {
        l = x + 1;
      }
    } while (key != A[x] && l <= r);

    if (key == A[x]) {
      return x;
    } else {
      return -1;
    }
  }

  /**
  Method that evaluates however an integer value key is present in an integer array A.
  Makes use of the search()-method.
  * @param A integer array of arbitrary length. Needs to be sorted.
  * @param key integer value to be evaluated for membership in the sorted array A.
  * @return returns true if the value key is present in the array, and false if it isn't.
  */
  public static boolean membership(int[] A, int key) {
    int index = search(A, key);
    if (index > 0) {
      return true;
    } else {
      return false;
    }
  }
}
