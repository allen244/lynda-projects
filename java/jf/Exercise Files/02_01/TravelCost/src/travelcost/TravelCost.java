/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelcost;

import java.util.Scanner;

public class TravelCost {

	public static void main(String[] args) {
		// double distance;
		// double mpg;
		// double pricePerGallon;
		// double totalCost;
		double distance, mpg, pricePerGallon, totalCost;
		String vehicleType;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the total distance in miles: ");
		distance = in.nextDouble();
		System.out.println("Enter the mpg for the vehicle: ");
		mpg = in.nextDouble();
		System.out.println("Enter the price of one gallon of gas: ");
		pricePerGallon = in.nextDouble();
		System.out.println("VTYP: ");
		vehicleType = in.next();
		totalCost = (distance / mpg) * pricePerGallon;
		System.out.printf("The trip is going to cost $%5.2f Since you are driving a " + vehicleType , totalCost);
		System.out.println();
	}

}
