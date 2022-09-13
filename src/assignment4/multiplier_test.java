package assignment4;

public class multiplier_test 
{
	
	static void multiply_test()
	{
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		
		tester.set(2);
		tester_support.set(3);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 6) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(11);
		tester_support.set(13);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 143) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 143 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 143 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(7);
		tester_support.set(7);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 49) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 49 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 49 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(8);
		tester_support.set(0);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 0) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(0);
		tester_support.set(0);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 0) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(-1);
		tester_support.set(-1);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 1) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 1 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 1 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(6036368);
		tester_support.set(10);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 60363680) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 60363680 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 60363680 -->"); //printing the output value
			System.out.println("failure");
		}
		
		
	}
	
	static void runtests()
	{		
		System.out.println("---------------------------------Multiply test----------------------------------------");
		
		multiply_test();
		
		System.out.println("---------------------------------Multiply test done ----------------------------------------");
		System.out.println();
		
	}
}
