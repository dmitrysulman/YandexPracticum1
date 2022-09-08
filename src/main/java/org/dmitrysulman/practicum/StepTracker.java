package org.dmitrysulman.practicum;

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

    public void printStatistic(int month) {
        System.out.println(stepsByDay(month));
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
