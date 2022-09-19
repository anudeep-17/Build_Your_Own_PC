package assignment4;

import java.util.Arrays;

public class Alu 
{
	
	// method doOp: takes the operations of the bits, two longword then perform the operation accordingly
	public static Longword doOp(bit[] operations, Longword a, Longword b)
	{
		
		//uses the switch statementes to check the operations
		switch(Arrays.toString(operations))
		{
		case "[t, f, f, f]": return a.and(b); // if the input array have 1000 as the input then we perform and on the given longwords
		case "[t, f, f, t]": return a.or(b);// if the input array have 1001 as the input then we perform or on the given longwords
		case "[t, f, t, f]": return a.xor(b);// if the input array have 1010 as the input then we perform xor on the given longwords
		case "[t, f, t, t]": return a.not();// if the input array have 1011 as the input then we perform not on the given longword a
		case "[t, t, f, f]": return a.leftshift(b.getsigned());  // if the input array have 1100 as the input then we perform leftshift on the given longword a by signed value b
		case "[t, t, f, t]": return a.rightshift(b.getsigned()); // if the input array have 1101 as the input then we perform rightshift on the given longword a by signed value b
		case "[t, t, t, f]": return rippleAdder.add(a,b);// if the input array have 1110 as the input then we perform addition on the given longwords
		case "[t, t, t, t]": return rippleAdder.sub(a,b);// if the input array have 1111 as the input then we perform substraction on the given longwords
		case "[f, t, t, t]": return multiplier.multiply(a,b);// if the input array have 0111 as the input then we perform multiply on the given longwords
		default: return new Longword(); //if the the given operation is wrong then it gives a longword returning 0
		}
	}

}
