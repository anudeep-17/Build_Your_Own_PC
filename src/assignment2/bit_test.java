package assignment2;


//class bit_test [unit testing of the class]

public class bit_test
{
	//two global objects of bit class used for testing
	static bit tester = new bit();  //primary usage in testing
	static bit tester_support = new bit(); //secondary usage in testing works while and or xor are in use.
	
	
	//testing first method set
	public static void set_test()
	{
		System.out.println("-------------set method test---------------------");
	
		//test 1
		tester.set(false); //initially setting tester object to false
		
		if(tester.getValue() == false) // if tester is false then it is success else failure
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else //else it is a failure
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		//test 2
		tester.set(true); //setting the tester to true.
		
		if(tester.getValue()) // if true then its a success else it is failure
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------set test done----------------------------");
	}
	
	//set method that sets the value to true is being tested here.
	
	public static void set_true_test()
	{
		System.out.println("-----------------------set true test----------------------------");
		tester.set(); // sets the value to true by default
		if(tester.getValue()) // if true its success else false.
		{ 
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------set true test done----------------------------");
	}
		
	//toggle method testing start 
	public static void toggle_test()
	{
		System.out.println("-------------toggle method test---------------------");
		tester.set(); //sets the method to true 
		tester.toggle(); // and toggle negates the value here
		
		if(tester.getValue() == false) // if the value is as expected then its success which is false in here else failure
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failer");
		}
		
		//testing again by using toggle that makes tester true.
		tester.toggle(); 
		
		if(tester.getValue()) // if the value is as expected then its success which is true in here else failure
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------toggle test done----------------------------");
	}
	
	
	
	
	
	//clear method testing here
	
	public static void clear_test()
	{
		
		System.out.println("-----------------------clear test----------------------------");
		tester.clear(); // this makes the tester false so 
		if(tester.getValue() == false)  // if false then success 
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		// testing non conventionally by setting tester to true and making it false by clear
		tester.set();
		tester.clear();
		if(tester.getValue() == false)  // if false then success 
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : false and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------clear test done----------------------------");
	}
	
	//getValue method testing -  used in multiple methods so used only one case of test. 
	public static void getValue_test()
	{
		System.out.println("---------------------getValue test ------------------------");
		
		tester.set(); //sets the value to true
		
		if(tester.getValue() == true) // if getvalue returns true then its a success.
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//printing the result in a pattern of expected and given.
			System.out.print("expected : true and given: "+ tester.getValue()+"  ->  ");
			System.out.println("failure");
		}
		System.out.println();
		System.out.println("-----------------------getValue test done----------------------------");
	}
	
	//and method testing where the tester and tester_support are used for comaprision values. 
	public static void and_test()
	{
		
		System.out.println("-----------------------and test----------------------------");
		tester.set(true); // we set tester to true and tester_support as true to test as case 1
		tester_support.set(true);
		
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue())) // if computer generated value using && and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		//as case 2 we set tester to false and tester_support to true
		tester.set(false);
		tester_support.set(true);
		
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue())) // if computer generated value using && and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		//as case 3 we set tester to true and tester_support to false
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))// if computer generated value using && and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		//as case 4 we set tester to false and tester_support to false
		
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() && tester_support.getValue()) == (tester.and(tester_support).getValue()))// if computer generated value using && and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() && tester_support.getValue())+" and given: "+ (tester.and(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------and test done----------------------------");
	}
	
	//or method testing 
	public static void or_test()
	{
		
		System.out.println("-----------------------or test----------------------------");
		//as case 1 we set tester to true and tester_support to true
		tester.set(true);
		tester_support.set(true);
		
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))// if computer generated value using || and  method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		//as case 2 we set tester to false and tester_support to true
		tester.set(false);
		tester_support.set(true);
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))// if computer generated value using || and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		//as case 3 we set tester to true and tester_support to false
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))// if computer generated value using || and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		//as case 4 we set tester to false and tester_support to false
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() || tester_support.getValue()) == (tester.or(tester_support).getValue()))// if computer generated value using || and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() || tester_support.getValue())+" and given: "+ (tester.or(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		System.out.println();
		System.out.println("-----------------------or test done----------------------------");
	}
	
	
	//xor method testing 
	public static void xor_test()
	{
		
		System.out.println("-----------------------xor test----------------------------");
		//as case 1 we set tester to true and tester_support to true
		tester.set(true);
		tester_support.set(true);
		
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))// if computer generated value using ^ and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		//as case 2 we set tester to false and tester_support to true
		tester.set(false);
		tester_support.set(true);
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))// if computer generated value using ^ and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		//as case 3 we set tester to true and tester_support to false
		tester.set(true);
		tester_support.set(false);
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))// if computer generated value using ^ and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		
		
		//as case 4 we set tester to false and tester_support to false
		tester.set(false);
		tester_support.set(false);
		
		if((tester.getValue() ^ tester_support.getValue()) == (tester.xor(tester_support).getValue()))// if computer generated value using ^ and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+(tester.getValue() ^ tester_support.getValue())+" and given: "+ (tester.xor(tester_support).getValue()) +"  ->  ");
			System.out.println("failure");
		}	
		
		System.out.println();
		System.out.println("-----------------------xor test done----------------------------");
	}
	
	
	//not method testing 
	public static void not_test()
	{
		
		System.out.println("-----------------------not test ----------------------------");
		tester.set(); //sets the value to true initially 
		if(!(tester.getValue()) == tester.not().getValue()) // if computer generated value using ! and method generated value are same then its a success else it is a failure
		{
			//prints computer generated and method generated values and indicates success if they are same.
			System.out.print("expected :"+ !(tester.getValue()) +" and given: "+ (tester.not().getValue()) +"  ->  ");
			System.out.println("success");
		}
		
		System.out.println();
		System.out.println("-----------------------not test done----------------------------");
	}
	
	
	public static void toString_test()
	{
		System.out.println("-----------------------tostring test----------------------------");
		tester.set(); //sets the value of tester to true and 
		if(tester.toString() == "t") // if the t is retunred by method then its success
		{
			//prints expected and given values and indicates success if they are same.
			System.out.print("expected: t and given: "+ tester.toString()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints expected and given values and indicates success if they are same.
			System.out.print("expected: t and given: "+ tester.toString()+"  ->  ");
			System.out.println("failure");
		}
		
		tester.clear(); // sets the tester to false to test
		
		if(tester.toString() == "f") // if f is returned then its success
		{
			//prints expected and given values and indicates success if they are same.
			System.out.print("expected: f and given: "+ tester.toString()+"  ->  ");
			System.out.println("success");
		}
		else
		{
			//prints expected and given values and indicates success if they are same.
			System.out.print("expected: f and given: "+ tester.toString()+"  ->  ");
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println("-----------------------tostring test done----------------------------");
	}

	
	// runTests: has all the methods of test with proper indentation and spacing. this is will be called in the main to call all the methods. 
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
		
		
		getValue_test();
		
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
	
	//main method. 
	public static void main(String[] args)
	{
		System.out.println("-----------------------------------------BIT CLASS TESTING -----------------------------------------------------");
		System.out.println();
		runTests(); // runTests the method with all the test methods will be called and will excecute all the methods to give the output of test.
		
	}
	
	
	
    
}
