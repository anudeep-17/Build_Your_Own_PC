package assignment1;

public class bit_test
{
	static bit tester = new bit();
	static bit tester_support = new bit();
	
	public static void set_test()
	{
		System.out.println("-------------set method test---------------------");
		tester.set(false);
		
		if(tester.getValue() == false)
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		tester.set(true);
		
		if(tester.getValue())
		{
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------set test done----------------------------");
	}
	
	
	public static void toggle_test()
	{
		System.out.println("-------------toggle method test---------------------");
		tester.set();
		tester.toggle();
		
		if(tester.getValue() == false)
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failer");
		}
		
		tester.toggle();
		
		if(tester.getValue())
		{
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------toggle test done----------------------------");
	}
	
	
	
	public static void set_true_test()
	{
		System.out.println("-----------------------set true test----------------------------");
		tester.set();
		if(tester.getValue())
		{ 
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------set true test done----------------------------");
	}
	
	
	public static void clear_test()
	{
		
		System.out.println("-----------------------clear test----------------------------");
		tester.clear();
		if(tester.getValue() == false)
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		
		tester.set();
		tester.clear();
		if(tester.getValue() == false)
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------clear test done----------------------------");
	}
	
	public static void and_test()
	{
		
		System.out.println("-----------------------and test----------------------------");
		tester.set(true);
		tester_support.set(true);
		
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		tester.set(false);
		tester_support.set(true);
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------and test done----------------------------");
	}
	
	
	public static void or_test()
	{
		
		System.out.println("-----------------------or test----------------------------");
		tester.set(true);
		tester_support.set(true);
		
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		tester.set(false);
		tester_support.set(true);
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		System.out.println();
		System.out.println("-----------------------or test done----------------------------");
	}
	
	
	public static void xor_test()
	{
		
		System.out.println("-----------------------xor test----------------------------");
		tester.set(true);
		tester_support.set(true);
		
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		tester.set(false);
		tester_support.set(true);
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		System.out.println();
		System.out.println("-----------------------xor test done----------------------------");
	}
	
	public static void not_test()
	{
		
		System.out.println("-----------------------not test ----------------------------");
		tester.set();
		if(!(tester.getValue()) == tester.not().getValue())
		{
			System.out.print("expected :"+!(tester.getValue())+" and given: "+ (tester.not().getValue()) +"  ->  ");
			System.out.println("success");
		}
		
		System.out.println();
		System.out.println("-----------------------not test done----------------------------");
	}
	
	
	public static void toString_test()
	{
		System.out.println("-----------------------tostring test----------------------------");
		tester.set();
		if(tester.toString() == "t")
		{
			System.out.print("expected: t and given: "+ tester.toString()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected: t and given: "+ tester.toString()+"  ->  ");
			System.out.println("failure");
		}
		
		tester.clear();
		
		if(tester.toString() == "f")
		{
			System.out.print("expected: f and given: "+ tester.toString()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			System.out.print("expected: f and given: "+ tester.toString()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------tostring test done----------------------------");
	}

	
	
	static void runTests()
	{
		set_test();
		
		
		System.out.println();
		System.out.println();
		
		
		toggle_test();
		
		
		System.out.println();
		System.out.println();
		
		
		set_true_test();
		
		
		System.out.println();
		System.out.println();
		
		
		clear_test();
		
		
		System.out.println();
		System.out.println();
		
		
		and_test();
		
		
		System.out.println();
		System.out.println();
		
		
		or_test();
		
		
		System.out.println();
		System.out.println();
		
		
		xor_test();
		
		
		System.out.println();
		System.out.println();
		
		
		
		not_test();
		
		
		System.out.println();
		System.out.println();
		
		toString_test();
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("-----------------------------------------BIT CLASS TESTING -----------------------------------------------------");
		System.out.println();
		runTests();
		
	}
	
	
	
    
}
