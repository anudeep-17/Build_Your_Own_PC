package assignment3;

public class Mainrun 
{
	//class that calls all the runtests of the classes and displays the test results
	
	
	//*************************bunch of println's are added to make the diplay readable and more indented.
	public static void main(String[] args)
	{
		System.out.println("--------------------------------------bit test -----------------------------------");
		
		//bit test cases 
		bit_test.runTests();
		
		
		System.out.println("--------------------------------------bit test done -----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("--------------------------------------Longword test -----------------------------------");
		
		
		//longword test cases
		Longword_test.runtests();
		
		
		System.out.println("--------------------------------------Longword test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("------------------------------------- Ripple adder test -----------------------------------");
		
		
		//rippleadder test cases
		rippleAdder_test.runtests();
		
		System.out.println("--------------------------------------Ripple adder test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}

}
