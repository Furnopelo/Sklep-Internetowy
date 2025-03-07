package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();

    public void addNewProduct(String name, double price, int quantity) {
        if (findProductByName(name) != null) {
            System.out.println("Produkt o tej nazwie już istnieje!");
            return;
        }

        Product newProduct = new Product(name, price, quantity);
        addProductToShop(newProduct);
        System.out.println("Produkt dodany pomyślnie: " + name);
    }

    public void addProductToShop(Product product) {
        this.products.add(product);
    }

    public void removeProductFromShop(String name) {
        Product product = findProductByName(name);
        if (product != null) {
            products.remove(product);
            System.out.println("Produkt " + name + " został usunięty ze sklepu.");
        } else {
            System.out.println("Nie znaleziono produktu o nazwie: " + name);
        }
    }

    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) return product;
        }
        return null;
    }

    public void updateStockAfterPurchase(List<Product> purchasedProducts) {
        for (Product purchasedProduct : purchasedProducts) {
            Product shopProduct = findProductByName(purchasedProduct.getName());
            if (shopProduct != null) {
                shopProduct.setQuantity(shopProduct.getQuantity() - 1);
            }
        }
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
