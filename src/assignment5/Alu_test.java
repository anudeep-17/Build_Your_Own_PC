package assignment5;

import java.util.Arrays;

public class Alu_test 
{
	
	public static void doOp_test()
	{	
		//giving the longword objects. 
		Longword tester = new Longword(); 
		Longword tester_support = new Longword();
		
		//initializing the bit operations for the 4
		bit[] operation_indicator = new bit[4];
		
		
		//----------------------------------------and test ----------------------------------
		//operation indication saying and
		operation_indicator = bit.arraybit(true, false, false, false);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		
		// if it returns the same as the method and then its success else failure
		if(tester.and(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success"); 
		}
		else
		{
			System.out.println("failure");
		}
		
		
		//test2
		tester.set(133);
		tester_support.set(100);
		
		// if it returns the same as the method and then its success else failure
		if(tester.and(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//----------------------------------------and test done------------------------------
		
		
		
		
		//----------------------------------------or test ----------------------------------
		//operation indicator indicating the or trigger
		operation_indicator = bit.arraybit(true, false, false, true);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		
		// if it returns the same as the method or then its success else failure
		if(tester.or(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		//test2
		tester.set(133);
		tester_support.set(100);
		// if it returns the same as the method or then its success else failure
		if(tester.or(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//----------------------------------------or test done------------------------------
		
		
		
		//---------------------------------------xor test ----------------------------------
		//operation indication xor 
		operation_indicator = bit.arraybit(true, false, true, false);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		// if it returns the same as the method xor then its success else failure
		if(tester.xor(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		//test2
		tester.set(133);
		tester_support.set(100);
		// if it returns the same as the method xor then its success else failure
		if(tester.xor(tester_support).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//----------------------------------------xor test done------------------------------
		
		
		
		//---------------------------------------not test ------------------------------------
		//operation indication not
		operation_indicator = bit.arraybit(true, false, true, true);
		
		//test 1
		tester.set(55);
		// if it returns the same as the method not then its success else failure
		if(tester.not().toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure ");
		}
	
		//test 2 
		tester.set(60363680);
		// if it returns the same as the method not then its success else failure
		if(tester.not().toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure ");
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//-------------------------------------not test done ------------------------------
		
		
		
		
		//---------------------------------------leftshift test ----------------------------------
		//operation indication leftshift
		operation_indicator = bit.arraybit(true, true, false, false);
		
		//test1
		tester.set(12);
		tester_support.set(3);
		// if it returns the same as the method leftshift then its success else failure
		if(tester.leftshift(tester_support.getsigned()).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		//test2
		tester.set(133);
		tester_support.set(2);
		// if it returns the same as the method leftshift then its success else failure
		if(tester.leftshift(tester_support.getsigned()).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//----------------------------------------leftshift test done------------------------------
		
		
		
		//---------------------------------------rightshift test ----------------------------------
		//operation indication rightshift
		operation_indicator = bit.arraybit(true, true, false, true);
		
		//test1
		tester.set(12);
		tester_support.set(3);
		// if it returns the same as the method rightshift then its success else failure
		if(tester.rightshift(tester_support.getsigned()).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		//test2
		tester.set(133);
		tester_support.set(2);
		// if it returns the same as the method rightshift then its success else failure
		if(tester.rightshift(tester_support.getsigned()).toString().equals(Alu.doOp(operation_indicator,tester, tester_support).toString()))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//----------------------------------------rightshift test done------------------------------
		
		
		
		//------------------------------------ add test --------------------------------------
		//operation indication and 
		operation_indicator = bit.arraybit(true, true, true, false);
		
		//test 
		tester.set(4);
		tester_support.set(0);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 4)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 4 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 4 -->"); //printing the output value
			System.out.println("failure");
		}
		
		tester.set(4);
		tester_support.set(1);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 5)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 5 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 5 -->"); //printing the output value
			System.out.println("failure");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//-------------------------------------------add test done ---------------------------------
		
		
		
		
		//--------------------------------------------sub test--------------------------------------
		//operation indication sub
		operation_indicator = bit.arraybit(true, true, true, true);
		
		//test 1
		tester.set(10);
		tester_support.set(4);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 6)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 6 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test 2
		tester.set(23);
		tester_support.set(3);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 20)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 20 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 20 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test3
		tester.set(2000);
		tester_support.set(3);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == (2000-3))
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: " + (2000-3) +" -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: " + (2000-3) +" -->"); //printing the output value
			System.out.println("failure");
		}
		
		
		//test4
		tester.set(23);
		tester_support.set(3);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 20)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 20 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 20 -->"); //printing the output value
			System.out.println("failure");
		}
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		//------------------------------------------sub test done --------------------------------
		
		
		
		
		//------------------------------------------multiply test ------------------------------------------
		//operation indication multiply
		operation_indicator = bit.arraybit(false, true, true, true);
		
		//test 1
		tester.set(10);
		tester_support.set(4);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 40)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 40 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 40 -->"); //printing the output value
			System.out.println("failure");
		}
		
		//test 2
		tester.set(20);
		tester_support.set(3);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 60)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 60 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 60-->"); //printing the output value
			System.out.println("failure");
		}
		
		//test 3
		tester.set(133333);
		tester_support.set(3);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == (133333*3))
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: "+ (133333*3) +" -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: "+ (133333*3) +" -->"); //printing the output value
			System.out.println("failure");
		}
		
		
		//test 4
		tester.set(20);
		tester_support.set(0);
		// if it returns the same as the method signed number then its success else failure
		if(Alu.doOp(operation_indicator, tester, tester_support).getsigned() == 0)
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 0 -->"); //printing the output value
			System.out.println("success");
		}
		else
		{
			System.out.print("given: "+ Alu.doOp(operation_indicator, tester, tester_support).getsigned() + " expected: 0-->"); //printing the output value
			System.out.println("failure");
		}
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		//----------------------------------------------multiply test done ----------------------------------
		

		
	}
	
	static void runtests()
	{
		doOp_test();
	}
	
//	public static void main(String[] args)
//	{
//		runtests();
//	}

}
