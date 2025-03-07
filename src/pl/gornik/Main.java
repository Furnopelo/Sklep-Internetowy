package pl.gornik;

import pl.gornik.enums.OrderStatus;
import pl.gornik.enums.PaymentType;
import pl.gornik.products.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shop shop = new Shop();

        shop.addNewProduct("Klawiatura mechaniczna", 250, 50, "electronic", "2 lata");
        shop.addNewProduct("Słuchawki bezprzewodowe", 320, 30, "electronic", "1 rok");
        shop.addNewProduct("Smartwatch", 500, 20, "electronic", "3 lata");
        shop.addNewProduct("Mysz gamingowa", 180, 40, "electronic", "1 rok");
        shop.addNewProduct("Monitor 27 cali", 1200, 15, "electronic", "2 lata");
        shop.addNewProduct("Powerbank 20 000 mAh", 150, 60, "electronic", "1 rok");
        shop.addNewProduct("Głośnik Bluetooth", 220, 25, "electronic", "1 rok");
        shop.addNewProduct("Dysk SSD 1TB", 430, 35, "electronic", "2 lata");
        shop.addNewProduct("Drukarka laserowa", 700, 10, "electronic", "1 rok");
        shop.addNewProduct("Kabel USB-C 2m", 30, 100, "electronic", "1 rok");

        shop.addNewProduct("Władca Pierścieni", 50, 20, "book", "J.R.R. Tolkien");
        shop.addNewProduct("Harry Potter i Kamień Filozoficzny", 40, 30, "book", "J.K. Rowling");
        shop.addNewProduct("1984", 35, 25, "book", "George Orwell");
        shop.addNewProduct("Zbrodnia i kara", 45, 15, "book", "Fiodor Dostojewski");
        shop.addNewProduct("Mistrz i Małgorzata", 55, 10, "book", "Michaił Bułhakow");

        shop.addNewProduct("Koszulka bawełniana", 80, 50, "clothing", "M");
        shop.addNewProduct("Spodnie dżinsowe", 120, 40, "clothing", "L");
        shop.addNewProduct("Kurtka zimowa", 300, 20, "clothing", "XL");
        shop.addNewProduct("Buty sportowe", 200, 30, "clothing", "42");
        shop.addNewProduct("Czapka z daszkiem", 50, 60, "clothing", "One Size");

        shop.addNewProduct("Chleb razowy", 5, 100, "food", "2023-12-01");
        shop.addNewProduct("Mleko 3,2%", 3, 80, "food", "2023-11-15");
        shop.addNewProduct("Jogurt naturalny", 2, 120, "food", "2023-11-20");
        shop.addNewProduct("Ser żółty", 10, 50, "food", "2023-12-10");
        shop.addNewProduct("Pomarańcze", 8, 70, "food", "2023-11-25");

        System.out.println("--- REJESTRACJA DO SKLEPU ---");
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();

        Client client = new Client(name, surname, email);

        System.out.println("\n --- SKLEP INTERNETOWY ---");
        shop.showcaseShopProducts();

        System.out.println(" ");
        System.out.print("Podaj czynność (wpisz 'pomoc' po listę): ");
        String option = scanner.nextLine();

        while (!option.equalsIgnoreCase("wyjscie")) {
            if (option.equalsIgnoreCase("pomoc")) {
                System.out.println("\n --- POMOC ---");
                System.out.println("Dodaj (nazwa produktu) - Dodaje wpisany produkt do koszyka");
                System.out.println("Usuń (nazwa produktu) - Usuwa wpisany produkt z koszyka");
                System.out.println("Produkty - Wyświetla dostępne produjty w sklepie");
                System.out.println("Koszyk - Wyświetla koszyk");
                System.out.println("Zapłać - Przechodzi do płatności za zakupy");
                System.out.println("Zamówienia - Wyświetla wszystkie aktywne zamówienia");
                System.out.println();
                System.out.println("CZYNNOŚCI ADMINISTRATORA");
                System.out.println("Dodaj produkt (nazwa produktu) (cena) (ilość [opcjonalne]) - Dodaje nowy produkt do sklepu");
                System.out.println("Usuń produkt (nazwa produktu) - Usuwa produkt ze sklepu");
            }

            else if (option.toLowerCase().startsWith("dodaj produkt ")) {
                try {
                    String[] parts = option.substring(14).split(" ");
                    String productName = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    int quantity = (parts.length > 2) ? Integer.parseInt(parts[2]) : 1;

                    System.out.println();

                    shop.addNewProduct(productName, price, quantity, "electronic", "1 rok");
                } catch (Exception e) {
                    System.out.println("Niepoprawny format! Użyj: Dodaj produkt (nazwa [bez spacji]) (cena) (ilość opcjonalnie)");
                }
            }

            else if (option.toLowerCase().startsWith("usuń produkt ") || option.toLowerCase().startsWith("usun produkt ")) {
                System.out.println();
                String productName = option.substring(13).trim();
                shop.removeProductFromShop(productName);
            }

            else if (option.toLowerCase().startsWith("dodaj ") || option.toLowerCase().startsWith("usuń ") || option.toLowerCase().startsWith("usun ")) {

                boolean isAdding = option.toLowerCase().startsWith("dodaj ");
                int commandLength = isAdding ? 6 : 5;

                String productName = option.substring(commandLength).trim();
                Product foundProduct = shop.findProductByName(productName);

                System.out.println(" ");

                if (foundProduct != null) {
                    if (isAdding || foundProduct.getQuantity() > 0) {
                        client.addProductToCart(foundProduct);
                    }
                    else if (isAdding || foundProduct.getQuantity() == 0) {
                        System.out.println("Produktu nie ma już w sklepie.");
                    }
                    else {
                        client.removeProductFromCart(foundProduct);
                    }
                } else {
                    System.out.println("Produkt nie znaleziony.");
                }
            }

            else if (option.equalsIgnoreCase("produkty")) {
                System.out.println(" ");
                shop.showcaseShopProducts();
            }

            else if (option.equalsIgnoreCase("koszyk")) {
                System.out.println(" ");
                client.showcaseCart();
            }

            else if (option.equalsIgnoreCase("zapłać") || option.equalsIgnoreCase("zaplac")) {
                if (client.getCart().isEmpty()) {
                    System.out.println(" ");
                    System.out.println("Koszyk jest pusty! Dodaj produkty przed zapłatą.");
                } else {
                    System.out.println(" ");
                    double totalAmount = client.calculateTotalCartPrice();
                    System.out.println("Łączna kwota do zapłaty: " + totalAmount);

                    System.out.println("Wybierz metodę płatności");
                    System.out.println("1 - Gotówka");
                    System.out.println("2 - BLIK");
                    System.out.println("3 - Karta");
                    String paymentOption = scanner.nextLine();

                    Payment payment = new Payment();

                    switch (paymentOption) {
                        case "1":
                            payment.processPayment(totalAmount, PaymentType.CASH);
                            break;
                        case "2":
                            payment.processPayment(totalAmount, PaymentType.BLIK);
                            break;
                        case "3":
                            payment.processPayment(totalAmount, PaymentType.CARD);
                            break;
                        default:
                            System.out.println("Nieprawidłowa opcja płatności.");
                    }

                    if (paymentOption.equals("1") || paymentOption.equals("2") || paymentOption.equals("3")) {
                        Order order = new Order(client, client.getCart());
                        order.setStatus(OrderStatus.NEW);
                        System.out.println("Zamówienie zostało utworzone.");

                        shop.updateStockAfterPurchase(client.getCart());

                        client.getCart().clear();
                    }
                    else System.out.println("Zamówienie anulowane, spróbuj ponownie.");
                }
            }

            else if (option.equalsIgnoreCase("zamówienia ") || option.equalsIgnoreCase("zamowienia")) {
                client.showcaseOrders();
            }

            else System.out.println("Podano niewłaściwą czynność.");

            System.out.println(" ");
            System.out.print("Podaj czynność (wpisz 'pomoc' po listę): ");
            option = scanner.nextLine();
        }
    }
}