//use of long instead of integer is important to show larger factorial values
package mukherjee_atraya_1001144456;

public class Prob_1_Imperative
{	
	
	public static long factorial_func(int n)
	{	long result;
		
		if(n==0 || n==1)
		{
		result=1;
		return result;
		}
	
		result= factorial_func(n-1)*n;
		return result;
		}
	 
	public static void main(String args[])
     {	
     	for(int i=0; i<=15; i++)
     	{
		 System.out.printf("%d\n",factorial_func(i));
     	}
     }
}

