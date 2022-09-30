package assignment6;

public class Longword 
{
	
	bit[] longword = new bit[32]; //creating a long word with 32 bits size -- standard size of long words
	
	//class consturctor
	public Longword()
	{
		for(int i = 0; i < 32 ; i++)
		{
			longword[i] = new bit(false); //initializes the long word as all false to make not encounter null pointer exception. 
		}
	}
	
	public Longword(int i)
	{
		this.set(i);
	}
	
	//------------------------------------------longword class methods--------------------------------------
	
	//get bit method: returns the bit at the given index value
	bit getbit(int i)
	{
		return longword[i];
	}
	
	
	//setbit method: sets the bit value at the index value given 
	void setBit(int i, bit value)
	{
		longword[i] = value; // assinging the array value to the given bit.
	}
	
	
	//and method: compares two longwords and returns a third longword with and operated.
	Longword and(Longword Other)
	{
		Longword returner = new Longword(); //creates a new longword to return
		
		
		//loops over the elements and fill the returning longword
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].and(Other.getbit(i))); //uses the bit operator and on the bits of first and second longword
		}
		return returner; //returns the longword.
	} 
	
	//or method: compares two longwords and returns a third longword with or operated.
	Longword or(Longword Other)
	{
		Longword returner = new Longword(); //creates a new longword to return

		//loops over the elements and fill the returning longword
		
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].or(Other.getbit(i)));//uses the bit operator and on the bits of first or second longword
		}
		return returner;//returns the longword.
	}
	
	//xor method: compares two longwords and returns a third longword with xor operated.
	Longword xor(Longword Other)
	{
		Longword returner = new Longword();//creates a new longword to return
		

		//loops over the elements and fill the returning longword
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].xor(Other.getbit(i)));//uses the bit operator and on the bits of first xor second longword
		}
		return returner;//returns the longword.
	}
	
	//not method: negate this longword, creating another
	Longword not()
	{
		Longword returner = new Longword();//creates a new longword to return
		
		//loops over the elements and fill the returning longword
		for(int i = 0; i<32; i++)
		{
			returner.setBit(i, longword[i].not());//uses the bit operator not on the elements.
		}
		return returner;//returns the longword.
	}
	
	//rightshift : rightshift this longword by amount bits, creating a new longword
	Longword rightshift(int amount)
	{
		Longword returner = new Longword();//creates a new long word.
		
		for(int i = 0; i < amount; i++)
		{
			returner.setBit(i, new bit(false)); //loops over the elements and fill zeros till the amount of rightshift 
		}
		
		int counter = 0; 
		
		
		for(int i = amount; i<32; i++)
		{
			returner.setBit(i, longword[counter]); //and later loops to fill the rest of the array
			counter++;
		}
		
		return returner; //returns the longword
	}
	
	
	//leftshift: leftshift this longword by amount bits, creating a new longword
	Longword leftshift(int amount)
	{
		Longword returner = new Longword();//creates a new long word.
		int amounttrack = amount;
		for(int i = 0; i < (32-amounttrack); i++)
		{
			returner.setBit(i, longword[amount]);//loops over the elements and fill zeros till the amount of leftshift 
			amount++;
		}
		
		for(int i = (32-amounttrack); i<32; i++)
		{
			returner.setBit(i, new bit(false));//and later loops to fill the rest of the array
		}
		
		return returner;//returns the longword
	}
	
	//to string: returns a comma separated string of t's and f's: "t,t,t,t,t (etcetera)" for example
	@Override
	public String toString()
	{
		String returner = "";//empty string declaration
		//loops over the longword and fills the string
		for(int i = 0; i<32; i++)
		{
			if(i == 31)
			{
				returner += longword[i].toString()+" "; //if its a last word we dont print the , 
			} 
			else
			{
				returner += longword[i].toString()+", "; //else we seperate them by comma and print the long words.
			}
		}
		return returner; // returns the string 
	}
	
	
	//getunsigned: returns the value of long word with resepective to long 
	
	long getunsigned()
	{
		long returner = 0; //creating a long word and assigning 0 to it.
		
		//looping over the array in reverse to multiply 2 to get the value 
		for(int i = 31; i >= 0; i--)
		{
			int tracker = 0; // tracekr to get the bit value 
			
			if(longword[i].getValue())
			{
				tracker = 1;
			}
			else
			{
				tracker = 0;
			}
			
			returner += tracker*Math.pow(2, (31-i));// multiply the bitvalue to the index value as power of 2 to get the long value 
		}
		return returner; //return the long word.
	}
	
	
	// getsigned: returns the value of this longword as an int
	int getsigned()
	{
		int returner = 0; //declaring a int to return the value of long word.
		
		//if the longword is negative we use the 2s complement method to find the number 
		if(longword[0].getValue())
		{
			//loops over the array and multiply the position with 2. 
			for(int i = 31; i >= 0 ; i--)
			{
				int tracker = 0; //using tracker to find the bit 
				 
				if(longword[i].not().getValue()) //using negated value of bit to get the 2s complement method implementation.
				{
					tracker = 1;
				}
				else
				{
					tracker = 0;
				}
				
				returner += tracker * Math.pow(2, (31-i)); //multiplies the tracker to position to the power of 2
			}
			return (returner+1)*-1; // multiplying and adding 1 to get the negative value as the implementation of negative bits by adding one at the end. 
		}
		
		else
		{ //else if it is positive. 
			for(int i = 31; i >= 0 ; i--)
			{
				int tracker = 0; //we check the tracker value 
				
				if(longword[i].getValue())
				{
					tracker = 1; //set the correct tracker value
				}
				else
				{
					tracker = 0;
				}
				 
				returner += tracker * Math.pow(2, (31-i)); //multiplies the tracker to position to the power of 2
			}
			return (returner);//and returns the int value. 
		}
		
	}

	//copies the values of the bits from another longword into this one
	void copy(Longword other)
	{
		//loops over the longwords and assign the values of the other to the given longword.
		for(int i = 0; i<32; i++)
		{
			longword[i] = other.getbit(i);
		}
	}
	
	//set the value of the bits of this longword (used for tests)
	void set(int value)
	{
		int calculation = 0;
		
		//if the value is negative. 
		if(value < 0)
		{
			for(int i = 31; i >= 0; i--)
			{
				calculation = value % 2;//we divide the value by 2 and set its remainder
				if(calculation == 0)
				{
					longword[i] = new bit(true); // negates the value and places in the array like true for 0 
				}
				else
				{
					longword[i] = new bit(false); // false for 1
				} 
				value = value/2; // and divide value by 2
			}
			//since it is negative we add 1 at the end of the value. 
			//adding 1 to the bits
			
			for(int i = 31; i>=0; i--)
			{
				//when we add 1+1 in the bits it results 0 and carrys 1 like 11+1 = 110
				if(longword[i].getValue()) 
				{
					longword[i]= new bit (false); // until we see the true we set it to false and we break once it is false and we set it to true. 
				}
				else
				{
					longword[i] = new bit(true);
					break; // once we carry the 1 we break it . 
				}
				
			}
		}
		
		//else it is positive its just taking remained of 2 and divide given value by 2 to get the results. 
		else 
		{
			for(int i = 31; i >= 0; i--)
			{
				calculation = value % 2; // calculate the remainder and set the value to the longword.
				if(calculation == 0)
				{
					longword[i] = new bit(false);
				}
				else
				{
					longword[i] = new bit(true);
				}
				value = value/2; //divide the value by 2 and set it to value to make it ready for next bit calculation. 
			}
		}
	
	}
	
	

}
