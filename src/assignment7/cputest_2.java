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
//				//command list with descriptive names for particualr testing
//				String[] jumptest1 = new String[4];
//				
//				jumptest1[0] = "jump 4";
//				jumptest1[1] = "move R1 5";
//				jumptest1[2] = "interrupt 0";
//				jumptest1[3] = "halt";
//				
//				System.out.println("-----------------assmble test [move test]---------------");
//				cpu.fillregister(filler()); //fills the registers
//				jumptest1 = assembler.assemble(jumptest1);
//				try {
////					
//				//runs the methods and if no exception then success
//				cpu.preload(jumptest1); // this will be skiping the overall 
//				cpu.run(); 
//				System.out.println("System success task complete");
//				}
//				catch(Exception e)
//				{
//					System.out.println("System failed task incomplete");
//				}
				
				
				//command list with descriptive names for particualr testing
				String[] branchtest = new String[4];
				
				branchtest[0] = "compare R1 R2";
				branchtest[1] = "branchifnotequal 8";
				branchtest[2] = "interrupt 0";
				branchtest[3] = "halt";
				
				System.out.println("-----------------assmble test [move test]---------------");
				cpu.fillregister(filler()); //fills the registers
				branchtest = assembler.assemble(branchtest);
				try {
//					
				//runs the methods and if no exception then success
				cpu.preload(branchtest); // this will be skiping the overall 
				cpu.run(); 
				System.out.println("System success task complete");
				}
				catch(Exception e)
				{
					System.out.println("System failed task incomplete");
				}
				
			}
			
			public static void main(String[] args) throws Exception
			{
				runtests();
			}
			
}
