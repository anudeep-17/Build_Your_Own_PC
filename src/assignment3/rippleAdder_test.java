package assignment3;

public class rippleAdder_test 
{
	
	public static void add_test()
	{
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		//test 1
		tester.set(-10);
		tester_support.set(-10);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == -20)
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -20 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -20 -->");
			System.out.println("failure");
		}
		
		//test2
		tester.set(10000);
		tester_support.set(-1);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 9999)
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 9999 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 9999 -->");
			System.out.println("failure");
		}
		
		
		
		
		tester.set(Integer.MAX_VALUE);
		tester_support.set(Integer.MIN_VALUE);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == -1)
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -1 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: -1 -->");
			System.out.println("failure");
		}
		
		
		
		tester.set(603636806);
		tester_support.set(10);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 603636816)
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("failure");
		}
		
		
		
		tester.set(0);
		tester_support.set(0);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 0)
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.add(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("failure");
		}
		
		
		
		tester.set(1);
		tester_support.set(1122);
		
		if(rippleAdder.add(tester,tester_support).getsigned() == 1123)
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
	
	public static void sub_test()
	{
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		//test 1
		tester.set(10);
		tester_support.set(10);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 0)
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
		tester.set(10000);
		tester_support.set(-1);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 10001)
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 10001 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 10001 -->");
			System.out.println("failure");
		}
		
		
		
		
		tester.set(Integer.MAX_VALUE);
		tester_support.set(1);
//		System.out.println(tester);
//		System.out.println(tester_support);
//		System.out.println(rippleAdder.sub(tester, tester_support));
		if(rippleAdder.sub(tester,tester_support).getsigned() == (Integer.MAX_VALUE-1))
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: "+ (Integer.MAX_VALUE-1) + " -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+" expected: "+ (Integer.MAX_VALUE-1) + " -->");
			System.out.println("failure");
		}
		
		
		
		tester.set(603636806);
		tester_support.set(10);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 603636796)
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 603636816 -->");
			System.out.println("failure");
		}
		
		
		
		tester.set(0);
		tester_support.set(0);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == 0)
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("Success");
		}
		else
		{
			System.out.print("given: "+ rippleAdder.sub(tester,tester_support).getsigned()+ " expected: 0 -->");
			System.out.println("failure");
		}
		
		tester.set(1);
		tester_support.set(1122);
		
		if(rippleAdder.sub(tester,tester_support).getsigned() == -1121)
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
