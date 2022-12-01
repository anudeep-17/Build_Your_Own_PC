package assignment7;

public class cputest_2 
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
				String[] jumptest1 = new String[4];
				 
				jumptest1[0] = "jump 4";
				jumptest1[1] = "move R1 5";
				jumptest1[2] = "interrupt 0";
				jumptest1[3] = "halt";
				
				System.out.println("-----------------assmble/new computer test [Jump test]---------------");
				cpu.fillregister(filler()); //fills the registers
				jumptest1 = assembler.assemble(jumptest1);
				try {
//					
				//runs the methods and if no exception then success
				cpu.preload(jumptest1); // this will be skiping the overall 
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
				
				
				Computer cpu1 = new Computer();
				//command list with descriptive names for particualr testing
				String[] jumptest2 = new String[4];
				
				jumptest2[0] = "jump 16";
				jumptest2[1] = "move R1 5";
				jumptest2[2] = "interrupt 0";
				jumptest2[3] = "halt";
				
				System.out.println("-----------------assmble/new computer test [Jump test -- will halt directly]---------------");
				cpu1.fillregister(filler()); //fills the registers
				jumptest2 = assembler.assemble(jumptest2);
				try {
//					
				//runs the methods and if no exception then success
				cpu1.preload(jumptest2); // this will be skiping the overall 
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
				
				
				Computer cpu2 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest = new String[4];
				
				branchtest[0] = "compare R1 R2";
				branchtest[1] = "branchifnotequal 8"; // jump to interrupt
				branchtest[2] = "interrupt 0";
				branchtest[3] = "halt";
				
				System.out.println("-----------------assmble test [branch if not equal test]---------------");
				cpu2.fillregister(filler()); //fills the registers
				branchtest = assembler.assemble(branchtest);
				try {
//					
				//runs the methods and if no exception then success
				cpu2.preload(branchtest); // this will be skiping the overall 
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
				
				Computer cpu7 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest_notEqual = new String[4];
				
				branchtest_notEqual [0] = "compare R4 R3";
				branchtest_notEqual [1] = "branchifnotequal 8"; // jump to interrupt
				branchtest_notEqual [2] = "interrupt 0";
				branchtest_notEqual [3] = "halt";
				
				System.out.println("-----------------assmble test [branch if not equal test 1]---------------");
				cpu7.fillregister(filler()); //fills the registers
				branchtest_notEqual  = assembler.assemble(branchtest_notEqual);
				try {
//					
				//runs the methods and if no exception then success
				cpu7.preload(branchtest_notEqual); // this will be skiping the overall 
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
				
				
				Computer cpu3 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest1 = new String[4];
				
				branchtest1[0] = "compare R0 R1";
				branchtest1[1] = "branchifequal 16"; //jumps to halt
				branchtest1[2] = "interrupt 0";
				branchtest1[3] = "halt";
				
				System.out.println("-----------------assmble test [branch if equal test]---------------");
				cpu3.fillregister(filler()); //fills the registers
				branchtest1 = assembler.assemble(branchtest1);
				try {
//					
				//runs the methods and if no exception then success
				cpu3.preload(branchtest1); // this will be skiping the overall 
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
				
				Computer cpu4 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest2 = new String[4];
				
				branchtest2[0] = "compare R2 R1";
				branchtest2[1] = "branchifgreater 16";
				branchtest2[2] = "interrupt 0";
				branchtest2[3] = "halt";
				
				System.out.println("-----------------assmble test [branch if greater test]---------------");
				cpu4.fillregister(filler()); //fills the registers
				branchtest2 = assembler.assemble(branchtest2);
				try {
//					
				//runs the methods and if no exception then success
				cpu4.preload(branchtest2); // this will be skiping the overall 
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
				
				
				Computer cpu6 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest4 = new String[4];
				
				branchtest4[0] = "compare R2 R1";
				branchtest4[1] = "branchifgreaterthanequal 16";
				branchtest4[2] = "interrupt 0";
				branchtest4[3] = "halt";
				
				System.out.println("-----------------assmble test [branch if greater and equal test]---------------");
				cpu6.fillregister(filler()); //fills the registers
				branchtest4 = assembler.assemble(branchtest4);
				try {
//					
				//runs the methods and if no exception then success
				cpu6.preload(branchtest4); // this will be skiping the overall 
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
				
				

				Computer cpu8 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest_GNE = new String[4];
				
				branchtest_GNE[0] = "compare R8 R7";
				branchtest_GNE[1] = "branchifgreaterthanequal 16";
				branchtest_GNE[2] = "interrupt 0";
				branchtest_GNE[3] = "halt";
				
				System.out.println("-----------------assmble test [branch if greater and equal test 1]---------------");
				cpu8.fillregister(filler()); //fills the registers
				branchtest_GNE = assembler.assemble(branchtest_GNE);
				try {
//					
				//runs the methods and if no exception then success
				cpu8.preload(branchtest_GNE); // this will be skiping the overall 
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
				
				
				
				Computer cpu5 = new Computer();
				//command list with descriptive names for particualr testing
				String[] branchtest5 = new String[4];
				
				branchtest5[0] = "move R1 1";
				branchtest5[1] = "branchifgreater 16";
				branchtest5[2] = "interrupt 0";
				branchtest5[3] = "halt";
				
				System.out.println("-----------------assmble test [branch error test]---------------");
				cpu5.fillregister(filler()); //fills the registers
				branchtest5 = assembler.assemble(branchtest5);
				try {
//					
				//runs the methods and if no exception then success
				cpu5.preload(branchtest5); // this will be skiping the overall 
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
				
				
			}
			
			public static void main(String[] args) throws Exception
			{
				runtests();
			}
			
}
