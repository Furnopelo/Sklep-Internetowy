package pl.gornik;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shop electronic_shop = new Shop();

        electronic_shop.addProductToShop(new Product("Klawiatura mechaniczna", 250, 50));
        electronic_shop.addProductToShop(new Product("Słuchawki bezprzewodowe", 320, 30));
        electronic_shop.addProductToShop(new Product("Smartwatch", 500, 20));
        electronic_shop.addProductToShop(new Product("Mysz gamingowa", 180, 40));
        electronic_shop.addProductToShop(new Product("Monitor 27 cali", 1200, 15));
        electronic_shop.addProductToShop(new Product("Powerbank 20 000 mAh", 150, 60));
        electronic_shop.addProductToShop(new Product("Głośnik Bluetooth", 220, 25));
        electronic_shop.addProductToShop(new Product("Dysk SSD 1TB", 430, 35));
        electronic_shop.addProductToShop(new Product("Drukarka laserowa", 700, 10));
        electronic_shop.addProductToShop(new Product("Kabel USB-C 2m", 30, 100));

        System.out.println("--- REJESTRACJA ---");
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj email: ");
        String email = scanner.nextLine();

        Client client = new Client(name, surname, email);

        System.out.println("\n --- SKLEP INTERNETOWY ---");
        electronic_shop.showcaseShopProducts();

        System.out.print("Podaj czynność (wpisz 'pomoc' po listę): ");
        String option = scanner.nextLine();

        while (!option.equalsIgnoreCase("wyjscie")) {
            if (option.equalsIgnoreCase("pomoc")) {
                System.out.println("\n --- POMOC ---");
                System.out.println("Dodaj (nazwa przedmiotu) - Dodaje wpisany przedmiot do koszyka");
                System.out.println("Produkty - Wyświetla dostępne produjty w sklepie");
                System.out.println("Koszyk - Wyświetla koszyk");
            }

            else if (option.toLowerCase().startsWith("dodaj ")) {
                String productName = option.substring(6).trim();
                Product foundProduct = electronic_shop.findProductByName(productName);

                if (foundProduct != null) {
                    client.addProductToCart(foundProduct);
                    System.out.println("Produkt został pomyślnie dodany do koszyka.");
                }
                else System.out.println("Produkt nie znaleziony.");
            }

            else if (option.equalsIgnoreCase("produkty")) {
                System.out.println(" ");
                electronic_shop.showcaseShopProducts();
            }

            else if (option.equalsIgnoreCase("koszyk")) {
                System.out.println(" ");
                client.showcaseCart();
            }

            else System.out.println("Podano niewłaściwą czynność.");

            System.out.println(" ");
            System.out.print("Podaj czynność (wpisz 'pomoc' po listę): ");
            option = scanner.nextLine();
        }
    }
}