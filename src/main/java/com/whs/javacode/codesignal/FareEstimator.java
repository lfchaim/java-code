package com.whs.javacode.codesignal;

import java.util.ArrayList;
import java.util.List;

public class FareEstimator {

	public static List<Double> fareEstimator(double rideTime, double rideDistance, double[] costPerMinute, double[] costPerMile) {
        List<Double> estimates = new ArrayList<>();

        for (int i = 0; i < costPerMinute.length; i++) {
            double currentMinute = costPerMinute[i];
            double currentMile = costPerMile[i];

            double result = (rideTime * currentMinute) + (rideDistance * currentMile);
            estimates.add(result);
        }

        return estimates;
    }

    public static void main(String[] args) {
        double rideTime = 30; // example values
        double rideDistance = 7; // example values
        double[] costPerMinute = {0.2, 0.35, 0.4, 0.45};
        double[] costPerMile = {1.1, 1.8, 2.3, 3.5};

        List<Double> estimates = fareEstimator(rideTime, rideDistance, costPerMinute, costPerMile);

        System.out.println(estimates); // Output: [10.5, 12.6]
    }
	
}

/*
Uber is building a Fare Estimator that can tell you how much your ride will cost before you request it. It works by passing approximated ride distance and ride time through this formula:

(Cost per minute) * (ride time) + (Cost per mile) * (ride distance)

where Cost per minute and Cost per mile depend on the car type.

You are one of the engineers building the Fare Estimator, so knowing cost per minute and cost per mile for each car type, as well as ride distance and ride time, return the fare estimates for all car types.

Example

For ride_time = 30, ride_distance = 7, cost_per_minute = [0.2, 0.35, 0.4, 0.45], and cost_per_mile = [1.1, 1.8, 2.3, 3.5], the output should be fareEstimator(ride_time, ride_distance, cost_per_minute, cost_per_mile) = [13.7, 23.1, 28.1, 38].

Since:

30 * 0.2 + 7 * 1.1 = 6 + 7.7 = 13.7 
30 * 0.35 + 7 * 1.8 = 10.5 + 12.6 = 23.1 
30 * 0.4 + 7 * 2.3 = 12 + 16.1 = 28.1 
30 * 0.45 + 7 * 3.5 = 13.5 + 24.5 = 38

*/