package assignment5;

public class multiplier_test 
{
	
	static void multiply_test()
	{
		//initialize objects
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		//test1
		tester.set(2);
		tester_support.set(3);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 6) // since 2 * 3 = 6 if the signed value of returned longword is 6 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test2
		tester.set(11);
		tester_support.set(13);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 143) // since 11 * 13 = 143 if the signed value of returned longword is 143 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 143 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 143 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test3
		tester.set(7);
		tester_support.set(7);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 49) // since   7*7 = 49 if the signed value of returned longword is 49 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 49 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 49 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test3
		tester.set(8);
		tester_support.set(0);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 0) // since 8 * 0 = 0 if the signed value of returned longword is 0 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test4
		tester.set(0);
		tester_support.set(0);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 0) // since 0 * 0 = 0 if the signed value of returned longword is 0 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test5
		tester.set(-1);
		tester_support.set(-1);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 1) // since -1 * -1 = 1 if the signed value of returned longword is 1 then its success else its a failure.
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 1 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ multiplier.multiply(tester,tester_support).getsigned() + " expected: 1 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test6
		tester.set(6036368);
		tester_support.set(10);
		
		if(multiplier.multiply(tester,tester_support).getsigned() == 60363680) // since 6036368 * 10 = 60363680 if the signed value of returned longword is 60363680 then its success else its a failure.
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
