package assignment7;

import java.util.Arrays;

public class Computer 
{
     bit bool_check = new bit(true); //setting initial value of the computer as not working == false.
	
   // private memory member 
     Memory member_memory = new Memory();
     Longword PC = new Longword(0); //LONG WORD PC for the address from memory.
    
    // storage of long words takes 16 longwords.
     Longword[] register = new Longword[16];
    
    // current instructions longword to take the current longword that is being used from memory
     Longword currentInstruction = new Longword();
    // result longword to store the data in registers.
     Longword result = new Longword();
    
    // opcode to take the ALU for the operation idea
    bit[] opcode = new bit[4];
    
    //halt code to compare the obtained code while checking the opcode.
    bit[] opcode_forhalt= new bit[4];
    
    
    //op1 and op2 for the the addresses to do the operation on.
     Longword op1 = new Longword();
     Longword op2 = new Longword();
    
    //2 interrupt values for the break of the program to print the data
     Longword interrupt1 = new Longword(8192); // to print the longword
     Longword interrupt2 = new Longword(8193); // to print the memory
    
     
     //stack pointer initialization
     Longword StackPointer = new Longword(8160);
     
     //comparision code 
     bit[] compare_bit = new bit[2];
     int callindex = 0; //for the index to go ahead in stack and read
     
    public Computer()
    {
    	 member_memory = new Memory();
    }
       
    //run method - calls all the methods of the Computer while checking the boolean on or off. 
	void run() throws Exception
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
		
	
	//method fetch : fetches the data from memory to read the operations
	void fetch() throws Exception
	{
		System.out.println("Current pc value: " +  PC.getsigned());
		currentInstruction = member_memory.read(PC); // sets the current instructions by taking the longword from the memeory.
		System.out.println("current instruction: "+ currentInstruction.toString());
		System.out.println();
		PC = rippleAdder.add(PC, new Longword(16));	//increments the PC value
	}
		
	
	
	//decode method: decodes the last 16 bit values and sets the objects accordingly to perfrom the stuff.
	void decode() throws Exception
	{
		
		//opcode will set the 4 bit operations with the values in the bit, so the given format is
		// [4 bits for operation] [4 bits for the first long word address] [4 bits second long word address] [4 bits for the resulting longword address]  
		// so we divide the given 4 bits and store them in the opcode, 
		// here we shifting in such a way that the resulting longword have the first 4 bits as the last 4 indexes.
		// 1110 0001 0010 0011 0000 0000 0000 0000 
		opcode = bit.arraybit(currentInstruction.rightshift(28).getbit(28).getValue(), currentInstruction.rightshift(28).getbit(29).getValue(), currentInstruction.rightshift(28).getbit(30).getValue(), currentInstruction.rightshift(28).getbit(31).getValue());
		
		
		//if opcode is 0000 that hte end of the program the and nothing will be done after that .
		if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			System.out.println("----------------System halted ----------"); //prompts that the system is halted
			bool_check.set(false);// sets the boolean to false and informs system that this is the end
			return; //exits the method
		} 
		// if op code is 0001 then this is will make the call to move method and exits the method.
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
			move(); // calls the move method and does the shiffling as prompted 
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == true)
		{
			int pc_index = currentInstruction.leftshift(4).rightshift(20).getsigned(); //gets the number of values to move ahead
			
			System.out.println("jump by : "+ pc_index); // gives number of registers to move ahead
//			System.out.println(pc_index); 
			if(pc_index*8  < 8192) //if the resulting pc is more than memory then it is breakdown
			{
				PC = new Longword(pc_index * 8); //every 1 numeric goes to 8 bits once so it will multiply by 8 to move ahead in cycle
				System.out.println("JUMP is read for given");
				return;
			}
			else //if the resulting pc is more than memory then it is breakdown
			{
				System.out.println("out of the memeory bound ...!");
				return;
			}
			
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			//calls the compare method
			compare();
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == true && opcode[3].getValue() == false)
		{
			//calls the compare method
			stackoperation();
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
			System.out.println("branching result : " + branch().getValue());
			if(branch().getValue())
			{
//				System.out.println(currentInstruction.leftshift(7).rightshift(24));
				PC = rippleAdder.add(PC, currentInstruction.leftshift(7).rightshift(24));
				return;
			}
			
		}
		//if the opcode 0010 and ends the 15 value as 0 then it is print longword.
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(15).getValue() == false))
		{
			printLongword(); //calls the printlongword method
			return; 
		}
		//if the opcode 0010 and ends the 15 value as 1 then it is print memory.
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(15).getValue() == true))
		{
			printmemory(); //calls the print memory method
			return;
		}
		//else if the opcode is not the same then it is standard alu opcode edits on register.
		else
		{
		// index 1 comes from the 2nd 4 bits of the given longword where we shift left by 19 and right by 28 making the 4 bits as the last 4 indexes of longword.
		int index1 = (int) currentInstruction.leftshift(4).rightshift(28).getunsigned();
		System.out.println("given index1 of register: "+ index1);
		System.out.println(" ");
		
		// index 1 comes from the 3rd 4 bits of the given longword where we shift left by 23 and right by 28 making the 4 bits as the last 4 indexes of longword.
		int index2 = (int) currentInstruction.leftshift(8).rightshift(28).getunsigned();
		System.out.println("given index2 of register: "+ index2);
		System.out.println(" ");
		
		//getting the calculated indexes from the register
		op1 = register[index1];
		//prmoting the registers and index to the user to help in unit testing verification.
		System.out.println("longword in register1 : "+op1.toString());
		System.out.println(" ");
		System.out.println("signedvalue in register1 : "+op1.getsigned());
		System.out.println(" ");
		
		op2 = register[index2];
		//prmoting the registers and index to the user to help in unit testing verification.
		System.out.println(" ");
		System.out.println("longword in register2 : "+op2.toString()); 
		System.out.println(" ");
		System.out.println("signedvalue in register2 : "+op2.getsigned());
		
		}
			
		
	}
	
	//method execute : excecutes the given operation. 
	void execute()
	{
		//if the opcode is 0000 we exit the method as we prompted in decode method.
		if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			return;
		}
		//if the opcode is 0001 we exit the method as we prompted in decode method.
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == true)
		{
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			//calls the compare method
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == true && opcode[3].getValue() == false)
		{
			//calls the stack method
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
//			if(branch().getValue())
//			{
//				PC = rippleAdder.add(PC, currentInstruction.leftshift(7).rightshift(22));
//				return;
//			}
			return;
			
		}
		//if the opcode is 0010  and ends with 0 or 1we exit the method as we prompted in decode method.
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(31).getValue() == false))
		{
			
			return;
		}
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(31).getValue() == true))
		{
			return;
		}
		else //else performs natural opcode method
		{
			result = Alu.doOp(opcode, op1, op2); // stores the calculated operation on both the given op1 and op2 and returns the longword.
		}
		
	
	}

	//store method : stores the result in the register
    void store()
	{
    	//if the opcode is 0000 we exit the method as we prompted in decode method.
		if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			return;
		}
		//if the opcode is 0001 we exit the method as we prompted in decode method.
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == true)
		{
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == false)
		{
			//calls the compare method
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == false && opcode[3].getValue() == true)
		{
			return;
		}
		else if(opcode[0].getValue() == false && opcode[1].getValue() == true  && opcode[2].getValue() == true && opcode[3].getValue() == false)
		{
			//calls the stack method
			return;
		}
		//if the opcode is 0010 or 0 or 1 we exit the method as we prompted in decode method.
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(31).getValue() == false))
		{
			return;
		}
		else if((opcode[0].getValue() == false && opcode[1].getValue() == false  && opcode[2].getValue() == true && opcode[3].getValue() == false) && (currentInstruction.getbit(31).getValue() == true))
		{
			return;
		}
		else //else perfroms normal result manipulating the registers
		{
			int result_index = currentInstruction.leftshift(12).rightshift(28).getsigned(); // gets the last 4 bits of the longword which gives the index of the last longowrd.
			register[result_index] = result; // stores the obtained in the register
			System.out.println("resulting longword: " + result.toString());
			System.out.println(" ");
			System.out.println("signed value of result: " + result.getsigned());

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
		}
	
	} 
	
    
    //move method: movers the registers as sent in the code.
	void move()
	{
		// index 1 comes from the 2nd 4 bits of the given longword where we shift left by 19 and right by 27 making the 4 bits as the last 4 indexes of longword.
		// 0001 0010 0000 1010 0000 0000 0000 0000 
		int index = (int) currentInstruction.leftshift(4).rightshift(28).getunsigned(); 
		
		//prompts the user to unit testing verification
		System.out.println("given index to move: " + index); 
		System.out.println("register currently:" + register[index].toString());
		System.out.println();
		
		//is negative to identify that is the prompted value is negative or not to fill the longword.
		boolean isnegative = currentInstruction.leftshift(8).getbit(0).getValue();
		//setting the result to figure out the manipulation of registers.
		result = currentInstruction.leftshift(8).rightshift(24);
		
		if(isnegative) //if the given is negative
		{
			Longword returner = new Longword(-1);
			//fill the array with all 1 apart from the obtained bits
			for(int i = 23; i< 32; i++)
			{
				returner.setBit(i, result.getbit(i));
			}
//			System.out.println(returner.toString());
			register[index] = returner;	
			//prompt the users obtained
			System.out.println("current register: "+ returner.toString());
			System.out.println();
			System.out.println();
			System.out.println();
			
		}
		else
		{
			Longword returner = new Longword(0);
			//fill the array with all 0 apart from the obtained bits
			for(int i = 23; i< 32; i++)
			{
				returner.setBit(i, result.getbit(i));
			}
//			System.out.println(returner.toString());
			register[index] = returner;	
			//prompt the users obtained
			System.out.println("current register: "+ returner.toString());
			System.out.println();
			System.out.println();
			System.out.println("edited in the register at " + index);
		}
		
	}	
	
	
	void compare()
	{
		Longword register1; //register 1 to store register
		Longword register2; //register 2 to store register 
		int index1 = currentInstruction.leftshift(8).rightshift(28).getsigned(); //given index1
		int index2 = currentInstruction.leftshift(12).rightshift(28).getsigned(); //given index2
		register1 = register[index1]; //  register reteival	1
//		System.out.println(index1); 
		register2 = register[index2]; // register retreival 2
//		System.out.println(index2); 
		// prompt the user the about the compare result
		System.out.println("compare  " + rippleAdder.sub(register1, register2));
		 
		//if the sub gives less value than 0 then its less than given 
		if(rippleAdder.sub(register1, register2).getsigned() > 0)
		{
			compare_bit[0] = new bit(true);
			compare_bit[1] = new bit(false);
			System.out.println("result : greater");
			System.out.println();
			
		}
		//if the sub gives greater value than 0 then its greater than given 
		else if(rippleAdder.sub(register1, register2).getsigned() < 0) 
		{
			compare_bit[0] = new bit(false);
			compare_bit[1] = new bit(false);
			System.out.println("result : less than");
			System.out.println();
		}
		//if the sub gives equal to 0 then given are equal
		else if(rippleAdder.sub(register1, register2).getsigned() == 0)
		{
			compare_bit[0] = new bit(true);
			compare_bit[1] = new bit(true);
			System.out.println("result : equal");
			System.out.println();
		}
		//else it renders greater than equal 
		else 
		{
			compare_bit[0] = new bit(false);
			compare_bit[1] = new bit(true);
			System.out.println("result : greater than or equal");
			System.out.println();
		}
	}
	
	
	//branch method to check the  branch code and say should we add to 
	bit branch()
	{
		
		if(compare_bit[1] == null) // if there isnt compare before then we return direct false.
		{
			System.out.println("No previous compare");
			return new bit(false);
		}
		
		// cc - 11 , 10, 
		bit[] cc = new bit[2];
		
		cc[0] = currentInstruction.leftshift(4).rightshift(30).getbit(30);
		cc[1] = currentInstruction.leftshift(4).rightshift(30).getbit(31);
		
		//if equals , greater
		//direct compasrision for greater, equal and less 
		if(cc[0].getValue() == compare_bit[0].getValue() && cc[1].getValue() == compare_bit[1].getValue())
		{
			return new bit(true);//if that the result then return true
		}
		//if greater than equal
		else if ((cc[0].getValue() == new bit(false).getValue() && cc[1].getValue() == new bit(true).getValue()) && ((compare_bit[0].getValue() == new bit(true).getValue() && compare_bit[0].getValue() == new bit(false).getValue()) || (compare_bit[0].getValue() == new bit(true).getValue() && compare_bit[0].getValue() == new bit(true).getValue())))
		{
			return new bit(true);//if that the result then return true
		}
		//if not equal
		else if((cc[0].getValue() == false && cc[1].getValue() == false) && ((compare_bit[0].getValue() != true || compare_bit[1].getValue() != true)))
		{
			return new bit(true); //if that the result then return true
		}
		else
		{
			return new bit(false);//if that the result then return false
		}
	
	}
	
	// stack 
	void stackoperation() throws Exception
	{
		Longword call = currentInstruction.leftshift(4).rightshift(30);//specially for 10 since the next coming bits are arbitary.
		Longword stack_instruction = currentInstruction.leftshift(4).rightshift(28); //takes the stack instruction indicating push pop return 
		System.out.println("stack instruction : " + stack_instruction);
		//for call 
		if(call.getbit(30).getValue() == new bit(true).getValue() && call.getbit(31).getValue() == new bit(false).getValue()) // if call
		{
			System.out.println("-------------------call------------------------------------");
			callindex = currentInstruction.leftshift(6).rightshift(22).getsigned();	  //takes the jump index
			member_memory.write(StackPointer, PC); //writes to the stack
			StackPointer = rippleAdder.sub(StackPointer, new Longword(32));  // moves stack pointer
			PC = rippleAdder.add(PC, new Longword((callindex*8)-16));  // jumps the pc value
		}
		// if push
		else if(stack_instruction.getbit(28).getValue() == new bit(false).getValue() && stack_instruction.getbit(29).getValue() == new bit(false).getValue()  && stack_instruction.getbit(30).getValue() == new bit(false).getValue()  && stack_instruction.getbit(31).getValue() == new bit(false).getValue())
		{
			 System.out.println("----------------------------push------------------------------");
			int given_index = currentInstruction.leftshift(12).rightshift(28).getsigned(); //takes R index
			Longword given = register[given_index]; // retrieves the value of register
			member_memory.write(StackPointer, given); //writes to the stack
			StackPointer = rippleAdder.sub(StackPointer, new Longword(32));  // moves stack pointer
		}
		else if(stack_instruction.getbit(28).getValue() == new bit(false).getValue() && stack_instruction.getbit(29).getValue() == new bit(true).getValue()  && stack_instruction.getbit(30).getValue() == new bit(false).getValue()  && stack_instruction.getbit(31).getValue() == new bit(false).getValue())
		{
			System.out.println("----------------------------pop---------------------------------");
			int given_index = currentInstruction.leftshift(12).rightshift(28).getsigned();  //takes R index
			StackPointer = rippleAdder.add(StackPointer, new Longword(32)); // moves stack pointer
			register[given_index] = member_memory.read(StackPointer);// retrieves the value of register
			System.out.println("edited register "+given_index+": "+register[given_index]);
		}
		else if(stack_instruction.getbit(28).getValue() == new bit(true).getValue() && stack_instruction.getbit(29).getValue() == new bit(true).getValue()  && stack_instruction.getbit(30).getValue() == new bit(false).getValue()  && stack_instruction.getbit(31).getValue() == new bit(false).getValue())
		{
			System.out.println("---------------------------return--------------------------------");
			PC = member_memory.read(rippleAdder.add(new Longword(32), StackPointer)); //gets the skiped index of the PC and gets it back
		}
	}
	
	
	
	// interrupt calls for printing longword and memeory to the screen.
	//printlongword : on the opcode of 0010 
    void printLongword()
	{
    	System.out.println();
    	System.out.println("----------------------whole register--------------------------- ");
		for(int i = 0; i<register.length; i++) //reads all the registers and prints the registers 
		{
			System.out.println(register[i].toString());
			System.out.println();
		}
		System.out.println();
	}
	
  //printlongword : on the opcode of 0010 and end with 1
    void printmemory() throws Exception
	{
    	System.out.println();
    	System.out.println("----------------------whole memory--------------------------- ");

		for(int i = 0; i<256; i++) //reads all the memory and prints the memory 
		{
			Longword temp = new Longword(i);
			System.out.println(member_memory.read(temp)); //every longword address will print 32 bits so we got 256*32 
			System.out.println();
		}
		System.out.println();
	}
	
	//preload: fills the register and memory 
    
	void preload(String[] filler) throws Exception
	{
		char[] ch; //creates a charated array to read through the string and fill the longword
		Longword returner = new Longword(0); //empty longword
		int overall_len_check = 0; //overall check as when we fill 256 overall as every fill will occupy 32
		
		//if the given have odd number lengths such to handle null during i=i+2
		if(filler.length % 2 == 1)
		{
			String[] filler1 = new String[filler.length+1];
			filler1 = Arrays.copyOfRange(filler,0,filler.length+1);
			
			//loops over the available strings and checks fills the memeory
			
			for(int i = 0; i <= filler1.length-2; i = i+2)
			{
				 if(filler1[i+1] == null)
				 {
					 filler1[i+1] = "0000000000000000";
				 }
				 String given = filler1[i]+filler1[i+1]; //pairing up the array for 32 bits
				 ch = given.toCharArray(); //converts it to the char array
				 for(int j = 0; j < ch.length; j++) //runs through the char array
				 {
					 if(ch[j] == '1')
					 { 
						 returner.setBit(j, new bit(true)); //if 1 the we fill true
					 } 
					 else if(ch[j] == '0')
					 {
						 returner.setBit(j, new bit(false)); //else it is false
					 }
					 else
					 {
						 continue; //if null we fill with 0 anyway
					 }
				 }
				 
				 if(overall_len_check <= 256)
				 {
					 member_memory.write(new Longword(overall_len_check), returner);  // if the current index is less than 256 then it is good to fill else we wont
					 overall_len_check +=32; //increment by 32 till 256
				 }
			}
		}
		else
		{
			
			//loops over the available strings and checks fills the memeory
			
			for(int i = 0; i <= filler.length-2; i = i+2)
			{
				 if(filler[i+1] == null)
				 {
					 filler[i+1] = "0000000000000000";
				 }
				 String given = filler[i]+filler[i+1]; //pairing up the array for 32 bits
//				 System.out.println(given);
				 ch = given.toCharArray(); //converts it to the char array
				 for(int j = 0; j < ch.length; j++) //runs through the char array
				 {
					 if(ch[j] == '1')
					 { 
						 returner.setBit(j, new bit(true)); //if 1 the we fill true
					 } 
					 else if(ch[j] == '0')
					 {
						 returner.setBit(j, new bit(false)); //else it is false
					 }
					 else
					 {
						 continue; //if null we fill with 0 anyway
					 }
				 }
				 
				 if(overall_len_check <= 256)
				 {
					 member_memory.write(new Longword(overall_len_check), returner);  // if the current index is less than 256 then it is good to fill else we wont
					 overall_len_check +=32; //increment by 32 till 256
				 }
			}
		}
		
			
	}

	
	
	//fillregister: fills the register the values, and make the it available for swaps and edits
	void fillregister(int[] filler)
	{
		for(int i = 0; i<filler.length; i++)
		{
			register[i] = new Longword(filler[i]); // adds the obtained valies to the registers as longwords.
		}
	}
		
//	public static void main(String[] args)
//	{
//			Longword setter = new Longword(0);
//			
//			setter.setBit(2, new bit(true));
//			setter.setBit(3, new bit(true));
//			
//			setter.setBit(31 , new bit(true));
//			
//	}

}
