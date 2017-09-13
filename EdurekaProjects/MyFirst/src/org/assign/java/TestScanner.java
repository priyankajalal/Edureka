package org.assign.java;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (getUserChoice()!=0) {
			System.out.println("Ener First Number:");
			int input1 = scan.nextInt();

			System.out.println("Ener Sdcond Number:");
			int input2 = scan.nextInt();
			System.out.println("Sum=" + add(input1, input2));
		}

	}
	static int getUserChoice()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 0 to exit any other key to add ");
		return scan.nextInt();
	}

	static int add(int a, int b) {
		return a + b;
	}

}
