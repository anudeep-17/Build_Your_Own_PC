package assignment4;

import java.util.Arrays;

public class Alu_test 
{
	
	public static void doOp_test()
	{
		Longword tester = new Longword();
		Longword tester_support = new Longword();
		
		bit[] operation_indicator = new bit[4];
		
		
		//----------------------------------------and test ----------------------------------
		
		operation_indicator = bit.arraybit(true, false, false, false);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		
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
		
		operation_indicator = bit.arraybit(true, false, false, true);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		
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
		
		operation_indicator = bit.arraybit(true, false, true, false);
		
		//test1
		tester.set(12);
		tester_support.set(14);
		
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
		
		operation_indicator = bit.arraybit(true, false, true, true);
		
		//test 1
		tester.set(55);
		
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
		
		operation_indicator = bit.arraybit(true, true, false, false);
		
		//test1
		tester.set(12);
		tester_support.set(3);
		
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
		
		operation_indicator = bit.arraybit(true, true, false, true);
		
		//test1
		tester.set(12);
		tester_support.set(3);
		
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
		operation_indicator = bit.arraybit(true, true, true, false);
		//test 
		tester.set(4);
		tester_support.set(0);
				
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

		operation_indicator = bit.arraybit(true, true, true, true);
		
		//test 1
		tester.set(10);
		tester_support.set(4);
		
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
		operation_indicator = bit.arraybit(false, true, true, true);
		
		//test 1
		tester.set(10);
		tester_support.set(4);
		
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
	
	public static void main(String[] args)
	{
		runtests();
	}

}
