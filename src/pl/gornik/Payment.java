package pl.gornik;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Payment {
    Scanner scanner = new Scanner(System.in);

    private double price;
    private PaymentType paymentType;

    public void processCashPayment(double amount) {
        double value = 0;

        while (value < amount) {
            System.out.print("Wpisz kwotę: ");
            value = scanner.nextDouble();
            if (value < amount) System.out.println("To za mało. Spróbuj ponownie");
        }
        LocalDateTime localTime = LocalDateTime.now();

        System.out.println("Zapłacono gotówką " + amount);
        if (value > amount) System.out.println("Reszta: " + (value - amount));
        System.out.println(localTime);
    }

    public void processBLIKPayment(double amount) {
        LocalDateTime localTime = LocalDateTime.now();

        String blikCode = getCode("kod BLIK", 6);
        System.out.println("Płacę BLIKiem...");
        System.out.println("Pobrano kwotę: " + amount);
        System.out.println(localTime);
    }

    public void processCardPayment(double amount) {
        LocalDateTime localTime = LocalDateTime.now();

        String pinCode = getCode("PIN karty", 4);
        System.out.println("Płacę kartą...");
        System.out.println("Pobrano kwotę: " + amount);
        System.out.println(localTime);
    }

    public String getCode(String text, int number) {
        String code;
        boolean isDigit;

        do {
            isDigit = true;

            System.out.print("Podaj " + text + ": ");
            code = scanner.next();

            for (int i = 0; i < code.length(); i++) {
                if (!Character.isDigit(code.charAt(i))); isDigit = false; break;
            }
        } while (code.length() != number || isDigit);

        return code;
    }
}
