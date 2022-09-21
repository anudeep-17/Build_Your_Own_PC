package assignment5;

public class memory_test
{
	public static void memory_test()
	{
		Longword tester = new Longword();
		Longword tester_address = new Longword();
		
		tester.set(10);
		tester_address.set(0);
		Memory.write(tester_address, tester);
		
		tester.set(11);
		tester_address.set(5);
		Memory.write(tester_address, tester);
		
		tester.set(12);
		tester_address.set(10);
		Memory.write(tester_address, tester);
		
		tester.set(13);
		tester_address.set(15);
		Memory.write(tester_address, tester);
		
		tester.set(14);
		tester_address.set(20);
		Memory.write(tester_address, tester);
		
		tester.set(15);
		tester_address.set(25);
		Memory.write(tester_address, tester);
		
		tester.set(16);
		tester_address.set(30);
		Memory.write(tester_address, tester);
		
		tester.set(17);
		tester_address.set(35);
		Memory.write(tester_address, tester);
		
		tester.set(18);
		tester_address.set(40);
		Memory.write(tester_address, tester);
		
		tester.set(19);
		tester_address.set(45);
		Memory.write(tester_address, tester);
		
		tester.set(20);
		tester_address.set(50);
		Memory.write(tester_address, tester);
		
		tester.set(25);
		tester_address.set(55);
		
		
		//test
		Memory.write(tester_address, tester);
		
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
		
		
		
		if(Memory.read(new Longword(5)).getsigned() == 11)
		{
			System.out.print( "given: "+ Memory.read(new Longword(5)).getsigned()+" Expected: 11 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(5)).getsigned()+" Expected: 11 " + "-> ");
			System.out.println("Failure");
		}
		
		
		
		if(Memory.read(new Longword(10)).getsigned() == 12)
		{
			System.out.print( "given: "+ Memory.read(new Longword(10)).getsigned()+" Expected: 12 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(10)).getsigned()+" Expected: 12 " + "-> ");
			System.out.println("Failure");
		}
		
		
		
		if(Memory.read(new Longword(15)).getsigned() == 13)
		{
			System.out.print( "given: "+ Memory.read(new Longword(15)).getsigned()+" Expected: 13 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(15)).getsigned()+" Expected: 13 " + "-> ");
			System.out.println("Failure");
		}
		
		
		
		if(Memory.read(new Longword(20)).getsigned() == 14)
		{
			System.out.print( "given: "+ Memory.read(new Longword(20)).getsigned()+" Expected: 14 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(20)).getsigned()+" Expected: 14 " + "-> ");
			System.out.println("Failure");
		}
		
		
		
		if(Memory.read(new Longword(25)).getsigned() == 15)
		{
			System.out.print( "given: "+ Memory.read(new Longword(25)).getsigned()+" Expected: 15 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(25)).getsigned()+" Expected: 15 " + "-> ");
			System.out.println("Failure");
		}
		
		
		
		if(Memory.read(new Longword(30)).getsigned() == 16)
		{
			System.out.print( "given: "+ Memory.read(new Longword(30)).getsigned()+" Expected: 16 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(30)).getsigned()+" Expected: 16 " + "-> ");
			System.out.println("Failure");
		}
		

		if(Memory.read(new Longword(35)).getsigned() == 17)
		{
			System.out.print( "given: "+ Memory.read(new Longword(35)).getsigned()+" Expected: 17 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(35)).getsigned()+" Expected: 17 " + "-> ");
			System.out.println("Failure");
		}
			
		
		if(Memory.read(new Longword(40)).getsigned() == 18)
		{
			System.out.print( "given: "+ Memory.read(new Longword(40)).getsigned()+" Expected: 18 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(40)).getsigned()+" Expected: 18" + "-> ");
			System.out.println("Failure");
		}
		
		
		if(Memory.read(new Longword(45)).getsigned() == 19)
		{
			System.out.print( "given: "+ Memory.read(new Longword(45)).getsigned()+" Expected: 19 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(45)).getsigned()+" Expected: 19 " + "-> ");
			System.out.println("Failure");
		}
		
		
		if(Memory.read(new Longword(50)).getsigned() == 20)
		{
			System.out.print( "given: "+ Memory.read(new Longword(50)).getsigned()+" Expected: 20 " + "-> ");
			System.out.println("Success");
		}
		else
		{
			System.out.print( "given: "+ Memory.read(new Longword(50)).getsigned()+" Expected: 20 " + "-> ");
			System.out.println("Failure");
		}
		
	}

	public static void runtests()
	{
		memory_test();
	}
	
	public static void main(String[] args)
	{
		runtests();
	}

}
