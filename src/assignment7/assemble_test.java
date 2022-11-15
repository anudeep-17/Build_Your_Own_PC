package assignment7;

import java.util.Arrays;

public class assemble_test 
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
	
	static void runtests()
	{
		//computer intances for testing 
		Computer cpu = new Computer();
		Computer cpu1 = new Computer();
		Computer cpu2 = new Computer();
		Computer cpu3 = new Computer();
		Computer cpu4 = new Computer();
		Computer cpu5 = new Computer();
		Computer cpu6 = new Computer();
		Computer cpu7 = new Computer();
		Computer cpu8 = new Computer();
		Computer cpu9 = new Computer();
		
		//command list with descriptive names for particualr testing
		String[] ALUtest1 = new String[3];
		
		ALUtest1[0] = "add R1 R2 R3";
		ALUtest1[1] = "interrupt 0";
		ALUtest1[2] = "halt";
		
		//command list with descriptive names for particualr testing
		String[] ALUtest2 = new String[3];
		ALUtest2[0] = "sub R1 R2 R3";
		ALUtest2[1] = "interrupt 1";
		ALUtest2[2] = "halt";
	
		
		
		//command list with descriptive names for particualr testing
		String[] ALUtest3 = new String[3];
		ALUtest3[0] = "or R1 R2 R3";
		ALUtest3[1] = "interrupt 0";
		ALUtest3[2] = "halt";
		
		//command list with descriptive names for particualr testing
		String[] ALUtest4 = new String[3];
		ALUtest4[0] = "xor R1 R2 R3";
		ALUtest4[1] = "interrupt 0";
		ALUtest4[2] = "halt";
//		ALUtest4 = assembler.assemble(ALUtest4);
		
		//command list with descriptive names for particualr testing
		String[] ALUtest5 = new String[3];
		ALUtest5[0] = "not R1 R2 R3";
		ALUtest5[1] = "interrupt 0";
		ALUtest5[2] = "halt";
//		ALUtest5 = assembler.assemble(ALUtest5);
//		System.out.println(Arrays.toString(ALUtest5));
		
		String[] moveTest = new String[3];
		moveTest[0] = "move R1 10";
		moveTest[1] = "interrupt 0";
		moveTest[2] = "halt";
//		moveTest = assembler.assemble(moveTest);
		
		
//		System.out.println(Arrays.toString(ALUtest5));
		//--------------------------------errorcheck----------------------------
		String[] Error = new String[3];
		Error[0] = "move R1 10 R1";

		
		String[] Error1 = new String[3];
		Error1[0] = "add R1";

		
		String[] Error2 = new String[3];
		Error2[0] = "halt 10";
		
		
		System.out.println("-----------------assmble test [move test]---------------");
		cpu.fillregister(filler()); //fills the registers
		moveTest = assembler.assemble(moveTest);
		try {
			
		//runs the methods and if no exception then success
		cpu.preload(moveTest);
		cpu.run(); 
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("-----------------assmble test [ALU test1]---------------");
		cpu1.fillregister(filler()); //fills the registers
		ALUtest1 = assembler.assemble(ALUtest1);
		try {
			
		//runs the methods and if no exception then success
		cpu1.preload(ALUtest1);
		cpu1.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("-----------------assmble test [ALU test2]---------------");
		cpu2.fillregister(filler()); //fills the registers
		ALUtest2 = assembler.assemble(ALUtest2);
		try {
			
			//runs the methods and if no exception then success
		cpu2.preload(ALUtest2);
		cpu2.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("-----------------assmble test [ALU test3]---------------");
		cpu3.fillregister(filler()); //fills the registers
		ALUtest3 = assembler.assemble(ALUtest3);
		try {
			
			//runs the methods and if no exception then success
		cpu3.preload(ALUtest3);
		cpu3.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("-----------------assmble test [ALU test3]---------------");
		cpu4.fillregister(filler()); //fills the registers
		ALUtest4 = assembler.assemble(ALUtest4);
		try {
			
			//runs the methods and if no exception then success
		cpu4.preload(ALUtest4);
		cpu4.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("-----------------assmble test [ALU test4]---------------");
		cpu5.fillregister(filler()); //fills the registers
		ALUtest5 = assembler.assemble(ALUtest5);
		try {
			
			//runs the methods and if no exception then success
		cpu5.preload(ALUtest5);
		cpu5.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("-----------------assmble test [ALU test5]---------------");
		cpu6.fillregister(filler()); //fills the registers
		try {
			
			//runs the methods and if no exception then success
		cpu6.preload(ALUtest5);
		cpu6.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		System.out.println("-----------------assmble test [Error test1]---------------");
		cpu7.fillregister(filler()); //fills the registers
		Error = assembler.assemble(Error);
		try {
			
		//runs the methods and if no exception then success
		cpu7.preload(Error);
		cpu7.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println("-----------------assmble test [Error test2]---------------");
		cpu8.fillregister(filler()); //fills the registers
		Error1 = assembler.assemble(Error1);
		try {
			
		//runs the methods and if no exception then success
		cpu8.preload(Error1);
		cpu8.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("-----------------assmble test [Error test3]---------------");
		cpu9.fillregister(filler()); //fills the registers
		Error2 = assembler.assemble(Error2);
		try {
			
		//runs the methods and if no exception then success
		cpu9.preload(Error2);
		cpu9.run();
		System.out.println("System success task complete");
		}
		catch(Exception e)
		{
			System.out.println("System failed task incomplete");
		}
		
	}

}
