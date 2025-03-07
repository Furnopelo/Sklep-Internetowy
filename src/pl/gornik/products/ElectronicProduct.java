package pl.gornik.products;

public class ElectronicProduct extends Product {
    private final String warranty;

    public ElectronicProduct(String name, double price, int quantity, String warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
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
        System.out.print(" | Gwarancja: " + warranty);
    }
}