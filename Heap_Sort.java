public class Main {
  
    public static void sort(int A[]) {
      int n = A.length;
  
      // max heap
      for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(A, n, i);
      }
  
      // Heap sort
      for (int i = n - 1; i >= 0; i--) {
        int temp = A[0];
        A[0] = A[i];
        A[i] = temp;
  
        // Heapify root element
        heapify(A, i, 0);
      }
    }
  
    static void heapify(int A[], int n, int i) {
      // Find largest among root, left child and right child
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
  
      if (l < n && A[l] > A[largest])
        largest = l;
  
      if (r < n && A[r] > A[largest])
        largest = r;
  
      // Swap and continue heapifying if root is not largest
      if (largest != i) {
        int swap = A[i];
        A[i] = A[largest];
        A[largest] = swap;
        heapify(A, n, largest);
      }
    }
  
    public static void main(String args[]) {
      
      int A[] = { 9 ,1 , 4 ,0 ,6 ,3 ,5 ,2 ,7 ,8 };
      
      sort(A);
  
      System.out.println("Sorted Array is");
      for (int i = 0; i < A.length; ++i)
        System.out.print(A[i] + " ");
    }
  }