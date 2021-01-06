import java.util.*;
class Main { 
    void sort(int A[]) 
    { 
        int n = A.length; 
        for (int i = 1; i < n; ++i) 
        { 
            int key = A[i]; 
            int j = i - 1; 
  
            while (j >= 0 && A[j] > key) 
            { 
                A[j + 1] = A[j]; 
                j = j - 1; 
            } 
            A[j + 1] = key; 
        } 
        System.out.print("Sorted Array after Insertion Sort ->  ");
            System.out.print(Arrays.toString(A)); 
    } 
  
    public static void main(String args[]) 
    { 
        int A[] = { 12, 11, 13, 5, 6 }; 
  
        Main ob = new Main(); 
        ob.sort(A); 
  
    } 
} 