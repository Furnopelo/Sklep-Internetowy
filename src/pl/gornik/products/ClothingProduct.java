package pl.gornik;

import pl.gornik.products.Product;

public class ClothingProduct extends Product {
    private String size;

    public ClothingProduct(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
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
        System.out.print(" | Rozmiar: " + size);
    }
}