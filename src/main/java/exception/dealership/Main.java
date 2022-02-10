package exception.dealership;

import exception.dealership.models.Car;
import exception.dealership.models.Dealership;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Car[] cars = new Car[] { new Car("Toyota", 5000), new Car("Tata", 12000), };
		cars[1].setMake("Hyundai");
		cars[1].setPrice(8500);

		Dealership dealership = new Dealership(cars);

		System.out.println("\n************* JAVA DEALERSHIP *************");
		while (true) {
			System.out.println(dealership);
			System.out.print("Enter the spot number of the car you want to buy: ");
			if (!scan.hasNextInt()) {
				String enteredValue = scan.next();
				System.out.println(enteredValue + " : Invalid Spot Number, enter again: ");
				continue;
			}
			int spot = scan.nextInt();
			dealership.sell(spot);
		}

		// scan.close();

	}
}
