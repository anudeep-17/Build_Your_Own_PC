package assignment6;

public class rippleAdder 
{
	//add method: this is the method to add two longwords and returns the addition value 
	public static Longword add(Longword a, Longword b)
	{
		Longword returner = new Longword(); //initializing the returner longword to store the added result of the longword.
		boolean carry = false; //this is the boolean carrier that will have the data of carrier boolean value.
		for(int i = 31; i >= 0; i--) //loops over the bits value and compares the two word to return the value. 
		{
			if(a.getbit(i).and(b.getbit(i)).getValue()) // if both are true 
			{
					if(carry) // if the carrier is  also true its 1+1 = 0 and 1+0 = 1 from the carrier and the carry is still 1 
					{
						returner.setBit(i, new bit(true)); // so we set the new returner bit to 1 
						carry = true; // set the carrier to true.
					}
					else 
					{
						returner.setBit(i, new bit(false));	 //else we will set the data to false
						carry = true; // and carry to true. 
					}
					
			}
			else if (a.getbit(i).or(b.getbit(i)).getValue()) //else if one of them is true
			{
				if(carry) // if the carry is true which means it s 1+0 or 0+1 and then 1 being added to it so 
				{
					returner.setBit(i, new bit(false)); //the resultant bit is false and carry stays true.
					carry = true; // carries true 
				}
				else
				{
					returner.setBit(i, new bit(true)); //else it returns bit to true as 1+0 or 0+1
					carry = false;//and there is nothing carried so its false
					
				}
			}
			else
			{  //else if its 0+0 then it will have the value carried stored in it 
				returner.setBit(i, new bit(carry));	
				carry = false; //and nothing will be carried so technically its false.
			}
				
		}
		
		return returner; //we return the new longword.
	}
	
	
	//sub method: this is takes two longwords and then 
	public static Longword sub(Longword a, Longword b)
	{
		Longword negated = b.not(); // creating a new long word that has the negated values of b and make it 2's complement by adding 1 at the end.
		
		for(int i = 31; i >= 0; i--) 
		{
			//when we add 1+1 in the bits it results 0 and carries like 11+1 = 110
			if(negated.getbit(i).getValue()) 
			{
				negated.setBit(i, new bit (false)); // until we see the true we set it to false and we break once it is false and we set it to true. 
			}
			else
			{
				negated.setBit(i, new bit (true)); 
				break; // once we carry the 1 we break it . 
			}
			
		}
		
		return add(a,negated); //and now we add the the first value to the negated second value making it a-b 
	}

}
