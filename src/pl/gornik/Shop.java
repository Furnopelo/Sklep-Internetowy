package pl.gornik;

import pl.gornik.products.BookProduct;
import pl.gornik.products.ElectronicProduct;
import pl.gornik.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Product> products = new ArrayList<>();

    public void addNewProduct(String name, double price, int quantity, String type, String additionalInfo) {
        if (findProductByName(name) != null) {
            System.out.println("Produkt o tej nazwie już istnieje!");
            return;
        }

        Product newProduct;
        switch (type.toLowerCase()) {
            case "electronic":
                newProduct = new ElectronicProduct(name, price, quantity, additionalInfo);
                break;
            case "book":
                newProduct = new BookProduct(name, price, quantity, additionalInfo);
                break;
            case "clothing":
                newProduct = new pl.gornik.ClothingProduct(name, price, quantity, additionalInfo);
                break;
            case "food":
                newProduct = new pl.gornik.FoodProduct(name, price, quantity, additionalInfo);
                break;
            default:
                System.out.println("Nieznany typ produktu.");
                return;
        }

        addProductToShop(newProduct);
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
        System.out.println("NAZWA | KOSZT | DODATKOWE INFORMACJE | DOSTĘPNA ILOŚĆ");

        List<Product> electronicProducts = new ArrayList<>();
        List<Product> bookProducts = new ArrayList<>();
        List<Product> clothingProducts = new ArrayList<>();
        List<Product> foodProducts = new ArrayList<>();

        for (Product product : products) {
            if (product instanceof ElectronicProduct) {
                electronicProducts.add(product);
            } else if (product instanceof BookProduct) {
                bookProducts.add(product);
            } else if (product instanceof pl.gornik.ClothingProduct) {
                clothingProducts.add(product);
            } else if (product instanceof pl.gornik.FoodProduct) {
                foodProducts.add(product);
            }
        }

        if (!electronicProducts.isEmpty()) {
            System.out.println("\n--- ELEKTRONIKA");
            for (Product product : electronicProducts) {
                product.showcaseProduct();
                System.out.print(" | " + product.getQuantity() + "\n");
            }
        }

        if (!bookProducts.isEmpty()) {
            System.out.println("\n--- KSIĄŻKI");
            for (Product product : bookProducts) {
                product.showcaseProduct();
                System.out.print(" | " + product.getQuantity() + "\n");
            }
        }

        if (!clothingProducts.isEmpty()) {
            System.out.println("\n--- ODZIEŻ");
            for (Product product : clothingProducts) {
                product.showcaseProduct();
                System.out.print(" | " + product.getQuantity() + "\n");
            }
        }

        if (!foodProducts.isEmpty()) {
            System.out.println("\n--- ŻYWNOŚĆ");
            for (Product product : foodProducts) {
                product.showcaseProduct();
                System.out.print(" | " + product.getQuantity() + "\n");
            }
        }

        if (electronicProducts.isEmpty() && bookProducts.isEmpty() && clothingProducts.isEmpty() && foodProducts.isEmpty()) {
            System.out.println("Brak dostępnych produktów.");
        }
    }
}