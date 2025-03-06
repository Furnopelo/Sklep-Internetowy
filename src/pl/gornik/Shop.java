package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();

    public void addProductToShop(Product product) {
        this.products.add(product);
    }

    public void removeProductFromShop(Product product) {
        if (this.products.contains(product)) {
            this.products.remove(product);
        }
        else {System.out.println("Nie ma takiego produktu");}
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) return product;
        }
        return null;
    }

    public void showcaseShopProducts() {
        System.out.println("Dostępne produkty: ");
        System.out.println("NAZWA | KOSZT | DOSTĘPNA ILOŚĆ");

        for (Product product : products) {
            product.showcaseProduct();
            System.out.print(" | " + product.getQuantity() + "\n");
        }
    }
}
