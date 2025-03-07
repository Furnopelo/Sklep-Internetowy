package pl.gornik;

import pl.gornik.products.Product;

public class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public void showcaseProduct() {
        int forcedNameLength = 35 - getName().length();
        int forcedPriceLength = 6 - String.valueOf(getPrice()).length();

        System.out.print(getName());
        for (int i = 0; i < forcedNameLength; i++) {
            System.out.print(".");
        }
        System.out.print(" | " + getPrice() + "zł");
        for (int i = 0; i < forcedPriceLength; i++) {
            System.out.print(" ");
        }
        System.out.print(" | Data ważności: " + expirationDate);
    }
}