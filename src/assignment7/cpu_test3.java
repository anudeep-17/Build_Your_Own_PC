package assignment7;

import java.util.Arrays;

public class cpu_test3 
{
	// filler fills the register with the given values
	static int[] filler()
	{
		int[] registerfill = new int[16];
		registerfill[0] = 1;
		registerfill[1] = 1;
		registerfill[2] = 2;
		registerfill[3] = 3;
		registerfill[4] = 4;
		registerfill[5] = 5;
		registerfill[6] = 6;
		registerfill[7] = 7;
		registerfill[8] = 8;
		registerfill[9] = 9;
		registerfill[10] = 10;
		registerfill[11] = 11;
		registerfill[12] = 12;
		registerfill[13] = 13;
		registerfill[14] = 14;
		registerfill[15] = 15;
		
		return registerfill; //returns the registerfill values
	}
	
	static void runtests() throws Exception
	{
		Computer cpu = new Computer(); 
		//command list with descriptive names for particualr testing
		String[] stacktest1 = new String[10];
		 
		stacktest1[0] = "call 6";
		stacktest1[1] = "interrupt 0";
		stacktest1[2] = "halt";
		stacktest1[3] = "interrupt 1";
		stacktest1[4] = "push R1";
		stacktest1[5] = "move R1 3";
		stacktest1[6] = "pop R1";
		stacktest1[7] = "return";
		
		System.out.println("-----------------assmble/new computer test [Jump test]---------------");
		cpu.fillregister(filler()); //fills the registers
		stacktest1 = assembler.assemble(stacktest1);
		
//		System.out.println(Arrays.toString(jumptest1));
		
		try {
//			
		//runs the methods and if no exception then success
		cpu.preload(stacktest1); // this will be skiping the overall 
		cpu.run(); 
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
//		
//		
//		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		Computer cpu1 = new Computer(); 
		//command list with descriptive names for particualr testing
		String[] stacktest2 = new String[10];
		 
		stacktest2[0] = "call 6";
		stacktest2[1] = "interrupt 0";
		stacktest2[2] = "halt";
		stacktest2[3] = "interrupt 1";
		stacktest2[4] = "push R3";
		stacktest2[5] = "move R1 5";
		stacktest2[6] = "pop R3";
		stacktest2[7] = "return";
		
		System.out.println("-----------------assmble/new computer test [Jump test]---------------");
		cpu1.fillregister(filler()); //fills the registers
		stacktest2 = assembler.assemble(stacktest2);
		
//		System.out.println(Arrays.toString(jumptest1));
		
		try {
//			
		//runs the methods and if no exception then success
		cpu1.preload(stacktest2); // this will be skiping the overall 
		cpu1.run(); 
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
//		
//		
//		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		Computer cpu2 = new Computer(); 
		//command list with descriptive names for particualr testing
		String[] stacktest3 = new String[10];
		 
		stacktest3[0] = "call 7";
		stacktest3[1] = "interrupt 0";
		stacktest3[3] = "interrupt 1";
		stacktest3[2] = "halt";
		stacktest3[4] = "push R3";
		stacktest3[5] = "move R1 5";
		stacktest3[6] = "pop R3";
		
		System.out.println("-----------------assmble/new computer test [stack test -- will halt directly]---------------");
		cpu2.fillregister(filler()); //fills the registers
		stacktest3 = assembler.assemble(stacktest3);
		
//		System.out.println(Arrays.toString(jumptest1));
		
		try {
//			
		//runs the methods and if no exception then success
		cpu2.preload(stacktest3); // this will be skiping the overall 
		cpu2.run(); 
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
//		
//		
//		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
				
	public static void main(String[]args) throws Exception
	{
		runtests();
	}
}
