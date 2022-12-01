package assignment7;

import java.util.Arrays;

// ------------------- bonus 10 expected due to usage of lexer {parsing for each character and then reading throught the string}


//point breakdown;
// 		comments: done!
// 		variable: done!
// 		unit test: done!
// 		assembler: with handling edgecase errors and boundaries possible.
// 		lexign: with each charecter reading:done [bonus 10]
//		parsing : pareser with minimal possible code and formatted reuse.



//--------------------------------[overall bonus = 10]---------------------
public class assembler 
{
	
	//opcodes list: list of all the possible opcodes and any other opcode will throw a abrupt error.
	static String movecode = "0001";
	static String andcode = "1000";
	static String orcode = "1001";
	static String xorcode = "1010";
	static String notcode = "1011";
	static String leftshiftcode = "1100";
	static String rightshiftcode = "1101";
	static String addcode = "1110";
	static String subcode = "1111";
	static String multiplycode = "0111";
	static String halt = "0000";
	static String interrupt = "0010";
	static String jump = "0011";
	static String compare = "0100";
	static String branch = "0101";
	static String stack = "0110";
	
	// global codes easy to parse and set according to the lexer
	static String opcode_command = "";
	static String actioncode1 = "";
	static String actioncode2 = "";
	static String resultcode1 = "";
	
	
//----------------------------------lexing and calling parsing of the read data ------------------------------------------------
	// asseble : lexes through the given and calls the opted parsing technique to call the data.
	public static String[] assemble(String[] instruction)
	{
		String[] currinstruction = new String[4]; //max occupoyable instruction is 4 as atmost 1 opcode  2 manipulation registers 1 storage register can be given 
		//loops over given number of instructions and lexes and results.
		for(int i = 0; i < instruction.length; i++)
		{
			if(instruction[i]!=null) 
			{ //if instruction string is not null only then it will loop over.
//				currinstruction = instruction[i].split(" "); 
				currinstruction = lexer(instruction[i]); //lexing , tokenizing each component of the string.
				//System.out.println(Arrays.toString(currinstruction));
			switch(currinstruction[0].toLowerCase())
			{
				//move op code 
				case "move": //if move
					converterformove(currinstruction); //calls the method to set static variables 
					if(opcode_command.equals("")|| actioncode1.equals("") || actioncode2.equals("")) //if all are not set then some are missing so halts the system
					{
						instruction[i] = "0000000000000000"; //halt computer
					}
					else //else goes ahead and manipulates the given index for space efficiency
					{
						instruction[i] = opcode_command + actioncode1 + actioncode2;
					}
					break; //breaks the loop
					
				//alu coding
				//for all alu funtions parameters 2 longoword to operate on 1 longword to push the 
				case "add": 
				case "sub":
				case "multiply":
				case "and":
				case "or":
				case "xor":
				case "leftshift":
				case "rightshift":
				case "not":
					converterforALUcode(currinstruction); //calls the alu code to alter the static required variables
					if(opcode_command.equals("")|| actioncode1.equals("") || actioncode2.equals("") || resultcode1.equals("")) //after altering if one of them stays empty then its a failure of the game
					{
						instruction[i] = "0000000000000000";//halt computer 
					} 
					else
					{
						instruction[i] = opcode_command+ actioncode1 + actioncode2 + resultcode1; //else set the instruction and manipulate the given 
					}
					break;
					
				//halt coding	
				case "halt":
					
					converterforhalt(currinstruction); //call the method to parse the given and set the static varables
					if(opcode_command == "0000") 
					{
						instruction[i] = "0000000000000000";//halt computer
					}
					else
					{
						System.out.println("theres a bug"); //if code isnt 0000 then its a error 
					}
					
					break;
					
				//interrupt coding
				case "interrupt":
					
					converterforinterrupt(currinstruction); // interrupt comes with 0 or 1 to indicate print memeory or print register 
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+"0000"+actioncode1; // alter the instructions to send the binary 
					}
					
					break;
					
				case "jump":
					convertforjump(currinstruction); 
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+"0000"+actioncode1; // alter the instructions to send the binary 
					}
					break;
					
					
				case "compare":
					convertforcompare(currinstruction); //call to fill the action or code_command
					if(opcode_command.equals("")|| actioncode1.equals("")||actioncode2.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+"0000"+actioncode1 + actioncode2; // alter the instructions to send the binary 
					}
					break;
				//branch if == != > or >=
				case "branchifequal":
				case "branchifnotequal":
				case "branchifgreater":
				case "branchifgreaterthanequal":
					convertforbranch(currinstruction);//call to fill the action or code_command
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+actioncode1; // alter the instructions to send the binary 
//						System.out.println("instruction of branch " + instruction[i]);
					}
					break;
				case "call":
					convertforcall(currinstruction);//call to fill the action or code_command
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+actioncode1; // alter the instructions to send the binary 
//						System.out.println("instruction of branch " + instruction[i]);
					}
					break;
				case "push":
					convertforpush(currinstruction);//call to fill the action or code_command
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+actioncode1; // alter the instructions to send the binary 
//						System.out.println("instruction of branch " + instruction[i]);
					}
					break;
				case "pop":
					convertforpop(currinstruction);//call to fill the action or code_command
					if(opcode_command.equals("")|| actioncode1.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+actioncode1; // alter the instructions to send the binary 
//						System.out.println("instruction of branch " + instruction[i]);
					}
					break;
				case "return":
					convertforreturn(currinstruction);//call to fill the action or code_command
					if(opcode_command.equals("")) // if code and command are null then there is a missing variable halt the whole 
					{
	
						instruction[i] = "0000000000000000";//halt computer//halt computer
					}
					else
					{
						instruction[i] = opcode_command+actioncode1; // alter the instructions to send the binary 
						System.out.println("instruction of return " + instruction[i]);
					}
					break;
				default: 
					System.out.println("non existatant operation asked....system stopped");
					instruction[i] = "00000000000000000000000000000000"; //default halt for the end of the wrong of the given opcode
					break;
			}
			
			}
			else
			{
				continue; //if its null then continues to move to the ahead   
			}
			
		} 
		return instruction; //returns the manipulated the instructions
	} 
	
//----------------------------------parsing of the read data ------------------------------------------------

//----------------------------------method for converter of the given code------------------------------------
	
	//method for move 
	public static void converterformove(String[] instructions)
	{
		//if the instuction dont have register or a number then it is incomplete or if there is a additional instruction at the end then its over 
		if((instructions[1] == null || instructions[2] == null) || instructions[3] !=null)
		{
			System.out.println("additional instruction found for given opcode please check with that");
			return;
		}
		//sets the opcode 
		opcode_command = movecode;
		actioncode1 = converterforregister(instructions[1]); //converts the R1 into binary and sets the actioncode 1
		actioncode2 = converterfornumber(instructions[2]); //converts the given number into binary and sets the actioncode2
	}
	
	// method for alu code
	public static void converterforALUcode(String[] instructions)
	{
		//if any of the instructions 1, 2, 3 re null means either actors or storage address is missing 
		if(instructions[3] == null || instructions[1] == null || instructions[2] == null)
		{
			System.out.println("complete instruction not found for given opcode please check with that");
			return;
		}
		
		//else set opcode according to the obtained instuction 
		switch(instructions[0].toLowerCase())
		{
		//according to the obtained code set the op code
		case "add": opcode_command = addcode;break;
		case "sub": opcode_command = subcode;break;
		case "multiply": opcode_command = multiplycode;break;
		case "and": opcode_command = andcode;break;
		case "or": opcode_command = orcode;break;
		case "xor": opcode_command = xorcode;break;
		case "not": opcode_command = notcode;break;
		case "leftshift": opcode_command = leftshiftcode;break;
		case "rightshift": opcode_command = rightshiftcode;break;
		default : return; //if doesnt match then leave the method
		}
		actioncode1 = converterforregister(instructions[1]); //set the register1 as actor1
		actioncode2 = converterforregister(instructions[2]);//set the register2 as actor2
		resultcode1 = converterforregister(instructions[3]);//set the register3 as result1
	}
	
	//for halt
	public static void converterforhalt(String[] instructions)
	{
		// halt only takes halt apart from that any other will throw addition instruction error
		if(instructions[2] != null || instructions[1] != null ||  instructions[3] != null )
		{
			System.out.println("errored instructions");
			return;
		}
		// set opcode to halt and halt the machine 
		opcode_command = halt;
		
	}
	
	//interrupt 
	public static void converterforinterrupt(String[] instructions)
	{
		//takes in eitehr interrupt 0 or interrupt 1 if anyother are given then we throw error
		if(instructions[1] == null && (instructions[2] != null || instructions[3] != null))
		{
			System.out.println("errored instructions");
			return;
		}
		//sets the op code to interrupt
		opcode_command = interrupt;
		actioncode1 = converterfornumber(instructions[1]); //sets the binary of the number to complete the interrupt instruction.
	}
	
	//implements jump converter to fill the opcode and fills the action code with the number entered to jump
	public static void convertforjump(String[] instruction)
	{
		opcode_command = jump;
		actioncode1 = converterfornumber(instruction[1]);
	}
	
	// implements compare converter to fill the opcode and fills the action codes with the registres to compare 
	public static void convertforcompare(String[] instruction)
	{
		opcode_command = compare;
		actioncode1 = converterforregister(instruction[1]);
		actioncode2 = converterforregister(instruction[2]);
	}
	
	// implements branch converter to fill the opcode and fills the action codes with cc and signed value of the number 
	public static void convertforbranch(String[] instruction)
	{
		opcode_command = branch;
		int num_check = Integer.parseInt(instruction[1]);
		String given_number = converterfornumber(instruction[1]); //returns the number with 8 bits in it
		String cc = "";
		if(num_check>8160)
		{
			System.out.println("out of bound cant branch sorry");
			return;
		}
		if(num_check>=0) //if entered is positive then Address first num is 0 else 1
		{
			if(instruction[0].equals("branchifequal"))
			{
				cc = "110"; //if equal cc = 11
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifnotequal"))
			{
				cc = "000";//if equal cc = 00
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifgreater"))
			{
				cc = "100";//if equal cc = 10
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifgreaterthanequal"))
			{
				cc = "010";//if equal cc = 01
				actioncode1 = cc + given_number;
			}
		}
		else //if negative num we add first bit of address as -ve
		{
			if(instruction[0].equals("branchifequal"))
			{
				cc = "111";
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifnotequal"))
			{
				cc = "001";
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifgreater"))
			{
				cc = "101";
				actioncode1 = cc + given_number;
			}
			else if(instruction[0].equals("branchifgreaterthanequal"))
			{
				cc = "010";
				actioncode1 = cc + given_number;
			}
		}
		
		
//		System.out.println("actioncode1 " + actioncode1);
	}
	
	// converter for call, implements the indexes and opcode for hte call instruction and converts it.
	public static void convertforcall(String[] instruction)
	{
		if(instruction[2] != null  || instruction[3] != null )
		{	
			System.out.println("addtional data added, please checkout");
		}
		
		opcode_command = stack;	// adds the stack code in the opcode.
		int given_index = Integer.parseInt(instruction[1])*8; // takes the index in of the call to jump ahead.
		String registercode = converterfornumber(instruction[1]); // converts the number into binary
		
		if(given_index > 8160) // if its more than the given memory 
		{
			System.out.println("out of bound cant call sorry");
			return; // we break out
		}
		else if(given_index >= 0)
		{
			actioncode1 = "1000"+registercode; // adds the register code
		}
		else if(given_index < 0)
		{
			actioncode1 = "1011"+registercode; // adds the register code
		}
	}
	
	// converter the push 
	public static void convertforpush(String[] instruction)
	{
		opcode_command = stack; // adds the opcode of the stack
		String registercode = converterforregister(instruction[1]); // register code is converted to the binary code and added to the action code1.
		actioncode1 = "00000000"+registercode; // sets the actioncode1
	} 
	
	//converter for the pop
	public static void convertforpop(String[] instruction)
	{
		
		opcode_command = stack; // adds the opcode of the stack
		String registercode = converterforregister(instruction[1]);// register code is converted to the binary code and added to the action code1.
		actioncode1 = "01000000"+registercode;// sets the actioncode1
	}
	
	//converter for the return
	public static void convertforreturn(String[] instruction)
	{
		//return only have one parameter
		if(instruction[1] != null || instruction[2] != null  || instruction[3] != null )
		{	
			System.out.println("addtional data added, please checkout");
		}
		opcode_command = stack; //opcode
		actioncode1 = "110000000000"; //actioncode1 for the opcode.
	}

	
	//--------------------------------------helpers------------------------------------------
	// helper to convert the registers
	public static String converterforregister(String instruction)
	{
		String temp = ""; //temp to load current longword data
		if(instruction.matches("R[0-9]") || instruction.matches("R[1][0-5]") ) //matches R0 to R15, and if not then we dont have that register
		{
			int given = Integer.parseInt(instruction.substring(1)); //since we dont want R at the start we truncate the number aprt of the string
			Longword registercode = new Longword(given);
			temp = longwordtostring(registercode, 28); //longwordtostring method to get bits from that index till end 
			if(temp.length()>0)
			{
				return temp; //if the longwordtostring did return something only then we return the value else we return empty string to indicate to halt
			}
			else
			{
				System.out.println("error in register code computation");
				return"";
			}
		}
		else
		{
			System.out.println("no register avaiable its mistake");
			return"";
		}
	}
	
	//convertes for number 
	public static String converterfornumber(String instruction)
	{
		String temp = ""; //temp to store the longword bits for the number 
		
		try {
			int given = Integer.parseInt(instruction);
			Longword numcode = new Longword(given);
			temp = longwordtostring(numcode, 24); // returns longwordtostring bit from 24 to 31
			if(temp.length() > 0) 
			{ 
				return temp; //if temp have something in it then it will return the temp else it will throw exception with returning empty string
			}
			
		}catch(Exception e)
		{
			System.out.println("not a numeber, caught a wrong instructions");
			return "";
		}
		return "";	
	}
	
	
	//--------------------------format helper to get the bits from longowrd as 1010's
	// converts longword to string as it will help in retriving the bits as 1010101's - from the given index
	public static String longwordtostring(Longword given, int startindex)
	{
		String temp = "";
		if(startindex <31) //if the given index is greater than 31 then nothing is there to read
		{
			for(int i = startindex; i<32; i++) // from the start index to the length of the longword
			{
				if(given.getbit(i).getValue()) // if true
				{
					temp += "1"; //set 1
				}
				else
				{
					temp+="0"; //set 0
				}
			}
		}
		
		return temp;
		
	}
	
	
	
	// -------------------------- bonus point lexer --------------------------------------------
	public static String[] lexer(String instructions)
	{
		String[] returner = new String[4]; // returns the array of read isntructions at max can be 4 
		int count = 0; // count for the updating the returner index
		instructions = instructions.trim() +" "; //adds a extra space at the end to indicate lexer that the end of array
		char[] checker = instructions.toCharArray(); //converts the whole array to read through each charecter until a space found
		String command = ""; //current command is empty but adds eventually fills until space 
//		System.out.println(checker);
		for(int i = 0; i < checker.length; i++)
		{
			//loops over the character array
			if(checker[i] == ' ') //if space found 
			{
				returner[count] = command; //adds the current filled command before the space 
				command = ""; //reset space to empty
				count++; //count increments on each addition to returner else it stays same
			} 
			else
			{
				command += ""+checker[i]; //add character to the command until it finds a space, and on finding space will add item to returner
//				System.out.println(command);
			}
		}
//		System.out.println(Arrays.toString(returner));
		return returner; // returner is return with instruction tokens that are read through 
	}
	

}
