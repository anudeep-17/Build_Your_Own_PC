package assignment7;

public class Mainrun 
{
	//class that calls all the runtests of the classes and displays the test results
	
	
	//*************************bunch of println's are added to make the diplay readable and more indented.
	public static void main(String[] args) throws Exception
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
		
		
		System.out.println("------------------------------------- multiplier test -----------------------------------");
		
		
		//multiplier test cases
		multiplier_test.runtests();
		
		System.out.println("--------------------------------------multiplier test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//ALU test cases
		
		System.out.println("-------------------------------------ALU test -----------------------------------");
		Alu_test.runtests();
		System.out.println("--------------------------------------Alu test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//memory test cases
		
		System.out.println("-------------------------------------Memory test -----------------------------------");
		memory_test.runtests();
		System.out.println("--------------------------------------Memory test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//Computer test cases
		
		System.out.println("-------------------------------------Computer test -----------------------------------");
		Computer_test.runtests();
		System.out.println("--------------------------------------Computer test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Computer test cases
		
		System.out.println("-------------------------------------assembler test -----------------------------------");
		assemble_test.runtests();
		System.out.println("--------------------------------------assembler test dones-----------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
				
		
		
		
		
		
	}

}
