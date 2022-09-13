package assignment4;

import java.util.Arrays;

public class Alu 
{
	
	public static Longword doOp(bit[] operations, Longword a, Longword b)
	{
		
		switch(Arrays.toString(operations))
		{
		case "[t, f, f, f]": return a.and(b);
		case "[t, f, f, t]": return a.or(b);
		case "[t, f, t, f]": return a.xor(b);
		case "[t, f, t, t]": return a.not();
		case "[t, t, f, f]": return a.leftshift(b.getsigned()); 
		case "[t, t, f, t]": return a.rightshift(b.getsigned()); 
		case "[t, t, t, f]": return rippleAdder.add(a,b);
		case "[t, t, t, t]": return rippleAdder.sub(a,b);
		case "[f, t, t, t]": return multiplier.multiply(a,b);
		default: return new Longword();
		}
	}

}
