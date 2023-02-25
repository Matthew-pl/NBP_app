package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
//        private static final Scanner scanner = new Scanner(System.in);

        public float getAmountFromUser () {

            System.out.println("Please provide amount of PLN that you would like to exchange.");
            Scanner scanner = new Scanner(System.in);
            Float possesedPLN = null;
            while (possesedPLN == null) {
                try {
                    possesedPLN = scanner.nextFloat();
                } catch (InputMismatchException e) {
                    System.out.println("You have to specify number in float type. Please try again.");
                    scanner.nextLine();
                }
            }
            return possesedPLN;
        }

        public String getCurrencyFromUser () {
            System.out.println("Please provide three letter currency code that you would like to buy for PLN with today's rate, or enter \"X\" to view list of all currencies");
            Scanner scanner = new Scanner(System.in);
            String currency = null;
            currency = scanner.nextLine();
//          TODO - sprawdzenie czy podana waluta występuje
//            while (currency == null) {
//                try {
//                    currency = scanner.nextLine();
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
            return currency;
        }

}
