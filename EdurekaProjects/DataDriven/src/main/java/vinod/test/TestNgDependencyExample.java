package vinod.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.testng.annotations.Test;

public class TestNgDependencyExample {
	
	@Test(groups="g1")
	public void test1()
	{
		System.out.println("test1 mehtod");
	}
	
	@Test(groups="g1")
	public void test2() throws Exception
	{
		System.out.println("test1 mehtod");
		//assert(2==6);
		//throw new Exception("Failed due to test");
		//BufferedReader reader = new BufferedReader(new FileReader("c:\\vinod"));
	}
	
	@Test(groups="g2" , dependsOnGroups="g1")
	public void test3()
	{
		System.out.println("test1 mehtod");
	}

}
