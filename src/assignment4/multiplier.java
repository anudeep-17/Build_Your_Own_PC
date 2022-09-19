package assignment4;

public class multiplier 
{
	//multiply method: takes 2 longwords and multiplies the longowrds 
	public static Longword multiply(Longword a, Longword b)
	{
		Longword returner = new Longword(); //initializing the returner longword to store the added result of the longword.
		int counter = 0; //check the multiplicator position.
		for(int i = 31; i >= 0; i--) //loops over the bits value and compares the two word to return the value. 
		{
			 //creates a new temp longword that will be filled on every iteration of multiplication.
			Longword temp = new Longword();
			
			//loops over the longword and sets the but appropriates according the multiplicative rules of bits.
			for(int j = 31; j >= 0; j--)
			{

				//------multiplication rules-----------
				// 1*1 = 1
				//1*0 = 0
				//0*1=0
				//0*0=0  
				
				if(a.getbit(j).and(b.getbit(i)).getValue()) // if the input is 1 and 1 it puts 1 in the longword
				{
					temp.setBit(j, new bit(true)); // sets in the temp
				}
				else
				{
					temp.setBit(j, new bit(false)); // else it sets to false on anycase in the temp.
				}
			}
			//no we do the leftshit according the digit of multiplication.
			temp = temp.leftshift(counter);
			counter++; // updates the index of multiplicator.
			returner = rippleAdder.add(returner, temp); //adds to the returner and and stores in every iteration. 
		}
		return returner; // returns the result of multiplied value. 
	}

}
