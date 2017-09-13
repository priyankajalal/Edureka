package org.assign.java;

public class CityHonda extends Car{
	
	
	public static void print()
	{
		System.out.println("i am static method");
	}

	@Override
	public String getCarMake() {
		return "Honda Car";
	}
	
}

	