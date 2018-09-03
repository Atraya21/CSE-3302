package mukherjee_atraya_1001144456;

public class Prob_2_Imperative {

	public static int fib(double n)
	{	int result;
		
		if(n==0 )
		{
			return 0;
		}
		
		else if(n==1)
		{
		return 1;
		}
		
		else
		{result= fib(n-1)+fib(n-2);
		 return result;
		}
	}
	public static void main(String args[])
     {	
     	for(int i=0; i<=15; i++)
     	{
		 System.out.printf("%d\n",fib(i));
     	}
     }
}
