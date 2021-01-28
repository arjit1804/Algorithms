package com.programs;

import java.util.*;

public class Main
{
    static String s1 = "AGGTAB" , s2 = "GXTXAYB";   //LCS

    static int[] insertionsortarray = {9 , 1 , 4 , 0 , 6 , 3 , 5 , 2 , 7 , 8};  // insertionSort

    static int[] mergesortarray = {7 , 6 , 8 , 5 , 1 , 3 , 0 , 2 , 9 , 4};  //mergeSort

    static int[] countingsortarray = {3 , 1 , 4 , 2 , 6 , 9 , 5 , 0 , 7 , 8};  //countingSort

    static int[] quicksortarrray = {9 , 8 , 5 , 0 , 2 , 3 , 4 , 6 , 7 , 1};  //quickSort

    static String txt = "AABAACAADAABAAABAA" , pat = "AABA";    // naiveSearch

    static String txt1 = "ABABDABACDABABCABAB" , pat1 = "ABABCABAB"; //KMP

    public final static int d = 256;                                //Rabin Karp
    static  String txt2 = "ABCDECDCDEECD" , pat2 = "DE";

    static int[][] graph = { {0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8,0, 0,9}, {0,5,7,9,0}};    // MST

    private static final int V = 5; // MST

    static int[] A = { 9 ,1 , 4 ,0 ,6 ,3 ,5 ,2 ,7 ,8 }; //HeapSort

    static int[] searchArray = {10,20,30,40,50,60,70,80,90};

    static int keylinear , keybinary ,user;   //Linear & Binary

    static Scanner sc = new Scanner(System.in);



    /******************************************************************************

                                       LCS

     *******************************************************************************/


    public static void lcs(char[] X, char[] Y, int m, int n) {

        int[][] A = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    A[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    A[i][j] = A[i - 1][j - 1] + 1;
                else
                    A[i][j] = Math.max(A[i - 1][j] , A[i][j - 1]);
            }
        }
        for(int i=0; i<=m;i++)
        {
            for(int j=0;j<=n;j++)
                System.out.print(A[i][j] + " ");
            System.out.println();
        }
        System.out.println("Length of LCS is " + A[m][n]);
    }


    /******************************************************************************

                                  INSERTION SORT

     *******************************************************************************/

    public static void insertionSort(int[] A)
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
    }


    /******************************************************************************

                                     MERGE SORT

     *******************************************************************************/


    public  static void merge(int[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        if (n1 >= 0) System.arraycopy(A, p, L, 0, n1);
        for (int j = 0; j < n2; j++)
            M[j] = A[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = M[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] A, int left, int right) {
        if (left < right)
        {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    /******************************************************************************

                                     COUNTING SORT

     *******************************************************************************/


    public static void countSort(int[] A, int size) {
        int[] output = new int[size + 1];


        int max = A[0];
        for (int i = 1; i < size; i++) {
            if (A[i] > max)
                max = A[i];     //largest element of the A
        }
        int[] count = new int[max + 1];


        for (int i = 0; i < max; ++i) {
            count[i] = 0;     // Initialize count A with all zeros.
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[A[i]]++;
        }

        // Store the cummulative count of each A
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original A in count A, and
        // place the elements in output A
        for (int i = size - 1; i >= 0; i--) {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        // Copy the sorted elements into original A
        if (size >= 0) System.arraycopy(output, 0, A, 0, size);
    }

    /******************************************************************************

                                        QUICK SORT

     *******************************************************************************/


    public static int partition(int[] A, int low, int high)
    {
        int p = A[high];    //Picking last element as pivot
        int i = (low-1);
        for (int j = low ; j < high ; j++)
        {
            if (A[j] <= p)
            {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1]; //swap i+1 with pivot
        A[i+1] = A[high];
        A[high] = t;
        return i+1;
    }
    public static void quickSort(int[] A, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(A, low, high);
            quickSort(A, low, pi-1);
            quickSort(A, pi+1, high);
        }
    }

    /******************************************************************************

                                 NAIVE SEARCH

     *******************************************************************************/


    public static void naive(String txt, String pat)
    {
        int p = pat.length();
        int t = txt.length();
        int i,j;
        for (i = 0; i <= t - p; i++) {

            for (j = 0; j < p; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;

            if (j == p)
                System.out.println("Pattern found at index " + i);
        }
    }



    /******************************************************************************

                                LINEAR SEARCH

     *******************************************************************************/

    public static void linearSearch(int[] A, int key)
    {
        int c=0;
        for(int i=0 ; i<A.length ; i++){
            if(A[i] == key){
                System.out.println("Element Found at Index -> " + (i + 1));
                c=1;
            }
        }
        if(c==0) System.out.println("Element not Found !");
    }




    /******************************************************************************

                                BINARY SEARCH

     *******************************************************************************/

    public static void binarySearch(int[] arr, int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                System.out.println("Element is found at index: " + (mid + 1));
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
    }

    /******************************************************************************

                                     KMP

     *******************************************************************************/

    public static void kmpSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int[] lps = new int[M];
        int j = 0;
        computeLPSArray(pat, M, lps);

        int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public static void computeLPSArray(String pat, int M, int[] lps)
    {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }


    /******************************************************************************

                                    Rabin Karp

     *******************************************************************************/

    static void search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j, p = 0, t = 0, h = 1;

        for (i = 0; i < M-1; i++) //pow(d, M-1)%q
            h = (h*d)% 101;

        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))% 101;
            t = (d*t + txt.charAt(i))% 101;
        }

        for (i = 0; i <= N - M; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))% 101;
                if (t < 0)
                    t = (t + 101);
            }
        }
    }

    /******************************************************************************

                                    Heap Sort

     *******************************************************************************/


    public static void sort(int[] A) {
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

    static void heapify(int[] A, int n, int i) {
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

    /******************************************************************************

                                        MST

     *******************************************************************************/

    static int minKey (int[] key, Boolean[] mstSet)
    {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }
    static void printMST (int[] parent, int[][] graph)
    {
        System.out.println ("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println (parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
    static void primMST (int[][] graph)
    {
        int[] parent = new int[V];
        int[] key = new int[V];
        Boolean[] mstSet = new Boolean[V];
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++)
        {
            int u = minKey (key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v])
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        printMST (parent, graph);
    }


    /******************************************************************************

                                    DISPLAY2

     *******************************************************************************/

    public static void exstart()
    {
        System.out.println("\n/******************************************************************************");
        System.out.println("\t\t Execution Starts ");
        System.out.println("/******************************************************************************\n");
    }
    public static void exend()
    {
        System.out.println("\n/******************************************************************************");
        System.out.println("\t\t Execution Ends ");
        System.out.println("/******************************************************************************\n");
    }


    /******************************************************************************

                                        DISPLAY

     *******************************************************************************/

    public static void display()
    {
        System.out.println("1. LCS ");
        System.out.println("2. Insertion Sort ");
        System.out.println("3. Merge Sort ");
        System.out.println("4. Counting Sort ");
        System.out.println("5. Quick Sort ");
        System.out.println("6. Naive Search ");
        System.out.println("7. Linear Search ");
        System.out.println("8. Binary Search ");
        System.out.println("9. KMP ");
        System.out.println("10. Rabin Karp ");
        System.out.println("11. MST ");
        System.out.println("12. Heap Sort ");
        System.out.println("13. Insertion in BST ");
        System.out.println("14. Merge Function ");
        System.out.println("15. Partition Function ");
        System.out.println("0. End the Program Execution");

        System.out.print("Enter a Number to Execute its Corresponding Algorithm -> ");
        user = sc.nextInt();
    }

    /******************************************************************************

     MAIN

     *******************************************************************************/


    public static void main(String[] args) {

        System.out.println("\n\nEnter 1 for JAVA , 2 for PYTHON , 3 for C : ");
        int jpc = sc.nextInt();
        if(jpc==1){
        display();

        while(user!=0)
        {

            switch (user) {
                case 1 -> {
                    exstart();
                    System.out.println("\n\tLCS Algorithm is executed. \n");
                    char[] X = s1.toCharArray();
                    char[] Y = s2.toCharArray();
                    int m = X.length;
                    int n = Y.length;
                    lcs(X, Y, m, n);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 2 -> {
                    exstart();
                    System.out.println("\n\tInsertion Sort is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(insertionsortarray));
                    insertionSort(insertionsortarray);
                    System.out.print("Array after Insertion Sort ->  ");
                    System.out.print(Arrays.toString(insertionsortarray));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 3 -> {
                    exstart();
                    System.out.println("\n\tMerge Sort is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(mergesortarray));
                    mergeSort(mergesortarray, 0, mergesortarray.length - 1);
                    System.out.print("Array after Merge Sort ->  ");
                    System.out.print(Arrays.toString(mergesortarray));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 4 -> {
                    exstart();
                    System.out.println("\n\tCounting Sort is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(countingsortarray));
                    countSort(countingsortarray, countingsortarray.length);
                    System.out.print("Array after Counting Sort ->  ");
                    System.out.print(Arrays.toString(countingsortarray));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 5 -> {
                    exstart();
                    System.out.println("\n\tQuick Sort is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(quicksortarrray));
                    quickSort(quicksortarrray, 0, quicksortarrray.length - 1);
                    System.out.print("Array after Quick Sort ->  ");
                    System.out.print(Arrays.toString(quicksortarrray));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 6 -> {
                    exstart();
                    System.out.println("\n\tNaive Search is executed. \n");
                    System.out.println("\n\ttxt = 'AABAACAADAABAAABAA'\n\tpat = 'AABA'");
                    naive(txt, pat);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 7 -> {
                    exstart();
                    System.out.println("\n\tLinear Search is executing. \n");
                    System.out.println("\tArray -> " + Arrays.toString(searchArray));
                    System.out.print("\tEnter Key to be Searched -> ");
                    keylinear = sc.nextInt();
                    linearSearch(searchArray, keylinear);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 8 -> {
                    exstart();
                    System.out.println("\n\tBinary Search is executing. \n");
                    System.out.println("\tArray -> " + Arrays.toString(searchArray));
                    System.out.print("\tEnter Key to be Searched -> ");
                    keybinary = sc.nextInt();
                    binarySearch(searchArray, 0, searchArray.length - 1, keybinary);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 9 -> {
                    exstart();
                    System.out.println("\n\tKMP is executed. \n");
                    System.out.println("\n\ttxt = 'ABABDABACDABABCABAB'\n\tpat = 'ABABCABAB'");
                    kmpSearch(pat1 , txt1);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 10 -> {
                    exstart();
                    System.out.println("\n\tRabin karp is executed. \n");
                    System.out.println("\n\ttxt = 'ABCDECDCDEECD'\n\tpat = 'DE'");
                    search(pat2 , txt2);
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 11 -> {
                    exstart();
                    System.out.println("\n\tMST is executed. \n");
                    System.out.println("Original Array : \n");
                    for (int[] row : graph)
                        System.out.println(Arrays.toString(row));
                    System.out.println("\n");
                    primMST (graph);
                    System.out.print("\n\n");
                    exend();
                    display();
                }

                case 12 -> {
                    exstart();
                    System.out.println("\n\tHeap Sort is executed. \n");
                    System.out.println("Original Array : " + Arrays.toString(A) + "\n");
                    sort(A);
                    System.out.println("Sorted Array is");
                    for (int j : A) System.out.print(j + " ");
                    System.out.print("\n\n");
                    exend();
                    display();
                }

                case 13 -> {
                    System.out.println("https://onlinegdb.com/BznH8YfBJ");
                    System.exit(0);
                }
                case 14 -> {
                    exstart();
                    System.out.println("\n\tMerge Function is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(mergesortarray));
                    merge(mergesortarray,0,mergesortarray.length/2,mergesortarray.length);
                    System.out.print("Array after Merge Function ->  ");
                    System.out.print(Arrays.toString(mergesortarray));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                case 15 -> {
                    exstart();
                    System.out.println("\n\tPartition Function is executed. \n");
                    System.out.println("Original Array ->" + Arrays.toString(quicksortarrray));
                    System.out.print("Partition Element ->  ");
                    System.out.print(partition(quicksortarrray,0,quicksortarrray.length));
                    System.out.print("\n\n");
                    exend();
                    display();
                }
                default -> {
                    System.out.println("Wrong Choice Entered!");
                    System.exit(0);
                }
            }

        } }
        else if(jpc == 2)
            System.out.println("https://onlinegdb.com/S1MHMvAy_");
        else if(jpc == 3)
            System.out.println("https://onlinegdb.com/uVrmQXbyz");
        else
            System.out.println("Wrong Choice Entered!");
    }
}
