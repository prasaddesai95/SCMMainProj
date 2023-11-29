package com.TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertTest {

	@Test
	public void hardAssertTest()
	{
		String exp = "B";
		System.out.println("----TS-1----");
		System.out.println("----TS-2----");
		//for comparing the string
		//Assert.assertEquals("A", exp);
		//for comparing the string & getting customized msg
		assertEquals("A", exp, "the Data is not Matching");
		System.out.println("----TS-3----");
		System.out.println("----TS-4----");
		System.out.println("----TS-5----");
	}
	
	@Test
	public void hardAssertTest2()
	{
		int exp = 50;
		int notnull = 0;
		System.out.println("----TS-6----");
		System.out.println("----TS-7----");
		//static org.testng.Assert.*
		//to not call Assert.assertEquals again n again
	    //assertEquals("A", exp, "the Data is not Matching");
		//assertNull(exp);
		assertNotNull(notnull);
		System.out.println("----TS-8----");
		System.out.println("----TS-9----");
		
	}
	
	@Test
	public void sofassrt()
	{
		SoftAssert sc = new SoftAssert();
		
		sc.assertAll();
	}
}
