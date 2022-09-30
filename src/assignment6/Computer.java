package assignment6;

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
    
    //op1 and op2 for the the addresses to do the operation on.
    static Longword op1 = new Longword();
    static Longword op2 = new Longword();
    
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
			bool_check.set(false); // sets the boolean value to false for the trail run.
		}
	}
	
	//method fetch : fetches the data from memory to read the operations
	static void fetch() throws Exception
	{
		currentInstruction = member_memory.read(PC); // sets the current instructions by taking the longword from the memeory.
		PC = rippleAdder.add(PC, new Longword(2));	//increments the PC value
	}
	
	
	//decode method: decodes the last 16 bit values and sets the objects accordingly to perfrom the stuff.
	static void decode()
	{
		//opcode will set the 4 bit operations with the values in the bit, so the given format is
		// [4 bits for operation] [4 bits for the first long word address] [4 bits second long word address] [4 bits for the resulting longword address]  
		// so we divide the given 4 bits and store them in the opcode, 
		// here we shifting in such a way that the resulting longword have the first 4 bits as the last 4 indexes.
		opcode = bit.arraybit(currentInstruction.rightshift(12).getbit(28).getValue(), currentInstruction.rightshift(12).getbit(29).getValue(), currentInstruction.rightshift(12).getbit(30).getValue(), currentInstruction.rightshift(12).getbit(31).getValue());
		// index 1 comes from the 2nd 4 bits of the given longword where we shift left by 19 and right by 27 making the 4 bits as the last 4 indexes of longword.
		int index1 = currentInstruction.leftshift(19).rightshift(27).getsigned();
		// index 1 comes from the 3rd 4 bits of the given longword where we shift left by 23 and right by 27 making the 4 bits as the last 4 indexes of longword.
		int index2 = currentInstruction.leftshift(23).rightshift(27).getsigned();
		//getting the calculated indexes from the register
		op1 = register[index1];
		op2 = register[index2];
	}
	
	//method execute : excecutes the given operation. 
	static void execute()
	{
		result = Alu.doOp(opcode, op1, op2); // stores the calculated operation on both the given op1 and op2 and returns the longword.
	}

	//store method : stores the result in the register
	static void store()
	{
		int result_index = currentInstruction.leftshift(27).rightshift(27).getsigned(); // gets the last 4 bits of the longword which gives the index of the last longowrd.
		register[result_index] = result; // stores the obtained in the register
		System.out.println(result.getsigned());
	} 
	

}
