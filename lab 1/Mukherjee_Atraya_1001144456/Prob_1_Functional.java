//Use of long instead of Integer is required to compute the right factorial value for 
// the larger numbers,i.e, 15!
package mukherjee_atraya_1001144456;
import java.util.function.UnaryOperator;

public class Prob_1_Functional {
	
	static UnaryOperator <Long> compute = num ->
	{long result;
	
	if(num==0 || num==1)
	{
	result=1;
	return result;
	}

	result= (Prob_1_Functional.compute.apply(num-1)*num);
	return result;
	};
	
	public static void main(String args[])
	     {	
			
			
	     	for(long i=0; i<=15; i++)
	     	{
			 System.out.printf("%d\n",compute.apply(i));
	     	}
	     }
}

	


