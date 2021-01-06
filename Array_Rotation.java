public class Main
{
	public static void main(String[] args) {
		int A[] ={1,2,3,4,5,6,7,8,9,10};    int n=A.length;
		int k=5,k1=k,a=0;
		int i,B[];
		B = new int[k];
		while(k1-->0)
		    B[a] = A[a++];  // copying 1st k elements
		for(i=0;i<n-k;i++)
		    A[i] = A[i+k];  // left shift k times
		a=0;
		for(i=n-k;i<n;i++)
		    A[i] = B[a++];
		for(i=0;i<n;i++)
		    System.out.print(A[i] + " ");
	}
}