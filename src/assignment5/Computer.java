package assignment5;

public class Computer 
{
    bit bool_check = new bit(false);
	
   private Memory member_memory = new Memory();
    
	void run()
	{
		while(bool_check.getValue())
		{
			fetch();
			decode();
			execute();
			store();
		}
	}
	
	void fetch()
	{
		
	}
	
	void decode()
	{
		
	}
	
	void execute()
	{
		
	}

	void store()
	{
		
	}

}
