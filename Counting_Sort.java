import java.util.Arrays;

class Main {
  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];     //largest element of the array
    }
    int[] count = new int[max + 1];

    
    for (int i = 0; i < max; ++i) {
      count[i] = 0;     // Initialize count array with all zeros.
    }

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Store the cummulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }

  // Driver code
  public static void main(String args[]) {
    int[] A = { 4, 2, 2, 8, 3, 3, 1 };
    int size = A.length;
    Main aj = new Main();
    aj.countSort(A, size);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(A));
  }
}