package assignment3;

public class Longword_test 
{
	
	//creating long word objects for testing 
	static Longword tester = new Longword(); //given object
	static Longword tester2 = new Longword(); //other object to test AND XOR OR COPY
	static Longword returner = new Longword(); //returner to test if the computer generated and method calculated is true or not 
	
	
	//-------------------------------------------------get bit testing -------------------------------------------
	static void getbit_test()
	{
		System.out.println("----------------------------------------------------get bit testing starts-----------------------------------------------------------------------------------");
		//sets the object to test
		Longword tester = new Longword();
		tester.set(10); //last four are tftf
		
		if(tester.getbit(30).getValue())
		{
			System.out.print("given :   "+ tester.getbit(30)+", expected: t   ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("given :   "+ tester.getbit(30)+", expected: t   ->  ");
			System.out.println("failure");
		}
		
		System.out.println("----------------------------------------------------get bit testing done-----------------------------------------------------------------------------------");
	}
	
	static void setbit_test()
	{
		System.out.println("----------------------------------------------------set bit testing starts-----------------------------------------------------------------------------------");
		
		//sets the object to test
		Longword tester = new Longword();
		tester.set(10);
		tester.setBit(31, new bit(true));
		
		if(tester.getbit(31).getValue())
		{
			
			System.out.print("given :   "+ tester.getbit(31)+", expected: t  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("given :   "+ tester.getbit(31)+", expected: t  ->   ");
			System.out.println("failure");
		}
		
		System.out.println("----------------------------------------------------set bit testing done-----------------------------------------------------------------------------------");
		
	}
	
	

	static void and_test()
	{
		
		System.out.println("----------------------------------------------------and testing starts-----------------------------------------------------------------------------------");
		
		//sets the object to test
		Longword tester = new Longword();
		Longword tester2 = new Longword();
		tester.set(10); 
		tester2.set(14);
			
		//fills the returner array to test the computer generated value
		for(int i = 0; i < 32; i++)
		{ 
			returner.setBit(i, new bit(tester.getbit(i).getValue() && tester2.getbit(i).getValue())); //uses && rather than and()
		}
		
		Longword output = tester.and(tester2); //sets the long word for checking is it success or failure. 
		
		if(output.toString().equals(returner.toString()))
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			
			System.out.println("----> success");
		}
		else
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			System.out.println("failure");
		}
		System.out.println("----------------------------------------------------and testing done-----------------------------------------------------------------------------------");
		
	}
	
	
	static void or_test()
	{
		
		System.out.println("----------------------------------------------------or testing starts-----------------------------------------------------------------------------------");
		
		
		//sets the tester objects
		Longword tester = new Longword();
		Longword tester2 = new Longword();
		tester.set(10);
		tester2.set(14);
			
		//fills the returner array to test the computer generated value
		for(int i = 0; i < 32; i++)
		{ 
			returner.setBit(i, new bit(tester.getbit(i).getValue() || tester2.getbit(i).getValue()));
		}
		
		//filling a output longword to test the equality.
		Longword output = tester.or(tester2);
		
		//if they are same it is success else failure
		if(output.toString().equals(returner.toString()))
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			
			System.out.println("----> success");
		}
		else
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			System.out.println("failure");
		}
		System.out.println("----------------------------------------------------or testing done-----------------------------------------------------------------------------------");
		
	}
	
	static void xor_test()
	{
		System.out.println("----------------------------------------------------xor testing starts-----------------------------------------------------------------------------------");
		
		//sets the tester objects
		Longword tester = new Longword();
		Longword tester2 = new Longword();
		tester.set(10);
		tester2.set(14);
			
		//fills the returner array to test the computer generated value
		for(int i = 0; i < 32; i++)
		{ 
			returner.setBit(i, new bit(tester.getbit(i).getValue() ^ tester2.getbit(i).getValue()));
		}
		
		//filling a output longword to test the equality.
		Longword output = tester.xor(tester2);
		
		if(output.toString().equals(returner.toString()))
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			
			System.out.println("----> success");
		}
		else
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			System.out.println("failure");
		}
		System.out.println("----------------------------------------------------xor testing done-----------------------------------------------------------------------------------");
		
	}
	
	
	
	static void not_test()
	{
		System.out.println("----------------------------------------------------not testing starts-----------------------------------------------------------------------------------");
		
		//setting tester method to test
		Longword tester = new Longword();
		tester.set(10);
	
			
		//fills the returner array to test the computer generated value
		for(int i = 0; i < 32; i++)
		{ 
			returner.setBit(i, new bit(!tester.getbit(i).getValue()));
		}
		
		//filling a output longword to test the equality.
		Longword output = tester.not();
		
		if(output.toString().equals(returner.toString()))
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			
			System.out.println("----> success");
		}
		else
		{
			System.out.println("given:  "+ returner.toString());
			System.out.println("given:  "+ output.toString());
			System.out.println("failure");
		}
		System.out.println("------------------------------------------------- not testing done-----------------------------------------------------------------------------------");
		
	}
	
	
	static void rightshift_test()
	{
		System.out.println("----------------------------------------------------right testing starts-----------------------------------------------------------------------------------");
		
		//tester objects setting 
		Longword tester = new Longword();
		tester.set(10);
		tester.rightshift(2);
		
		if(tester.getbit(30).getValue()) //sicnce the last four are fftf the 30 character should be false after shifting 
		{
			System.out.println(tester);
			System.out.println(tester.rightshift(2));//left shifting by two objects so the last 4 will be tfff
			System.out.println("on comparision ----> success");
		}
		else
		{
			System.out.println(tester);
			System.out.println(tester.rightshift(2));//left shifting by two objects so the last 4 will be tfff
			System.out.println("on comparision ----> failure");
		}
		
		
		System.out.println("----------------------------------------------------righ testing done -----------------------------------------------------------------------------------");
	
	}
	
	static void leftshift_test()
	{
		System.out.println("----------------------------------------------------left shift testing starts-----------------------------------------------------------------------------------");
		
		//tester objects setting 
		Longword tester = new Longword();
		tester.set(10);

		tester.leftshift(2);
		
		if(tester.getbit(28).getValue()) //sicnce the last four are tfff the 28 character should be false after shifting 
		{
			System.out.println(tester);
			System.out.println(tester.leftshift(2));//left shifting by two objects so the last 4 will be tfff
			System.out.println("on comparision ----> success");
		}
		else
		{
			System.out.println(tester);
			System.out.println(tester.leftshift(2));//left shifting by two objects so the last 4 will be tfff
			System.out.println("on comparision ----> failure");
		}
		
		
		System.out.println("----------------------------------------------------left shift testing done -----------------------------------------------------------------------------------");
		
	}
	
	static void unsigned_test()
	{
		
		System.out.println("----------------------------------------------------unsigned testing starts-----------------------------------------------------------------------------------");
		
		//sets the tester objects 
		Longword tester = new Longword();
		
		tester.set(-6);
		
		if(Long.toString(tester.getunsigned()).equals("4294967290")) //value calculated using calculator in https://onlinetoolz.net/unsigned-signed#base=10&value=-6&bits=32
		{
			System.out.println();
			System.out.println("get unsigned value of given bits " + tester.getunsigned());
			System.out.println("----> success");
		}
		else
		{
			System.out.println();
			System.out.println("get unsigned value of given bits " + tester.getunsigned());
			System.out.println("----> failure");
		}
		
		
		
		System.out.println("----------------------------------------------------unsigned testing done-----------------------------------------------------------------------------------");
		
		
	}
	
	static void signed_test()
	{
		System.out.println("----------------------------------------------------signed testing starts-----------------------------------------------------------------------------------");
		
		Longword tester = new Longword();
		
		tester.set(-6);

		
//		System.out.println(tester);
		if(tester.getsigned() == -6)
		{
			System.out.println("unsigned value of given bits " + tester.getsigned() + "given : -6");
			System.out.println("----> success");
		}
		else
		{
			System.out.println("get unsigned value of given bits " + tester.getsigned() + "given : -6");
			System.out.println("----> failure");
		}
		System.out.println("----------------------------------------------------signed testing done -----------------------------------------------------------------------------------");
		
	}
	
	static void copy_test()
	{
		
		System.out.println("----------------------------------------------------copy testing starts-----------------------------------------------------------------------------------");
		
		//sets the data for the tester bits. 
		tester.set(10);
		tester2.set(14);
		tester.copy(tester2); //copies the value 
		
		if(tester.toString().equals(tester2.toString())) //if true results success else failure 
		{
			System.out.println("given: "+ tester2);
			System.out.println("expected: "+ tester);
			System.out.println("--> success");
		}
		else
		{
			System.out.println("given: "+ tester2);
			System.out.println("expected: "+ tester);
			System.out.println("failure");
		}
		System.out.println("----------------------------------------------------copy testing done-----------------------------------------------------------------------------------");
		
	}
	
	
	static void set_test()
	{
		
		System.out.println("----------------------------------------------------set testing starts-----------------------------------------------------------------------------------");
		
		//sets teh objects 
		tester2.set(12);
		tester.set(-12);
		
		if((int)tester2.getsigned() == 12) //if signed value is same as given then its success else failure 
		{
			System.out.print("expected : 12, "+ "given : "+ tester2.getsigned());
			System.out.println("-> success");
		}
		else
		{
			System.out.print("expected : 12, "+ "given : "+ tester2.getsigned());
			System.out.println("-> failure");
		}
		
		
		//test 2
		if((int)tester.getsigned() == -12)
		{
			System.out.print("expected : -12, "+ "given : "+ tester.getsigned());
			System.out.println("-> success");
		}
		else
		{
			System.out.print("expected : -12, "+ "given : "+ tester.getsigned());
			System.out.println("-> failure");
		}
		
		System.out.println("----------------------------------------------------set testing done -----------------------------------------------------------------------------------");
		
	}
	
	
 //method with all test cases 
	static void runtests()
	{
		System.out.println("-------------------------------------------------------testing starts here----------------------------------");
		System.out.println();
		System.out.println();
		
		getbit_test();
		
		System.out.println();
		
		setbit_test();
		
		System.out.println();
		
		and_test();

		System.out.println();
		
		or_test();

		System.out.println();
		
		xor_test();

		System.out.println();
		
		not_test();
			
		System.out.println();
		
		rightshift_test();
		
		System.out.println();
		
		leftshift_test();
		
		System.out.println();
		
		unsigned_test();
		
		System.out.println();
		
		signed_test();
		
		System.out.println();
		
		copy_test();
		
		System.out.println();
		
		set_test();
		
	}
//main method to runthe test cases 
//	public static void main(String[] args)
//	{
//		runtests();
//	}
	
}
