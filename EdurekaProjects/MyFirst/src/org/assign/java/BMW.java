package org.assign.java;

public class BMW extends Car {

	@Override
	public void speedRaise(int x) {
		s = s + x + 10;
		System.out.println("The speed of your BMW Car has raised to : " + s);
	}

	@Override
	public String getCarMake() {
		return "BMW Car";
	}

}
