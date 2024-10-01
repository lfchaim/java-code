package com.whs.javacode.codesignal;

import java.util.ArrayList;
import java.util.List;

public class UberElectricVehicle {
	
	public static void main(String[] args) {
		
		List<Integer> driverLocations = new ArrayList<>();
		driverLocations.add(20);
		driverLocations.add(100);

		List<Integer> batteryLocations = new ArrayList<>();
		batteryLocations.add(60);
		batteryLocations.add(10);
		batteryLocations.add(40);
		batteryLocations.add(80);

		int pickupLocation = 50;

		System.out.println(minPickupTime(driverLocations, batteryLocations, pickupLocation));
	}

	public static int minPickupTime(List<Integer> driverLocations, List<Integer> batteryLocations, int pickupLocation) {
		List<Integer> pickupTimes = new ArrayList<>();

		for (int driverLocation : driverLocations) {
			Integer closestBatteryIndex = null;
			int minPickupTime = Integer.MAX_VALUE;

			for (int index = 0; index < batteryLocations.size(); index++) {
				int batteryLocation = batteryLocations.get(index);
				int pickupTime = Math.abs(driverLocation - batteryLocation)
						+ Math.abs(batteryLocation - pickupLocation);

				if (pickupTime < minPickupTime) {
					minPickupTime = pickupTime;
					closestBatteryIndex = index;
				}
			}

			batteryLocations.remove((int) closestBatteryIndex);
			pickupTimes.add(minPickupTime);
		}

		return max(pickupTimes);
	}

	private static int max(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int i : list) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
}

/*
Uber is recently planning to launch electric vehicles. Each electric vehicle contains swappable battery which needs to be replaced at some moment of time. At a particular moment there are n drivers and k batteries on a straight line. Every driver wants to go to a pickup location which is located on the line as well. To do that, he needs to reach battery location, replace the battery and then go to the pickup location. Once a battery is taken by somebody, it couldn't be taken by anybody else.

You need to determine the minimum time needed for all n drivers to get to the pickup location after swapping batteries. Assume that drivers move a unit distance per 1 second. If two drivers reach a battery at the same time, then only one of them can take the battery. A person can pass through a point with a battery without taking it.

[execution time limit] 2 seconds (cpp)

[input] array.integer drivers

Length = n; where n <= 1000

n distinct integers are a1, a2, ..., an (1 ≤ ai ≤ 10^9) — positions in which drivers are located initially. The positions are given in arbitrary order.

[input] array.integer batteries

Length = k; where n ≤ k ≤ 2 000

k distinct integers are b1, b2, ..., bk (1 ≤ bj ≤ 10^9) — positions of the batteries. The positions are given in arbitrary order.

[input] integer p

the pickup location. (1 ≤ p ≤ 10^9)

Note that there can't be more than one person or more than one battery in the same point. A person and a battery can be located in the same point.

[output] integer64

Print the minimum time (in seconds) needed for all n drivers to reach the pickup location after swapping the batteries.

Input:
drivers: [20, 100]
batteries: [60, 10, 40, 80]
p: 50
Expected Output:
50
*/