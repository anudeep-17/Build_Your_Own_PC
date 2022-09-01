package assignment2;

public class Longword 
{
	
	bit[] longword = new bit[32]; 
	
	public Longword()
	{
		
	}
	
	public Longword(int i, bit bit)
	{
		this.longword[i] = bit;
	}
	
	bit getbit(int i)
	{
		return longword[i];
	}
	
	void setBit(int i, bit value)
	{
		longword[i] = value;
	}
	
	Longword and(Longword Other)
	{
		Longword returner = new Longword();
		
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].and(Other.getbit(i)));
		}
		return returner;
	}
	
	Longword or(Longword Other)
	{
		Longword returner = new Longword();
		
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].or(Other.getbit(i)));
		}
		return returner;
	}
	
	Longword xor(Longword Other)
	{
		Longword returner = new Longword();
		
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].xor(Other.getbit(i)));
		}
		return returner;
	}
	
	Longword not()
	{
		Longword returner = new Longword();
		
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].not());
		}
		return returner;
	}
	
	Longword rightshift(int amount)
	{
		Longword returner = new Longword();
		
		for(int i = 0; i < amount; i++)
		{
			returner.setBit(i, new bit(false));
		}
		
		int counter = 0; 
		
		for(int i = amount; i<32; i++)
		{
			returner.setBit(i, longword[counter]);
			counter++;
		}
		
		return returner;
	}
	
	Longword leftshift(int amount)
	{
		Longword returner = new Longword();
		
		for(int i = 0; i<(32-amount); i++)
		{
			returner.setBit(i, longword[i]);
			
		}
		
		for(int i = (32-amount); i<32; i++)
		{
			returner.setBit(i, new bit(false));
		}
		
		return returner;
	}
	
	
	@Override
	public String toString()
	{
		String returner = "";
		for(int i = 0; i<32; i++)
		{
			if(i == 31)
			{
				returner += longword[i].toString()+" ";
			}
			else
			{
				returner += longword[i].toString()+", ";
			}
		}
		return returner;
	}
	
	long getunsigned()
	{
		long returner = 0;
		int j = 0; 
		
		for(int i = 31; i > 0; i--)
		{
			int tracker = 0;
			
			if(longword[i].getValue())
			{
				tracker = 1;
			}
			else
			{
				tracker = 0;
			}
			
			returner += tracker*Math.pow(2, j);
			j++;
		}
		return returner;
	}
	
	int getsigned()
	{
		int returner = 0;
		int j = 0; 
		
		for(int i = 31; i > 0; i--)
		{
			int tracker = 0;
			
			if(longword[i].getValue())
			{
				tracker = 1;
			}
			else
			{
				tracker = 0;
			}
			
			returner += tracker*Math.pow(2, j);
			j++;
		}
		return returner;
	}
	
	
	
	void copy(Longword other)
	{
		for(int i = 0; i<32; i++)
		{
			longword[i] = other.getbit(i);
		}
	}
	
	void set(int value)
	{
		int calculation = 0;
		for(int i = 31; i >=0; i--)
		{
			calculation = value%2;
			if(calculation == 0)
			{
				longword[i] = new bit(false);
			}
			else
			{
				longword[i] = new bit(true);
			}
			value = value/2;
		}
	}
	
	

}
