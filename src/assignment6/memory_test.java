package assignment6;

public class memory_test
{
	public static void memory_test() throws Exception
	{
		//initializign the empty memory for the bit storage.
		Memory initialize = new Memory();
		
		//test cases 
		Memory.write(new Longword(0), new Longword(10)); //fills the 0 to 31 with 10 value 
		Memory.write(new Longword(32), new Longword(11));//fills the 31 to 63 with 11 value 
		Memory.write(new Longword(64), new Longword(12));//fills the 64 to 95 with 12 value 
		Memory.write(new Longword(96), new Longword(13));//fills the 96 to 127 with 13 value 
		Memory.write(new Longword(128), new Longword(14));//fills the 128 to 159 with 14 value 
		Memory.write(new Longword(160), new Longword(15));//fills the 160 to 191 with 15 value 
		Memory.write(new Longword(192), new Longword(16));//fills the 192 to 224 with 16 value 
		
		
		
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(0)).getsigned() == 10)
		{
			System.out.print("given : "+Memory.read(new Longword(0)).getsigned()+" expected: 10 "+ "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+Memory.read(new Longword(0)).getsigned()+" expected: 10" + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(32)).getsigned() == 11)
		{
			System.out.print( "given: "+ Memory.read(new Longword(32)).getsigned()+" Expected: 11 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(32)).getsigned()+" Expected: 11 " + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(64)).getsigned() == 12)
		{
			System.out.print( "given: "+ Memory.read(new Longword(64)).getsigned()+" Expected: 12 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(64)).getsigned()+" Expected: 12 " + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(96)).getsigned() == 13)
		{
			System.out.print( "given: "+ Memory.read(new Longword(96)).getsigned()+" Expected: 13 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(96)).getsigned()+" Expected: 13 " + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(128)).getsigned() == 14)
		{
			System.out.print( "given: "+ Memory.read(new Longword(128)).getsigned()+" Expected: 14 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(128)).getsigned()+" Expected: 14 " + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(160)).getsigned() == 15)
		{
			System.out.print( "given: "+ Memory.read(new Longword(160)).getsigned()+" Expected: 15 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(160)).getsigned()+" Expected: 15 " + "-> ");
			System.out.println("Failure");
		}
		
		
		//if the bits from 0 return the signed value as what we wrote usign write then it is success else false
		if(Memory.read(new Longword(192)).getsigned() == 16)
		{
			System.out.print( "given: "+ Memory.read(new Longword(192)).getsigned()+" Expected: 16 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(192)).getsigned()+" Expected: 16 " + "-> ");
			System.out.println("Failure");
		}
	
		
	}

	public static void runtests() throws Exception
	{
		memory_test();
	}
	
//	public static void main(String[] args) throws Exception
//	{
//		runtests();
//	}

}
