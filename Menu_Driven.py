import sys
def choice():
    print("Select a Lab no.")
    print("1.Linear Search")
    print("2.Binary Search")
    print("3.Insertion Sort")
    print("4.erge Sort")
    print("5.Quick Sort")
    print("6.Counting Sort")
    print("7.Longest Common Subsequence")
    print("8.Naive String Matching")
    print("9.KMP")
    print("10.Minimum Spanning tree")
    print("11.Rabin-karp Matching")
    print("12.Heap Sort")
def insertion_sort(a):
    for j in range(2, len(a)):
        key = a[j]
        i = j - 1
        while (i >= 0 and key < a[i]):
            a[i + 1] = a[i]
            i = i - 1
        a[i + 1] = key
def linear_Search(list,n,key):  
    for i in range(0, n):  
        if (list[i] == key):  
            return i  
    return -1   
def binarySearch (arr, first, last, x): 
    if last>=first: 
        mid=int((first+last)/2)
        if arr[mid]==x: 
            return mid 
        elif arr[mid] > x: 
            return binarySearch(arr, first, mid-1, x) 
        else: 
            return binarySearch(arr, mid + 1, last, x) 
    else: 
        return -1
def merge(arr, l, m, r): 
    n1 = m - l + 1
    n2 = r- m  
    L = [0] * (n1) 
    R = [0] * (n2)  
    for i in range(0 , n1): 
        L[i] = arr[l + i] 
    for j in range(0 , n2): 
        R[j] = arr[m + 1 + j] 
    i = 0    
    j = 0      
    k = l 
    while i < n1 and j < n2 : 
        if L[i] <= R[j]: 
            arr[k] = L[i] 
            i += 1
        else: 
            arr[k] = R[j] 
            j += 1
        k += 1
    while i < n1: 
        arr[k] = L[i] 
        i += 1
        k += 1
    while j < n2: 
        arr[k] = R[j] 
        j += 1
        k += 1
def mergeSort(arr,l,r): 
    if l < r: 
        m = (l+(r-1))//2
        mergeSort(arr, l, m) 
        mergeSort(arr, m+1, r) 
        merge(arr, l, m, r)    
def partition(arr, low, high):
    i = (low-1)        
    pivot = arr[high]     
    for j in range(low, high):
        if arr[j] <= pivot:
            i = i+1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i+1], arr[high] = arr[high], arr[i+1]
    return (i+1)
def quickSort(arr, low, high):
    if len(arr) == 1:
        return arr
    if low < high:
        pi = partition(arr, low, high)
        quickSort(arr, low, pi-1)
        quickSort(arr, pi+1, high)  
def counting_sort(array1, max_val):
    m = max_val + 1
    count = [0] * m                 
    for a in array1:
        count[a] += 1             
    i = 0
    for a in range(m):            
        for c in range(count[a]):  
            array1[i] = a
            i += 1
    return array1  
def lcs(X , Y): 
    m = len(X) 
    n = len(Y) 
    L = [[None]*(n+1) for i in range(m+1)] 
    for i in range(m+1): 
        for j in range(n+1): 
            if i == 0 or j == 0 : 
                L[i][j] = 0
            elif X[i-1] == Y[j-1]: 
                L[i][j] = L[i-1][j-1]+1
            else: 
                L[i][j] = max(L[i-1][j] , L[i][j-1]) 
    return L[m][n] 
def naive(pat,txt):
    M = len(pat) 
    N = len(txt)
    for i in range(N - M + 1):
        s=0
        while(s < M): 
            if (txt[i + s] != pat[s]): 
                break
            s += 1
        if (s == M):  
            print("Pattern found with shift ", i) 
def array(P):
    m=len(P)
    k=-1
    pie=[int(i) for i in range(m)]
    pie[0]=-1
    for q in range (1,m):
        while (k>=0 and P[k+1]!=P[q]):
            k=pie[k]
        if P[k+1]==P[q]:
            k=k+1
        pie[q]=k
    for q in range (0,m):
        print(pie[q]+1,end=' ')
    
    return pie
def KMP(T,P):
    q=-1
    n=len(T)
    m=len(P)
    pie = array(P)
    for i in range(0,n):
        while (q>=0 and P[q+1]!=T[i]):
            q=pie[q]
        if P[q+1]==T[i]:
            q=q+1
        if q==m-1:
            print("Pattern occur at shift: ",i-m+1)
            q=pie[q]
class Graph(): 
  
    def _init_(self, vertices): 
        self.V = vertices 
        self.graph = [[0 for column in range(vertices)]  
                    for row in range(vertices)] 
    def printMST(self, parent): 
        print ("Edge \tWeight")
        for i in range(1, self.V): 
            print(parent[i], "-", i, "\t", self.graph[i][ parent[i]] )
    def minKey(self, key, mstSet): 
        min = sys.maxint 
  
        for v in range(self.V): 
            if key[v] < min and mstSet[v] == False: 
                min = key[v] 
                min_index = v 
  
        return min_index
    def primMST(self): 
        key = [sys.maxint] * self.V 
        parent = [None] * self.V 
        key[0] = 0 
        mstSet = [False] * self.V 
        for cout in range(self.V):  
            u = self.minKey(key, mstSet)
            mstSet[u] = True 
            for v in range(self.V): 
                if self.graph[u][v] > 0 and mstSet[v] == False and key[v] > self.graph[u][v]: 
                        key[v] = self.graph[u][v] 
                        parent[v] = u 
  
        self.printMST(parent)        
def search(pat, txt, q): 
    M = len(pat) 
    N = len(txt) 
    i = 0
    j = 0
    p = 0     
    t = 0     
    h = 1 
    for i in range(M-1): 
        h = (h*d)%q 
    for i in range(M): 
        p = (d*p + ord(pat[i]))%q 
        t = (d*t + ord(txt[i]))%q 
    for i in range(N-M+1): 
        if p==t:  
            for j in range(M): 
                if txt[i+j] != pat[j]: 
                    break
                else: j+=1 
            if j==M: 
                print ("\nPattern occur at shift " + str(i))
        if i < N-M: 
            t = (d*(t-ord(txt[i])*h) + ord(txt[i+M]))%q  
            if t < 0: 
                t = t+q      
            
def heapify(arr, n, i):
    largest = i  
    l = 2 * i + 1    
    r = 2 * i + 2     
    if l < n and arr[largest] < arr[l]:
        largest = l
    if r < n and arr[largest] < arr[r]:
        largest = r
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]  
        heapify(arr, n, largest)
def heapSort(arr):
    n = len(arr)
    for i in range(n//2 - 1, -1, -1):
        heapify(arr, n, i)
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)
      
def main(): 
    while True:
        choice()
        option =eval(input('Enter Choice from 1-14 from the menu or enter  to exit.'))
        if(option==3):
            print('Insertion Sort')
            a= input('Enter the list of numbers: ').split()
            a = [int(x) for x in a]
            insertion_sort(a)
            print('Sorted list: ',end=' ')
            print(a)
        elif(option==1):
            print('Linear Search')
            list= input('Enter the list of numbers: ').split()    
            list = [int(x) for x in list]
            key = int(input('Enter key: '))
            n = len(list)  
            res = linear_Search(list, n, key)  
            if(res == -1):  
                print("Element not found")  
            else:  
                print("Element found at index: ", res)
        elif(option==2):
            print('Binary Search')
            arr = input('Enter the list of numbers: ').split()
            arr=[int(i)for i in arr]
            x=int(input("Enter a key: "))
            result = binarySearch(arr, 0, len(arr)-1, x) 
            if result != -1: 
                print ("Element is present at index: % d" % result) 
            else: 
                print ("Element is not present in array") 
        elif(option==4):
            print("Merge Sort")
            arr=input("Enter the list of numbers: ").split()
            arr=[int(x) for x in arr] 
            mergeSort(arr,0,len(arr)-1) 
            print("Sorted list",end=' ')
            print(arr)
        elif(option==5):
            print("Quick Sort")
            arr = input("Enter the list of numbers: ").split()
            arr=[int(x) for x in arr] 
            n = len(arr)
            quickSort(arr, 0, n-1)
            print("Sorted array is:")
            for i in range(n):
                print("%d" % arr[i])
        elif(option==6):
            print("Counting Sort")
            arr = input("Enter the list of numbers: ").split()
            arr=[int(x) for x in arr] 
            m=max(arr)
            print(counting_sort(arr,m))
        elif(option==7):
            print('Longest Common Subsequence')
            X =input("Enter first string: ")
            print(X)
            Y =input('Enter second string: ')
            print(Y)  
            print ("Length of LCS is ", lcs(X, Y) )
        elif(option==8):
            print('Naive String matching')
            pat =input("Enter pattern string: ")
            txt =input('Enter text string: ')  
            print(naive(pat,txt))
        elif(option==9):
            T=input("Enter text: ")
            P=input("Enter pattern: ")
            n=len(T)
            m=len(P)
            KMP(T,P) 
        elif(option==10):
            g = Graph(5) 
            g.graph = [ [0, 2, 0, 6, 0], 
                        [2, 0, 3, 8, 5], 
                        [0, 3, 0, 0, 7], 
                        [6, 8, 0, 0, 9], 
                        [0, 5, 7, 9, 0]] 
  
            g.primMST(); 
        elif(option==11):
            txt = input("Enter Text: ")
            pat = input("Enter Pattern")
            d=10
            q = 13 
            search(pat,txt,q)
        elif(option==12):
            arr = input("Enter the list of numbers: ").split()
            arr=[int(x) for x in arr] 
            heapSort(arr)
            n = len(arr)
            print("Sorted array is")
            for i in range(n):
                print("%d" % arr[i],end=' ')
        elif option==13:
                break
        else:
            print("Invalid Lab")
main()