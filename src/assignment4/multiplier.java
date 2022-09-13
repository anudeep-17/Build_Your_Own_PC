package assignment4;

public class multiplier 
{
	
	public static Longword multiply(Longword a, Longword b)
	{
		Longword returner = new Longword(); //initializing the returner longword to store the added result of the longword.
		int counter = 0;
		for(int i = 31; i >= 0; i--) //loops over the bits value and compares the two word to return the value. 
		{
			Longword temp = new Longword();
			for(int j = 31; j >= 0; j--)
			{

				if(a.getbit(j).and(b.getbit(i)).getValue())
				{
					temp.setBit(j, new bit(true));
				}
				else
				{
					temp.setBit(j, new bit(false));
				}
			}
			temp = temp.leftshift(counter);
			counter++;
			returner = rippleAdder.add(returner, temp);
		}
		return returner;
	}

}
