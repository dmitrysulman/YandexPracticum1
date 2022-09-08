package org.dmitrysulman.practicum;

import java.util.stream.IntStream;

public class StepTracker {

    private int targetSteps;

    private final MonthData[] monthData;

    public StepTracker() {
        this.targetSteps = 10000;
        monthData = new MonthData[12];
        for (int i = 0; i < 12; i++) {
            monthData[i] = new MonthData();
        }
    }

    public void setSteps(int month, int day, int steps) {
        monthData[month].setStepsByDay(day, steps);
    }

    public int getTargetSteps() {
        return targetSteps;
    }

    public void setTargetSteps(int targetSteps) {
        if (targetSteps <= 0) {
            System.out.println("Целевое количество шагов должно быть больше нуля!");
        } else {
            this.targetSteps = targetSteps;
        }
    }

    public String stepsByDay(int month) {
        StringBuilder result = new StringBuilder();
        String delim = "";
        for (int i = 1; i <= 30; i++) {
            result.append(delim);
            result.append(i).append(" день: ").append(monthData[month].getStepsByDay(i));
            delim = ", ";
        }
        return result.toString();
    }

    private IntStream getMonthDataAsStream(int month) {
        return IntStream
                .rangeClosed(1, 30)
                .map(i -> monthData[month].getStepsByDay(i));
    }

    public int getStepsByMonth(int month) {
        return getMonthDataAsStream(month).sum();
    }

    public int getMaxStepsByMonth(int month) {
        return getMonthDataAsStream(month)
                .max()
                .orElse(0);
    }

    public double getAverageStepsByMonth(int month) {
        return getMonthDataAsStream(month)
                .average()
                .orElse(0d);
    }

    public double getDistance(int month) {
        return Converter.getDistanceBySteps(getStepsByMonth(month));
    }

    public double getCalories(int month) {
        return Converter.getCaloriesBySteps(getStepsByMonth(month));
    }

    public void printStatistic(int month) {
        System.out.println("Количество шагов по дням:");
        System.out.println(stepsByDay(month));
        System.out.println("Общее количество шагов за месяц: " + getStepsByMonth(month));
        System.out.println("Максимальное количество шагов за месяц: " + getMaxStepsByMonth(month));
        System.out.printf("Среднее количество шагов за месяц: %.2f\n", getAverageStepsByMonth(month));
        System.out.printf("Пройденная дистанция: %.4f км", getDistance(month));
        System.out.printf("Сожгли килокалорий: %.4f ", getCalories(month));
    }

    private static class MonthData {
        private final int[] stepsByDay;

        public MonthData() {
            stepsByDay = new int[30];
        }

        public int getStepsByDay(int day) {
            return stepsByDay[day - 1];
        }

        public void setStepsByDay(int day, int steps) {
            stepsByDay[day - 1] = steps;
        }
    }
}