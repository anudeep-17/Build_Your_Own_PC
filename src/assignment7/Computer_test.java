package assignment7;

public class Computer_test 
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
	
	//runtests 
	static void runtests()
	{
		//computer intances for testing 
		Computer cpu = new Computer();
		Computer cpu1 = new Computer();
		Computer cpu2 = new Computer();
		Computer cpu3 = new Computer();
		Computer cpu4 = new Computer();
		Computer cpu5 = new Computer();
		
		//commade list with descriptive names for particualr testing
		String[] ALUtest = new String[5];
		
		ALUtest[0] = "1110000100100011";
		ALUtest[1] = "1110000100100011";
		ALUtest[2] = "1110000100100011";
		ALUtest[3] = "0010000000000001"; //prints whole memory
		ALUtest[4] = "0000000000000000";
		
		String[] ALUtest1 = new String[5];
		
		ALUtest1[0] = "1110000100100010";
		ALUtest1[1] = "1110000100100010";
		ALUtest1[2] = "1110000100100010";
		ALUtest1[3] = "0010000000000001"; //prints whole memory
		ALUtest1[4] = "0000000000000000";
		
		String[] movetest = new String[5];
		
		movetest[0] = "0001001000001010";
		movetest[1] = "0001001000001011";
		movetest[2] = "0001001000001010";
		movetest[3] = "0010000000000000"; //prints whole register
		movetest[4] = "0000000000000000";
		
		String[] movetest1 = new String[5];
		
		movetest1[0] = "0001000100001011";
		movetest1[1] = "0001001000001010";
		movetest1[2] = "0001001000001011";
		movetest1[3] = "0010000000000000"; //prints whole register
		movetest1[4] = "0000000000000000"; 
		
		
		String[] halttest = new String[5];
		
		halttest[0] = "000000000000000"; //halts
		halttest[1] = "0001000000001010";
		halttest[2] = "0010000000000000";
		
		String[] halttest1 = new String[5];
		
		halttest1[0] = "1110000100100011"; 
		halttest1[1] = "0001000000001010";
		halttest1[2] = "0010000000000000";
		halttest1[3] = "0000000000000000"; //halts
		
		//test1
		System.out.println("-----------------CPU 0 [alu test]---------------");
		cpu.fillregister(filler()); //fills the registers
		try {
		
			//runs the methods and if no exception then success
		cpu.preload(ALUtest);
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
		
		//test1
		System.out.println("-----------------CPU 1 [alu test1] ---------------");
		cpu1.fillregister(filler());
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
				
		
		//test 2
		System.out.println("-----------------CPU 2 [movetest] ---------------");
		cpu2.fillregister(filler());
		try {
			//runs the methods and if no exception then success
			cpu2.preload(movetest);
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
		
		//test 3
		System.out.println("-----------------CPU 3 [movetest1] ---------------");
		cpu3.fillregister(filler());
		try {
			//runs the methods and if no exception then success
			cpu3.preload(movetest1);
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
		
		
		//test4
		System.out.println("-----------------CPU 4 [direct halt] ---------------");
		cpu4.fillregister(filler());
		try {
			//runs the methods and if no exception then success
			cpu4.preload(halttest);
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

		//test 5
		System.out.println("-----------------CPU 5 [direct halt1] ---------------");
		cpu5.fillregister(filler());
		try {
			//runs the methods and if no exception then success
			cpu5.preload(halttest1);
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
		

		
		
	}

}
