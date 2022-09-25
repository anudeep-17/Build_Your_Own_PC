package assignment5;

public class Memory 
{
	static bit[] memory_storage = new bit[8192]; //bit storage of the 8192 bits which is technically the 1024 bytes
	
	public Memory() // constructor of the class
	{
			for(int j = 0; j< 8192; j++ )
			{
				memory_storage[j] = new bit(false); // fills empty memory 
			}
	}
	
	//read: reads the data from mentioned address index
	public static Longword read(Longword address) throws Exception
	{
		
		if(address.getsigned() > (8192-32))
		{ 
			throw new Exception("over the radar of 32... cant return a longword"); //throws exception ig they move close to the end by 31
		}
		Longword returner = new Longword();
		 // creates a new longword to fill
		int tempcheck = address.getsigned(); //takes the longword signed value.
		int counter = 0; // counter for the 32 counter in filling the data
		
		
		//running a loop over the given address for the next 32 bits and works on filling the longword.
		for(int i = tempcheck; i < (tempcheck)+32; i++ )
		{
			returner.setBit(counter, memory_storage[i]); //returner is set with the data 
			counter++; //counter is making it move ahead in the pointers
		}
		
		return returner; // returns Longword
	}
	
	//write: writes the Longword data to the memory
	
	public static void write(Longword address, Longword value) throws Exception
	{
		if(address.getsigned() > (8192-32)) 
		{ 
			throw new Exception("over the radar of 32... cant return a longword");//throws exception ig they move close to the end by 31
		}
		
		int tempcheck = address.getsigned(); //gets the value of the address.
		int counter = 0;  // counter for the 32 counter in filling the data

		//running a loop over the given address for the next 32 bits and works on filling the memory
		for(int i = tempcheck ; i<(tempcheck)+32; i++)
		{
			memory_storage[i] = value.getbit(counter);
			counter++; //counter is making it move ahead in the pointers
		}
		
	}
}
