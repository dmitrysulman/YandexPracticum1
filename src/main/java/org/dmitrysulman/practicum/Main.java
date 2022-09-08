package org.dmitrysulman.practicum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 4) {
            switch (userInput) {
                case 1 -> {
                    System.out.print("Введите номер месяца (начиная с 0): ");
                    int month = scanner.nextInt();
                    if (month < 0 || month > 11) {
                        System.out.println("Неверное значение месяца");
                        break;
                    }
                    System.out.print("Введите номер дня: ");
                    int day = scanner.nextInt();
                    if (day <= 0 || day > 30) {
                        System.out.println("Неверное значение дня");
                        break;
                    }
                    System.out.print("Введите количество шагов: ");
                    int steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Неверное количество шагов");
                        break;
                    }
                    stepTracker.setSteps(month, day, steps);
                }
                case 2 -> {
                    System.out.print("Введите номер месяца (начиная с 0): ");
                    int month = scanner.nextInt();
                    if (month < 0 || month > 11) {
                        System.out.println("Неверное значение месяца");
                        break;
                    }
                    stepTracker.printStatistic(month);
                }
                case 3 -> {
                    System.out.println("Текущая цель по количеству шагов в день: " + stepTracker.getTargetSteps());
                    System.out.print("Введите новую цель по количеству шагов в день: ");
                    int target = scanner.nextInt();
                    stepTracker.setTargetSteps(target);
                }
            }
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("4. Выйти из приложения.");
    }
}