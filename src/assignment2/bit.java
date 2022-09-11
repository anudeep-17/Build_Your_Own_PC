package assignment2;

//class bit
public class bit 
{
	
	private boolean bitval; //boolean object to represent bit
	
	public bit()
	{
		//empty constructor
	}
	
	//parametered constructor 
	public bit(boolean bit_val)
	{
		this.bitval = bit_val; //setting the bit object to the passed value
	}
	
	
	//set method : sets value of the bit 
	void set(boolean value)
	{
		this.bitval = value; //sets the bit object to the value
	}
	
	
	//toggle method: changes the values from true to false or false to true
	void toggle()
	{
		//uses if and else to evaluate the value of bit object and negate the value
		if(bitval)
		{
			this.bitval = false; // negates the bit object value
		}
		else
		{
			this.bitval = true; // negates the bit object value
		}
	}
	
	
	//set method: sets the bit to true
	void set()
	{
		this.bitval = true; // sets the bit value to true
	}
	
	//clear method: sets the bit to false
	void clear()
	{
		this.bitval=false; //sets the bit value 
	}
	
	//getValue method: returns the current value
	boolean getValue()
	{
		return this.bitval; //return the value of bit object
	}
	
	
	//-----------------------------------------compare methods------------------------------------
	
	//and method: takes a boolean bit as parameter  and compares to the bitval object mimicing the and operator and return bit result
	
	//-------------------and truth table ---------------------------------
	//bitval      other      result
	// T           T           T
	// T           F           F
	// F           T           F
	// F           F           F
	
	bit and(bit Other)
	{
	//using if condition to figure out the output
		if(this.bitval) // if the bitval obj is true
		{
			if(Other.getValue()) //and if the other object is true too then we return new bit true
			{
				return new bit(true);
			}	
			else
			{
				return new bit(false); //else if the other object is false then its a false 
			}
		}
		
		else
		{ 
			if(Other.getValue()) // if the bitval is false and other is true then also it return false as and need T and T to return true
			{
				return new bit(false);
			}
			else
			{
				return new bit(false); //return false if both the objects are false
			}
		}
	}
	
	
	//and method: takes a boolean bit as parameter and compares to the bitval object mimicing the or operator and return bit result
	
		//-------------------and truth table ---------------------------------
		//bitval      other      result
		// T           T           T
		// T           F           T
		// F           T           T
		// F           F           F
	
	
	bit or (bit Other)
	{
		
		//with the given truth table if the bit val is true
		if(this.bitval)
		{
			if(Other.getValue()) // if the other is also true then its a true
			{
				return new bit(true);
			}	
			else
			{
				return new bit(true); // else since the bitval is true it returns true
			}
		}
		
		else
		{
			if(Other.getValue()) // else if the bitval is false and other is true then 
			{
				return new bit(true); //we return true
			}
			else
			{
				return new bit(false); // else if both are false then its a false.
			}
		}
	}
	
	
	// not method : negates the bitval object value 
	
	//-------------------and truth table ---------------------------------
			//bitval     result
			// T           F           
			// F 		   T
	
	
	bit not()
	{
		if(this.bitval) //if bitval is true return false else return true.
		{
			return new bit(false);
		}
		else
		{
			return new bit(true);
		}
	}
	
	
	//xor method: performs xor on two bits and returns a new bit set to the result
	
	//-------------------and truth table ---------------------------------
			//bitval      other      result
			// T           T           F
			// T           F           T
			// F           T           T
			// F           F           F
		
	
	
	bit xor(bit Other)
	{
		if(bitval) // will deal if the bitval is true and works 
		{
			if(Other.getValue()) // if other value is true then according to truth table it is false
			{
				return new bit(false);
			}	
			else
			{
				return new bit(true); //else it is true
			} 
		}
		
		else
		{
			if(Other.getValue()) //similarly if bitval is false and other is true then it is true else false.
			{
				return new bit(true);
			}
			else
			{
				return new bit(false);
			}
		}
	}
	
	
	// toString method: method to return string t if true and f if false
	public String toString()
	{
		if(this.bitval) //if true returns t else f
		{
			return "t";
		}
		else
		{
			return "f";
		}
	}
	

}
