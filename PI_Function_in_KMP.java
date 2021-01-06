import java.util.*;
public class Main
{
	public static void compute_Prefix_Function(String P) 
	{
        int  m, q, j, i;
        m = P.length();
        int[] pi = new int[m];
        pi[0] = 0;
        j = 0;
        for(i = 1; i < m ; i++)
        {
            while (j > 0 && P.charAt(j) != P.charAt(i))
            {
                j = pi[j-1];
            }
            if ( P.charAt(j) == P.charAt(i) )
            {
                j = j+1;
            }
            pi[i] = j;
        }
        System.out.println(Arrays.toString(pi));
    }
    public static void main(String args[])
    {
        compute_Prefix_Function("ABABD");
    }
}

/*

def calculate_PI(p):
	m = len(p)
	pi = [0]*m
	print (pi)
	j = 0
	for i in range(2,m+1):
		while(j > 0 and p[j+1] != p[i]):
			j = pi[j]
		if (p[j+1] == p[i]):
			j = j+1
		#pi.append(j)
		pi[i] = j
	return pi

print (calculate_PI("ABABD"))

*/