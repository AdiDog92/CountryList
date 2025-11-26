package practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean canWork = true;

        String print = "print";
        String create = "create";
        String exit = "exit";

        Country[] countries = new Country[10];

        countries[0] = new Country("Russia", 17100000, 146700000, "Moscow", 12600000);
        countries[1] = new Country("Finland", 338000, 5500000, "Helsinki", 655000);
        countries[2] = new Country("France", 643800, 67800000, "Paris", 2100000);
        countries[3] = new Country("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Country("Singapore", 2, 5700000);

        int idx = 5;

        while (canWork) {
            System.out.println("Введите команду");
            System.out.println("- create - создать страну");
            System.out.println("- print - распечатать данные");
            System.out.println("- exit - завершить работу программы");

            String command = scanner.nextLine().toLowerCase();

            if (command.equals(exit)) {
                canWork = false;
                System.out.println("Программа завершена");
                continue;
            } else if (command.equals(create)) {

                if (idx >= countries.length) {
                    System.out.println("Массив заполнен");
                    continue;
                }

                boolean validArea = false;
                double area = 0;
                boolean validPopulation = false;
                long population = 0;
                boolean validCapitalPopulation = false;
                long capitalPopulation = 0;

                System.out.println("Введите название страны:");
                String name = scanner.nextLine();

                while (!validArea) {
                    try {
                        System.out.println("Введите площать (км²):");
                        area = scanner.nextDouble();
                        scanner.nextLine();
                        validArea = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Нужно ввести число. Попробуйте снова:");
                        scanner.nextLine();
                    }
                }

                while (!validPopulation) {
                    try {
                        System.out.println("Введите население:");
                        population = scanner.nextLong();
                        scanner.nextLine();
                        validPopulation = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка! Нужно ввести число. Попробуйте снова:");
                        scanner.nextLine();
                    }
                }

                System.out.println("Есть ли столица? (y/n):");
                String answer = scanner.nextLine();

                if (answer.equals("y")) {
                    System.out.println("Введите название столицы:");
                    String capitalName = scanner.nextLine();

                    while (!validCapitalPopulation) {
                        try {
                            System.out.println("Введите население столицы:");
                            capitalPopulation = scanner.nextLong();
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка! Нужно ввести число. Попробуйте снова:");
                            scanner.nextLine();
                        }
                    }

                    countries[idx] = new Country(name, area, population, capitalName, capitalPopulation);
                    System.out.println("Страна добавлена: " + name);
                    idx++;
                } else {
                    countries[idx] = new Country(name, area, population);
                    System.out.println("Страна добавлена: " + name);
                    idx++;
                }
            } else if (command.equals(print)) {
                printAll(countries);
            } else {
                System.out.println("Неизвестная команда. Доступные: create, print, exit");
            }
        }
    }

    public static void printAll(Country[] countries) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] != null) {
                System.out.println(countries[i].toString());
            }
        }
    }
}
