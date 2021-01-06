class Main 
{
    int lcs(char[] X, char[] Y, int m, int n) 
    { 
        int A[][] = new int[m + 1][n + 1]; 
        for (int i = 0; i <= m; i++) 
        { 
            for (int j = 0; j <= n; j++) 
            { 
                if (i == 0 || j == 0) 
                    A[i][j] = 0; 
                else if (X[i - 1] == Y[j - 1]) 
                    A[i][j] = A[i - 1][j - 1] + 1; 
                else
                    A[i][j] = max(A[i - 1][j] , A[i][j - 1]); 
            } 
        } 
        for(int i=0; i<=m;i++)
        {
            for(int j=0;j<=n;j++)
                System.out.print(A[i][j]);
            System.out.println();
        }
        return A[m][n]; 
    }
    
    int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    } 
    
    public static void main(String[] args) 
    { 
        Main aj = new Main(); 
        String s1 = "AGGTAB"; 
        String s2 = "GXTXAYB"; 
        char[] X = s1.toCharArray(); 
        char[] Y = s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 
        System.out.println("Length of LCS is"+ " " + aj.lcs(X, Y, m, n)); 
    } 
}