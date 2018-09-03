package mukherjee_atraya_1001144456;

import java.util.function.BinaryOperator;

public class Prob_3_Functional {
	
	static BinaryOperator <Integer> compute =(x,y) ->
	{	
		    if ( y == 0 )                        
		    	{return x ;}
		    else if ( x >= y && y > 0)
		        {return Prob_3_Functional.compute.apply ( y , x % y );}
		    else 
		    	{return Prob_3_Functional.compute.apply ( y , x ); }      
	};
	
	public static void main(String args[])
    {	
		for (int i=0; i<10;i++)
			{for (int j=0; j<10;j++)
				{
				System.out.printf("%d\n",compute.apply(i,j));
				}
			}
    }

}
