package assignment6;

import java.util.Arrays;

public class Computer 
{
    static bit bool_check = new bit(true); //setting initial value of the computer as not working == false.
	
   // private memory member 
    private static Memory member_memory = new Memory();
    static Longword PC = new Longword(0); //LONG WORD PC for the address from memory.
    
    // storage of long words takes 16 longwords.
    static Longword[] register = new Longword[16];
    
    // current instructions longword to take the current longword that is being used from memory
    static Longword currentInstruction = new Longword();
    // result longword to store the data in registers.
    static Longword result = new Longword();
    
    // opcode to take the ALU for the operation idea
    static bit[] opcode = new bit[4];
    
    //halt code to compare the obtained code while checking the opcode.
    static bit[] opcode_forhalt= new bit[4];
    
    
    //op1 and op2 for the the addresses to do the operation on.
    static Longword op1 = new Longword();
    static Longword op2 = new Longword();
    
    
    static Longword interrupt1 = new Longword(0);
    static Longword interrupt2 = new Longword(0);
    
    public Computer()
    {
    	 member_memory = new Memory();
    }
       
    //run method - calls all the methods of the Computer while checking the boolean on or off. 
	static void run() throws Exception
	{
		//loop to call the methods
		while(bool_check.getValue())
		{
			fetch(); //calls method fetch
			decode(); // calls method decode
			execute(); // calls method execute
			store(); // calls method store
//			bool_check.set(false); // sets the boolean value to false for the trail run.
		}
	}
	
	//haltcheck : returns if the given code have all 0000 which means its false.
	static boolean haltcheck(bit[] opcode)
	{
		opcode_forhalt= bit.arraybit(false, false, false, false);
		if(opcode == opcode_forhalt)
		{
			System.out.println("system halted");
			return true;
		} 
		else
		{
			return false;
		}
	}
	
	static void interrupcreator()
	{
		interrupt1.setBit(2, new bit(true)); //sets the interupt 1 value here
		//sets the interupt 2 values 
		interrupt2.setBit(2, new bit(true)); 
		interrupt2.setBit(31, new bit(true));
	}
	
	
	//method fetch : fetches the data from memory to read the operations
	static void fetch() throws Exception
	{
		currentInstruction = member_memory.read(PC); // sets the current instructions by taking the longword from the memeory.
		PC = rippleAdder.add(PC, new Longword(16));	//increments the PC value
	}
		
	//decode method: decodes the last 16 bit values and sets the objects accordingly to perfrom the stuff.
	static void decode() throws Exception
	{

		//opcode will set the 4 bit operations with the values in the bit, so the given format is
		// [4 bits for operation] [4 bits for the first long word address] [4 bits second long word address] [4 bits for the resulting longword address]  
		// so we divide the given 4 bits and store them in the opcode, 
		// here we shifting in such a way that the resulting longword have the first 4 bits as the last 4 indexes.
		// 1110 0001 0010 0011 0000 0000 0000 0000 
		opcode = bit.arraybit(currentInstruction.rightshift(28).getbit(28).getValue(), currentInstruction.rightshift(28).getbit(29).getValue(), currentInstruction.rightshift(28).getbit(30).getValue(), currentInstruction.rightshift(28).getbit(31).getValue());
		if(opcode == bit.arraybit(false, false, false, true))
		{
			move(); //calls move function and exists the method.
			return;
		}
		else if(haltcheck(opcode))
		{
			bool_check = new bit(false);
			return;
		}
		else if(currentInstruction.equals(interrupt1))
		{
			printLongword();
			return;
		}
		else if(currentInstruction.equals(interrupt2))
		{
			printmemory();
			return;
		}
		
		// index 1 comes from the 2nd 4 bits of the given longword where we shift left by 19 and right by 27 making the 4 bits as the last 4 indexes of longword.
		int index1 = (int) currentInstruction.leftshift(4).rightshift(27).getunsigned();
		// index 1 comes from the 3rd 4 bits of the given longword where we shift left by 23 and right by 27 making the 4 bits as the last 4 indexes of longword.
		int index2 = (int) currentInstruction.leftshift(8).rightshift(27).getunsigned();
		//getting the calculated indexes from the register
		op1 = register[index1];
		op2 = register[index2];

	}
	
	//method execute : excecutes the given operation. 
	static void execute()
	{
		
		if(opcode == bit.arraybit(false, false, false, true))
		{   //called move function and exists the method.
			return;
		}
		else if(haltcheck(opcode))
		{
			bool_check = new bit(false);
			return;
		}
		else if(currentInstruction.equals(interrupt1))
		{
			return;
		}
		else if(currentInstruction.equals(interrupt2))
		{
			return;
		}
		
		
		result = Alu.doOp(opcode, op1, op2); // stores the calculated operation on both the given op1 and op2 and returns the longword.
	}

	//store method : stores the result in the register
	static void store()
	{
		
		if(opcode == bit.arraybit(false, false, false, true))
		{   //called move function and exists the method.
			return;
		}
		else if(haltcheck(opcode))
		{
			bool_check = new bit(false);
			return;
		}
		else if(currentInstruction.equals(interrupt1))
		{
			return;
		}
		else if(currentInstruction.equals(interrupt2))
		{
			return;
		}
		
		int result_index = currentInstruction.leftshift(12).rightshift(27).getsigned(); // gets the last 4 bits of the longword which gives the index of the last longowrd.
		register[result_index] = result; // stores the obtained in the register
		System.out.println(result.getsigned());
	} 
	
	
	static void move()
	{
		// index 1 comes from the 2nd 4 bits of the given longword where we shift left by 19 and right by 27 making the 4 bits as the last 4 indexes of longword.
		// 0001 0010 0000 1010 0000 0000 0000 0000 
		int index = (int) currentInstruction.leftshift(4).rightshift(27).getunsigned();
		boolean isnegative = currentInstruction.leftshift(8).getbit(0).getValue();
		result = currentInstruction.leftshift(8).rightshift(23);
		if(isnegative)
		{
			Longword returner = new Longword(-1);
			
			for(int i = 23; i< 32; i++)
			{
				returner.setBit(i, result.getbit(i));
			}
			register[index] = returner;			
		}
		else
		{
			Longword returner = new Longword(0);
			for(int i = 23; i< 32; i++)
			{
				returner.setBit(i, result.getbit(i));
			}
			
			register[index] = returner;		
		}
		
	}	
	
	
	// interrupt calls for printing longword and memeory to the screen.
	
	static void printLongword()
	{
		for(int i = 0; i<register.length; i++)
		{
			System.out.println(register[i].toString());
		}
	}
	
	static void printmemory() throws Exception
	{
		for(int i = 0; i<256; i++)
		{
			Longword temp = new Longword(i);
			System.out.println(member_memory.read(temp).toString());
		}
	}
	
	
	void preload(String[] filler) throws Exception
	{
		char[] ch;
		Longword returner = new Longword(0);
		int overall_len_check = 0;
		
		for(int i = 0; i < filler.length; i = i+2)
		{
				String given = filler[i]+filler[i+1];
				ch = given.toCharArray();
			 
			 for(int j = 0; j < ch.length; j++)
			 {
				 if(ch[j] == '1')
				 {
					 returner.setBit(j, new bit(true));
				 }
				 else if(ch[j] == '0')
				 {
					 returner.setBit(j, new bit(false));
				 }
				 else
				 {
					 continue;
				 }
			 }
			 
			 if(overall_len_check <= 256)
			 {
				 member_memory.write(new Longword(overall_len_check), returner); 
				 overall_len_check +=32;
			 }
		}
	}

}
