package org.assign.java;

public abstract class Car {
	
	protected int s;
	
	public  void speedRaise(int x)
	{
		s = s +x;
		System.out.println("The speed of your  Car has raised to : "+s);
	}
	
	public  void speedDown(int x)
	{
		s = s -x;
		System.out.println("The speed of your  Car has raised to : "+s);
	}
	public abstract String getCarMake();


};
