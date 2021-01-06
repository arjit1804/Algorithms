class Main 
{ 
    
    // PARTITION FUNCTION STARTS
    
    int partition(int A[], int low, int high) 
    { 
        int p = A[high];
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (A[j] <= p) 
            { 
                i++; 
                int t = A[i]; 
                A[i] = A[j]; 
                A[j] = t; 
            } 
        } 
        int t = A[i+1]; 
        A[i+1] = A[high]; 
        A[high] = t; 
        return i+1; 
    } 
    
    // PARTITION FUNCTION ENDS
    
    void sort(int A[], int low, int high) 
    { 
        if (low < high) 
        {
            int pi = partition(A, low, high); 
            sort(A, low, pi-1); 
            sort(A, pi+1, high); 
        } 
    } 
    static void printArray(int A[]) 
    { 
        int n = A.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(A[i]+" "); 
        System.out.println(); 
    } 
    public static void main(String args[]) 
    { 
        int A[] = {9,1,4,0,6,3,5,2,7,8}; 
        int n = A.length; 
        Main aj = new Main(); 
        aj.sort(A, 0, n-1); 
        System.out.println("Sorted array :"); 
        printArray(A); 
    } 
} 
