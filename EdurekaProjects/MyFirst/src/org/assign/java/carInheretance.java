package org.assign.java;

import java.util.ArrayList;
import java.util.List;

public class carInheretance {
	
	public static void main (String[] args){
		
		CityHonda.print();
		
		CityHonda hondaCar = new CityHonda();
		hondaCar.print();
		
		Car c1 = new CityHonda();
		c1.speedRaise(0);
		c1.speedDown(0);
		
		
		Car c2 = new BMW();
		c2.speedRaise(0);
		c2.speedDown(9);
		
		List<Car> cars = new ArrayList<Car>();
		
		
	}

}
