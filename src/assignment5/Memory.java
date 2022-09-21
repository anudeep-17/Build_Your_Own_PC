package assignment5;

public class Memory 
{
	static bit[] memory_storage = new bit[8192];
	
	public Memory()
	{
			for(int j = 0; j< 8192; j++ )
			{
				memory_storage[j] = new bit(false);
			}
	}
	
	public static Longword read(Longword address)
	{
		Longword returner = new Longword();
		int tempcheck = address.getsigned()*8;
		int counter = 0;
		for(int i = tempcheck; i < (tempcheck)+32; i++ )
		{
			returner.setBit(counter, memory_storage[i]);
			counter++;
		}
		
		return returner;
	}
	
	public static void write(Longword address, Longword value)
	{
		int tempcheck = address.getsigned()*8;
		int counter = 0;
		for(int i = tempcheck ; i<(tempcheck)+32; i++)
		{
			memory_storage[i] = value.getbit(counter);
			counter++;
		}
		
	}
}
