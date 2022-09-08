package org.dmitrysulman.practicum;

public class Converter {

    private final static double CENTIMETERS_IN_STEP = 0.75d;
    private final static int CALORIES_IN_STEP = 50;

    public static double getDistanceBySteps(int steps) {
        return steps * CENTIMETERS_IN_STEP / 100000;
    }

    public static double getCaloriesBySteps(int steps) {
        return steps * CALORIES_IN_STEP / 1000.0;
    }
}
