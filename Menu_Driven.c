#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define RANGE 255
#include <math.h>
#include <limits.h> 
#include <stdbool.h> 
	int main()
{		int z;
        void insertionSort(int arr[], int n)
					{ 
    						int i, key, j; 
   						for (i = 1; i < n; i++) { 
        					key = arr[i]; 
        					j = i - 1; 
  
        
        					while (j >= 0 && arr[j] > key) { 
            						arr[j + 1] = arr[j]; 
            						j = j - 1; 
        					} 
        					arr[j + 1] = key; 
    						} 
					} 
  
 
				void printArray(int arr[], int n) 
					{ 
    						int i; 
    						for (i = 0; i < n; i++) 
        						printf("%d ", arr[i]); 
    							printf("\n"); 
					} 
		int search(int arr[], int n, int x) 
			{ 
    				int i; 
    				for (i = 0; i < n; i++) 
        				if (arr[i] == x) 
            					return i; 
    				return -1; 
			} 
		
		int binarySearch(int arr[], int l, int r, int x) 
			{ 
    				if (r >= l) { 
        				int mid = l + (r - l) / 2; 
   
        				if (arr[mid] == x) 
            					return mid; 
  
         
        				if (arr[mid] > x) 
            					return binarySearch(arr, l, mid - 1, x); 
  
     
        				return binarySearch(arr, mid + 1, r, x); 
    						} 
   
    			return -1; 
			}
		
		void merge(int arr[], int l, int m, int r)
			{
    				int i, j, k;
    				int n1 = m - l + 1;
    				int n2 = r - m;
 
    
    				int L[n1], R[n2];
 
        			for (i = 0; i < n1; i++)
        				L[i] = arr[l + i];
    				for (j = 0; j < n2; j++)
        				R[j] = arr[m + 1 + j];
 
    
    				i = 0; 
    				j = 0; 
    				k = l; 
    				while (i < n1 && j < n2) {
        				if (L[i] <= R[j]) {
            					arr[k] = L[i];
            					i++;
        				}
        				else {
            					arr[k] = R[j];
            					j++;
        				}
        				k++;
    				}
 
    
    
    				while (i < n1) {
        				arr[k] = L[i];
        				i++;
        				k++;
    				}
 
    
        			while (j < n2) {
        				arr[k] = R[j];
        				j++;
        				k++;
    				}
			}
 

			void mergeSort(int arr[], int l, int r)
				{
    					if (l < r) {
                				int m = l + (r - l) / 2;
 
        
        					mergeSort(arr, l, m);
        					mergeSort(arr, m + 1, r);
 
        					merge(arr, l, m, r);
    					}
				}
 

			void printarray(int A[], int size)
				{
    					int i;
    					for (i = 0; i < size; i++)
        					printf("%d ", A[i]);
    						printf("\n");
				}
				
			void swap(int* a, int* b) 
				{ 
    					int t = *a; 
    					*a = *b; 
    					*b = t; 
				} 
  

			int partition (int arr[], int low, int high) 
				{ 
    					int pivot = arr[high];    
    					int i = (low - 1);   
  
    					for (int j = low; j <= high- 1; j++) 
    					{ 
         
        					if (arr[j] < pivot) 
        						{ 
            							i++;    
            							swap(&arr[i], &arr[j]); 
        						} 
    					} 
    					swap(&arr[i + 1], &arr[high]); 
    					return (i + 1); 
				} 
  
			void quickSort(int arr[], int low, int high) 
				{ 
    					if (low < high) 
    					{ 
                				int pi = partition(arr, low, high); 
  
         
        					quickSort(arr, low, pi - 1); 
        					quickSort(arr, pi + 1, high); 
    					} 
				} 
  

			void PrintArray(int arr[], int size) 
				{ 
    					int i; 
    					for (i=0; i < size; i++) 
        					printf("%d ", arr[i]); 
    						printf("\n"); 
				} 
				
			  
            void counting_sort(int A[], int k, int n)  
            {  
                int i, j;  
                int B[15], C[100];  
                for (i = 0; i <= k; i++)  
                    C[i] = 0;  
                for (j = 1; j <= n; j++)  
                    C[A[j]] = C[A[j]] + 1;  
                for (i = 1; i <= k; i++)  
                    C[i] = C[i] + C[i-1];  
                for (j = n; j >= 1; j--)  
                {  
                    B[C[A[j]]] = A[j];  
                    C[A[j]] = C[A[j]] - 1;  
                }  
                printf("The Sorted array is : ");  
                for (i = 1; i <= n; i++)  
                    printf("%d ", B[i]);  
            }  
            /*  End of counting_sort()  */  
               
            /*  The main() begins  */  
  
	       
			void Search(char* pat, char* txt) 
{ 
    int M = strlen(pat); 
    int N = strlen(txt); 
  
    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++) { 
        int j; 
  
        /* For current index i, check for pattern match */
        for (j = 0; j < M; j++) 
            if (txt[i + j] != pat[j]) 
                break; 
  
        if (j == M) // if pat[0...M-1] = txt[i, i+1, ...i+M-1] 
            printf("Pattern found at index %d \n", i); 
    } 
} 	
		
  	        void prefixSuffixArray(char* pat, int M, int* pps) {
   int length = 0;
   pps[0] = 0;
   int i = 1;
   while (i < M) {
      if (pat[i] == pat[length]) {
         length++;
         pps[i] = length;
         i++;
      } else {
         if (length != 0)
         length = pps[length - 1];
         else {
            pps[i] = 0;
            i++;
         }
      }
   }
}
                void KMPAlgorithm(char* text, char* pattern) {
   int M = strlen(pattern);
   int N = strlen(text);
   int pps[M];
   prefixSuffixArray(pattern, M, pps);
   int i = 0;
   int j = 0;
   while (i < N) {
      if (pattern[j] == text[i]) {
         j++;
         i++;
      }
      if (j == M) {
         printf("Found pattern at index %d\n", i - j);
         j = pps[j - 1];
      }
      else if (i < N && pattern[j] != text[i]) {
         if (j != 0)
         j = pps[j - 1];
         else
         i = i + 1;
      }
   }
}
  	        #define d 10

            void rabinKarp(char pattern[], char text[], int q) {
  int m = strlen(pattern);
  int n = strlen(text);
  int i, j;
  int p = 0;
  int t = 0;
  int h = 1;

  for (i = 0; i < m - 1; i++)
    h = (h * d) % q;

  // Calculate hash value for pattern and text
  for (i = 0; i < m; i++) {
    p = (d * p + pattern[i]) % q;
    t = (d * t + text[i]) % q;
  }

  // Find the match
  for (i = 0; i <= n - m; i++) {
    if (p == t) {
      for (j = 0; j < m; j++) {
        if (text[i + j] != pattern[j])
          break;
      }

      if (j == m)
        printf("Pattern is found at position:  %d \n", i + 1);
    }

    if (i < n - m) {
      t = (d * (t - text[i] * h) + text[i + m]) % q;

      if (t < 0)
        t = (t + q);
    }
  }
}
  	        #define V 5 
  
// A utility function to find the vertex with 
// minimum key value, from the set of vertices 
// not yet included in MST 
            int minKey(int key[], bool mstSet[]) 
{ 
    // Initialize min value 
    int min = INT_MAX, min_index; 
  
    for (int v = 0; v < V; v++) 
        if (mstSet[v] == false && key[v] < min) 
            min = key[v], min_index = v; 
  
    return min_index; 
} 
  
// A utility function to print the 
// constructed MST stored in parent[] 
            int printMST(int parent[], int graph[V][V]) 
{ 
    printf("Edge \tWeight\n"); 
    for (int i = 1; i < V; i++) 
        printf("%d - %d \t%d \n", parent[i], i, graph[i][parent[i]]); 
} 
  
// Function to construct and print MST for 
// a graph represented using adjacency 
// matrix representation 
            void primMST(int graph[V][V]) 
{ 
    // Array to store constructed MST 
    int parent[V]; 
    // Key values used to pick minimum weight edge in cut 
    int key[V]; 
    // To represent set of vertices included in MST 
    bool mstSet[V]; 
  
    // Initialize all keys as INFINITE 
    for (int i = 0; i < V; i++) 
        key[i] = INT_MAX, mstSet[i] = false; 
  
    // Always include first 1st vertex in MST. 
    // Make key 0 so that this vertex is picked as first vertex. 
    key[0] = 0; 
    parent[0] = -1; // First node is always root of MST 
  
    // The MST will have V vertices 
    for (int count = 0; count < V - 1; count++) { 
        // Pick the minimum key vertex from the 
        // set of vertices not yet included in MST 
        int u = minKey(key, mstSet); 
  
        // Add the picked vertex to the MST Set 
        mstSet[u] = true; 
  
        // Update key value and parent index of 
        // the adjacent vertices of the picked vertex. 
        // Consider only those vertices which are not 
        // yet included in MST 
        for (int v = 0; v < V; v++) 
  
            // graph[u][v] is non zero only for adjacent vertices of m 
            // mstSet[v] is false for vertices not yet included in MST 
            // Update the key only if graph[u][v] is smaller than key[v] 
            if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v]) 
                parent[v] = u, key[v] = graph[u][v]; 
    } 
  
    // print the constructed MST 
    printMST(parent, graph); 
} 
 	        int temp;  
  
            void heapify(int arr[], int size, int i)  
{  
int largest = i;    
int left = 2*i + 1;    
int right = 2*i + 2;    
  
if (left < size && arr[left] >arr[largest])  
largest = left;  
  
if (right < size && arr[right] > arr[largest])  
largest = right;  
  
if (largest != i)  
{  
temp = arr[i];  
    arr[i]= arr[largest];   
    arr[largest] = temp;  
heapify(arr, size, largest);  
}  
}  
  
            void heapSort(int arr[], int size)  
{  
int i;  
for (i = size / 2 - 1; i >= 0; i--)  
heapify(arr, size, i);  
for (i=size-1; i>=0; i--)  
{  
temp = arr[0];  
    arr[0]= arr[i];   
    arr[i] = temp;  
heapify(arr, i, 0);  
}  
}  
  
		printf("Choose the operation to be performed\n");
		printf("1. Insertion Sort\n");
		printf("2. Linear Search\n");
		printf("3. Binary Search\n");
		printf("4. Merge Sort\n");
		printf("5. Quick Sort\n");
		printf("6. Counting Sort\n");
		printf("7. Naive String \n");
		printf("8. KMP\n");
		printf("9. Rabin Karp\n");
		printf("10. MST (prims algorithm)\n");
		printf("11. Heap Sort\n");
		scanf("%d", &z);
		switch (z){
			case 1:
			     
					{ 
    						int arr[] = { 12, 11, 13, 5, 6 }; 
    						int n = sizeof(arr) / sizeof(arr[0]); 
  
    						insertionSort(arr, n); 
    						printArray(arr, n); 
  
    						return 0; 
					} 
				

				
			
			break;
		
		case 2:
			
  
	 
			
			{ 
    				int arr[] = { 2, 3, 4, 10, 40 }; 
    				int x = 10; 
    				int n = sizeof(arr) / sizeof(arr[0]); 
    
     
    				int result = search(arr, n, x); 
    				(result == -1) 
        				? printf("Element is not present in array") 
        				: printf("Element is present at index %d", result); 
    				return 0; 
			}
		case 3:
			
  
			
			{ 
    				int arr[] = { 2, 3, 4, 10, 40 }; 
    				int n = sizeof(arr) / sizeof(arr[0]); 
    				int x = 10; 
    				int result = binarySearch(arr, 0, n - 1, x); 
    				(result == -1) ? printf("Element is not present in array") 
                   		: printf("Element is present at index %d", 
                            		result); 
    				return 0; 
			} 

		case 4:
			

			
				{
    					int arr[] = { 12, 11, 13, 5, 6, 7 };
    					int arr_size = sizeof(arr) / sizeof(arr[0]);
 
    					printf("Given array is \n");
    					printarray(arr, arr_size);
 
    					mergeSort(arr, 0, arr_size - 1);
 
    					printf("\nSorted array is \n");
    					printarray(arr, arr_size);
    					return 0;
				}

		case 5:
			
 
				{ 
    					int arr[] = {10, 7, 8, 9, 1, 5}; 
    					int n = sizeof(arr)/sizeof(arr[0]); 
    					quickSort(arr, 0, n-1); 
    					printf("Sorted array: \n"); 
    					PrintArray(arr, n); 
    					return 0; 
				} 

		case 6:
				{  
                        int n, k = 0, A[15], i;  
                        printf("Enter the number of input : ");  
                        scanf("%d", &n);  
                        printf("\nEnter the elements to be sorted :\n");  
                        for (i = 1; i <= n; i++)  
                        {  
                            scanf("%d", &A[i]);  
                            if (A[i] > k) {  
                                k = A[i];  
                            }  
                        }  
                        counting_sort(A, k, n);  
                        printf("\n");  
                        return 0;  
}
		
		case 7:
		       {
		         char txt[] = "AABAACAADAABAAABAA"; 
                char pat[] = "AABA"; 
                Search( pat, txt); 
                return 0;         
 }
		case 8:
		{
		    char text[] = "xyztrwqxyzfg";
   char pattern[] = "xyz";
   printf("The pattern is found in the text at the following index : \n");
   KMPAlgorithm(text, pattern);
   return 0;
		}
		
		case 9:
		{
		     char text[] = "ABCCDDAEFG";
  char pattern[] = "CDD";
  int q = 13;
  rabinKarp(pattern, text, q);
		}
		
		case 10:
		{
		     int graph[V][V] = { { 0, 2, 0, 6, 0 }, 
                        { 2, 0, 3, 8, 5 }, 
                        { 0, 3, 0, 0, 7 }, 
                        { 6, 8, 0, 0, 9 }, 
                        { 0, 5, 7, 9, 0 } }; 
  
    // Print the solution 
    primMST(graph); 
  
    return 0; 
		}
		
		case 11:
		{
		    int arr[] = {1, 10, 2, 3, 4, 1, 2, 100,23, 2};  
int i;  
int size = sizeof(arr)/sizeof(arr[0]);  
  
heapSort(arr, size);  
  
printf("printing sorted elements\n");  
for (i=0; i<size; ++i)  
printf("%d\n",arr[i]);  
		}

		default:
			printf("Out of Range");
	}
	return 0; 
}