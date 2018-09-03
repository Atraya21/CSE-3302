package mukherjee_atraya_1001144456;

public class Prob_3_Imperative {

	public static int gcd_func(int n,int m)
	{
		
		if(m==0 )
		{
			return n;
		}
		
		else
		{
		 return gcd_func(m,n%m);
		}
	}
	public static void main(String args[])
     {	
		for (int i=0; i<10;i++)
			{for (int j=0; j<10;j++)
				{
				System.out.printf("%d\n",gcd_func(i,j));
				}
			}
     }
}
