package assignment5;

public class rippleAdder_test 
{
	
	//add_test for the add method verification.
	public static void add_test()
	{
		//initializing longword objects for testing
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		//test 1
		//setting longword object to value 
		tester.set(-10);
		tester_support.set(-10);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == -20) // since -10 + -10 = -20 if the signed value of returned longword is -20 then its success else its a failure.
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -20 -->"); //printing the output value
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -20 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test2
		//setting longword object to value 
		tester.set(10000);
		tester_support.set(-1);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 9999) //since 10000 + -1  = 9999 if the signed value is that then its a success else its a failure
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 9999 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 9999 -->");
			System.out.println("failure");
		}
		
		
		
		//test 3 
		//initializing the longwords to max and min values 
		tester.set(Integer.MAX_VALUE);
		tester_support.set(Integer.MIN_VALUE);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == -1) //integer.max + integer.min gives -1 as result if the output is -1 then it is considered as success
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -1 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -1 -->");
			System.out.println("failure");
		}
		
		
		//test4
		//setting longword object to value 
		tester.set(603636806);
		tester_support.set(10);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 603636816) // 603636806+10 =  603636816 if that is retured as longword and matched with signed value then its success 
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("failure");
		}
		
		
		//test5
		//setting longword object to value 
		tester.set(0);
		tester_support.set(0);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 0) // a pure testing case as 0+0 = 0 if that is given then its success
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("failure");
		}
		
		
		//test6
		//setting longword object to value 
		tester.set(0);
		tester_support.set(10);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 10) //adding 10+0 = 10 checking if the application adds the correct way for everything and if it returns 10 then success
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 10 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 10 -->");
			System.out.println("failure");
		}
		
		
		//test7
		//setting longword object to value 
		tester.set(1);
		tester_support.set(1122);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 1123) //1+1122 = 1123, if the signed value of returned longword is this then it is success. 
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 1123 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 1123 -->");
			System.out.println("failure");
		}
		
	}
	
	//testing sub method of rippleAdder.
	public static void sub_test()
	{
		//initializing longword objects for testing
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		//test 1
		//setting longword object to value 
		tester.set(10);
		tester_support.set(10);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 0) // 10-10 = 0 so if the signed value of the returned lond word is 0 then its success.
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("failure");
		}
		
		//test2
		//setting longword object to value 
		tester.set(10000);
		tester_support.set(-1);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 10001)// 10000 - -1 = 10001 so if the signed value of the returned lond word is 10001 then its success.
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 10001 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 10001 -->");
			System.out.println("failure");
		}
		
		
		
		//test3
		//setting longword object to value 
		tester.set(Integer.MAX_VALUE);
		tester_support.set(1);

		
		if(rippleAdder.sub(tester,tester_support).getsigned() == (Integer.MAX_VALUE-1))// if the returned value of the longword gives the 1 subtracted value of max int then its success.
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: "+ (Integer.MAX_VALUE-1) + " -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+" expected: "+ (Integer.MAX_VALUE-1) + " -->");
			System.out.println("failure");
		}
		
		
		//test4
		//setting longword object to value 
		tester.set(603636806);
		tester_support.set(10);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 603636796) // 603636806-10 = 603636816, if this is returned then its a success
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("failure");
		}
		
		

		//test5
		//setting longword object to value 
		tester.set(0);
		tester_support.set(0);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 0) // testing it if the applciation handle such data input like 0-0 = 0, if that is returned then its success.
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("failure");
		}
		
		
		//test6
		//setting longword object to value 
		tester.set(0);
		tester_support.set(10);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == -10) // 0-10 = -10 so if it is returned from the signed value of the longword then its success. 
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: -10 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: -10 -->");
			System.out.println("failure");
		}
		
		
		//test7
		//setting longword object to value 
		tester.set(1);
		tester_support.set(1122);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == -1121) //1-1122 = -1121, if it is returned from the signed value of the longword then its success. 
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: -1121 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: -1121 -->");
			System.out.println("failure");
		}
		
		
	}
	
	
 //runtests method that calls all the test cases that tests the methods.
	static void runtests()
	{
		System.out.println("---------------------------------add test----------------------------------------");
		
		add_test();
		
		
		System.out.println("---------------------------------add test done ----------------------------------------");
		System.out.println();
		
		
		System.out.println("---------------------------------sub test----------------------------------------");
		
		sub_test();
		
		System.out.println("---------------------------------sub test done ----------------------------------------");
		System.out.println();
		
	}
//	public static void main(String[] args)
//	{
//		runtests();
//	}
}
