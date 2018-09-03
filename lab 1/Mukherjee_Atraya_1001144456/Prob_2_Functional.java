package mukherjee_atraya_1001144456;

import java.util.function.UnaryOperator;

public class Prob_2_Functional{

	static UnaryOperator <Integer> compute = num ->
	{	int result;
		
		if(num==0 )
		{
			return 0;
		}
		
		else if(num==1)
		{
		return 1;
		}
		
		else
		{result= Prob_2_Functional.compute.apply(num-1)+Prob_2_Functional.compute.apply(num-2);
		 return result;
		}
	};
	public static void main(String args[])
     {	
     	for(int i=0; i<=15; i++)
     	{
		 System.out.printf("%d\n",compute.apply(i));
     	}
     }
}
