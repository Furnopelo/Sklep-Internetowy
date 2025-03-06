package pl.gornik;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void showcaseProduct() {
        int forcedNameLength = 35 - name.length();
        int forcedPriceLength = 6 - String.valueOf(price).length();

        System.out.print(name);
        for (int i = 0; i < forcedNameLength; i++) {
            System.out.print(".");
        }
        System.out.print(" | " + price + "zł");
        for (int i = 0; i < forcedPriceLength; i++) {
            System.out.print(" ");
        }
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
