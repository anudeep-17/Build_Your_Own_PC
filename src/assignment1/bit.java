package assignment1;

public class bit 
{
	
	private boolean bitval;
	
	public bit()
	{
		//empty constructor
	}
	
	
	public bit(boolean bit_val)
	{
		this.bitval = bit_val;
	}
	
	
	
	void set(boolean value)
	{
		this.bitval = value;
	}
	
	
	
	void toggle()
	{
		if(bitval)
		{
			this.bitval = false;
		}
		else
		{
			this.bitval = true;
		}
	}
	
	
	
	void set()
	{
		this.bitval = true;
	}
	
	
	void clear()
	{
		this.bitval=false;
	}
	
	
	boolean getValue()
	{
		return this.bitval;
	}
	
	
	
	bit and(bit Other)
	{
		if(this.bitval)
		{
			if(Other.getValue())
			{
				return new bit(true);
			}	
			else
			{
				return new bit(false);
			}
		}
		
		else
		{
			if(Other.getValue())
			{
				return new bit(false);
			}
			else
			{
				return new bit(false);
			}
		}
	}
	
	
	bit or (bit Other)
	{
		if(this.bitval)
		{
			if(Other.getValue())
			{
				return new bit(true);
			}	
			else
			{
				return new bit(true);
			}
		}
		
		else
		{
			if(Other.getValue())
			{
				return new bit(true);
			}
			else
			{
				return new bit(false);
			}
		}
	}
	
	bit not()
	{
		if(this.bitval)
		{
			return new bit(false);
		}
		else
		{
			return new bit(true);
		}
	}
	
	
	bit xor(bit Other)
	{
		if(bitval)
		{
			if(Other.getValue())
			{
				return new bit(false);
			}	
			else
			{
				return new bit(true);
			}
		}
		
		else
		{
			if(Other.getValue())
			{
				return new bit(true);
			}
			else
			{
				return new bit(false);
			}
		}
	}
	
	
	public String toString()
	{
		if(this.bitval)
		{
			return "t";
		}
		else
		{
			return "f";
		}
	}
	

}
