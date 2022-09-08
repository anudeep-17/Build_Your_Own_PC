package assignment3;

public class rippleAdder 
{
	public static Longword add(Longword a, Longword b)
	{
		Longword returner = new Longword();
		boolean carry = false;
		for(int i = 31; i >= 0; i--)
		{
			if(a.getbit(i).and(b.getbit(i)).getValue())
			{
					if(carry)
					{
						returner.setBit(i, new bit(true));
						carry = true;
					}
					else
					{
						returner.setBit(i, new bit(false));	
						carry = true;
					}
					
			}
			else if (a.getbit(i).or(b.getbit(i)).getValue())
			{
				if(carry)
				{
					returner.setBit(i, new bit(false));
					carry = true;
				}
				else
				{
					returner.setBit(i, new bit(true));
					carry = false;
					
				}
			}
			else
			{
				returner.setBit(i, new bit(carry));	
				carry = false;
			}
				
		}
		
		return returner;
	}
	
	public static Longword sub(Longword a, Longword b)
	{
		Longword negated = b.not();
		
		for(int i = 31; i>=0; i--)
		{
			//when we add 1+1 in the bits it results 0 and carrys 1 like 11+1 = 110
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
		
		return add(a,negated);
	}

}
