package pl.gornik.products;

public class BookProduct extends Product {
    private String author;

    public BookProduct(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
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
        System.out.print(" | Autor: " + author);
    }
}