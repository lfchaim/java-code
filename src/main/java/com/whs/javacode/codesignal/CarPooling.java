package com.whs.javacode.codesignal;

public class CarPooling {

	public static boolean canCompleteTrips(int[][] trips, int capacity) {
		// Array to store the changes in the number of passengers at each kilometer.
		// We assume that the trip locations are within the 1000 km range.
		int[] road = new int[1001]; // 1001 to handle locations from 0 to 1000 inclusive.

		// Process each trip
		for (int[] trip : trips) {
			int passengers = trip[0];
			int pickUp = trip[1];
			int dropOff = trip[2];

			// Add passengers at pick-up location
			road[pickUp] += passengers;

			// Remove passengers at drop-off location
			road[dropOff] -= passengers;
		}

		// Check the running total of passengers in the car
		int currentPassengers = 0;
		for (int i = 0; i < road.length; i++) {
			currentPassengers += road[i]; // Update current passengers based on the event at kilometer i

			// If at any point the number of passengers exceeds capacity, return false
			if (currentPassengers > capacity) {
				return false;
			}
		}

		// If we never exceed the capacity, return true
		return true;
	}

	public static void main(String[] args) {
		// Example: trips = [[2, 1, 5], [3, 3, 7]], capacity = 4
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 4;

		// Output: false (At kilometer 3-5, there would be 5 passengers, which exceeds
		// the capacity)
		System.out.println(canCompleteTrips(trips, capacity)); // Output: false
	}
}

/*
In this problem, we are simulating a carpool scenario. 
A car has a certain number of empty seats (given by capacity), and it can only drive in one direction—east. 
We are provided with an array trips, where each element is a trip described by three integers: numPassengers, from, and to. 
These respectively represent the number of passengers for that trip, the kilometer mark where the passengers will be picked up, 
and the kilometer mark where they will be dropped off. Our task is to determine if the car can successfully complete all the 
given trips without ever exceeding its seating capacity. If it is possible to pick up and drop off all passengers for all the 
trips without going over capacity at any point, we return true. Otherwise, we return false.
*/