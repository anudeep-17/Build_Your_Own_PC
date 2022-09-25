package assignment5;

public class Computer 
{
    bit bool_check = new bit(false); //setting initial value of the computer as not working == false.
	
   //private memory member 
    private Memory member_memory = new Memory();
    
	void run()
	{
		//loop to call the methdos
		while(bool_check.getValue())
		{
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	//method fetch
	void fetch()
	{
		
	}
	
	//method decode
	void decode()
	{
		
	}
	
	//method execute
	void execute()
	{
		
	}

	//store method
	void store()
	{
		
	}

}
