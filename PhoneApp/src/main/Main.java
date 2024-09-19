package main;

import phone.Phone;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Phone[] phones = new Phone[] {
                new Phone(1, "Іваненко", "Іван", "Іванович", "123001", 120, 30),
                new Phone(2, "Петренко", "Петро", "Петрович", "123009", 50, 0),
                new Phone(3, "Сидоренко", "Сидір", "Сидорович", "234001", 180, 60),
                new Phone(4, "Максименко", "Максим", "Максимович", "345001", 100, 15),
                new Phone(5, "Григоренко", "Григорій", "Григорович", "345009", 75, 80)
        };

        // абоненти, у яких час міських розмов перевищує заданий
        System.out.print("Введіть мінімальний час міських розмов у хвилинах: ");
        String minCityTalkTimeInput = scanner.next();
        printCityTalkTimeGreaterThan(phones, minCityTalkTimeInput);

        // абоненти, які користувались міжміським зв'язком
        printLongDistanceUsers(phones);

        // абоненти, чий номер рахунку знаходиться у вказаному діапазоні
        System.out.print("Введіть мінімальний номер рахунку (6 цифр): ");
        String minAccountNumber = scanner.next();
        System.out.print("Введіть максимальний номер рахунку (6 цифр): ");
        String maxAccountNumber = scanner.next();
        printAccountsInRange(phones, minAccountNumber, maxAccountNumber);

        scanner.close();
    }

    // абоненти з міськими розмовами більше заданого
    public static void printCityTalkTimeGreaterThan(Phone[] phones, String input) {
        try {
            // Перевіряємо, чи є введене значення числом
            int minTime = Integer.parseInt(input);

            // Перевіряємо, чи є число позитивним
            if (minTime < 0) {
                throw new IllegalArgumentException("Час не може бути від'ємним.");
            }

            System.out.println("\nАбоненти, у яких час міських розмов більше " + minTime + ":");
            boolean found = false;
            for (Phone phone : phones) {
                if (phone.getCityTalkTime() > minTime) {
                    System.out.println(phone);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Немає абонентів, які перевищують цей час міських розмов.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено некоректне число.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    // абоненти, які користувались міжміським зв'язком
    public static void printLongDistanceUsers(Phone[] phones) {
        System.out.println("\nАбоненти, які користувались міжміським зв'язком:");
        for (Phone phone : phones) {
            if (phone.getLongDistanceTalkTime() > 0) {
                System.out.println(phone);
            }
        }
    }

    // абоненти з номером рахунку в заданому діапазоні
    public static void printAccountsInRange(Phone[] phones, String minAccount, String maxAccount) {
        try {
            // Перевірка, чи є введені номери рахунків шестизначними
            if (minAccount.length() != 6 || maxAccount.length() != 6) {
                throw new IllegalArgumentException("Номер рахунку повинен складатись з 6 цифр.");
            }

            System.out.println("\nАбоненти з номером рахунку в діапазоні від " + minAccount + " до " + maxAccount + ":");
            boolean found = false;
            for (Phone phone : phones) {
                if (phone.getAccountNumber().compareTo(minAccount) >= 0 && phone.getAccountNumber().compareTo(maxAccount) <= 0) {
                    System.out.println(phone);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Абоненти не знайдені у вказаному діапазоні.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

}