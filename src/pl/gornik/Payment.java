package pl.gornik;

import pl.gornik.enums.PaymentType;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Payment {
    Scanner scanner = new Scanner(System.in);

    public void processPayment(double amount, PaymentType paymentType) {
        LocalDateTime localTime = LocalDateTime.now();

        switch (paymentType) {
            case CASH -> {
                double value;
                do {
                    System.out.print("Wpisz kwotę: ");
                    value = scanner.nextDouble();
                    if (value < amount) System.out.println("To za mało. Spróbuj ponownie.");
                } while (value < amount);

                System.out.println("Zapłacono gotówką: " + amount);
                if (value > amount) System.out.println("Reszta: " + (value - amount));
            }
            case BLIK -> {
                String blikCode = getCode("kod BLIK", 6);
                System.out.println("Płacę BLIKiem...");
                System.out.println();
                System.out.println("Pobrano kwotę: " + amount);
            }
            case CARD -> {
                String pinCode = getCode("PIN karty", 4);
                System.out.println("Płacę kartą...");
                System.out.println();
                System.out.println("Pobrano kwotę: " + amount);
            }
        }

        System.out.println("Data transakcji: " + localTime);
    }

    public String getCode(String text, int number) {
        String code;
        boolean isDigit;

        do {
            isDigit = true;

            System.out.print("Podaj " + text + ": ");
            code = scanner.next();

            for (int i = 0; i < code.length(); i++) {
                if (!Character.isDigit(code.charAt(i))) ;
                isDigit = false;
                break;
            }
        } while (code.length() != number || isDigit);

        return code;
    }
}
