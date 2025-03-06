package pl.gornik;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String surname;
    private String email;
    private List<Product> cart = new ArrayList<>();

    public void addProductToCart (Product product) {
        cart.add(product);
    }

    public void showcaseCart() {
        if (cart.isEmpty()) System.out.println("Nie masz żadnych produktów w koszyku.");
        else {
            System.out.println("Produkty w koszyku: ");
            for (Product product : cart) {
                product.showcaseProduct();
                System.out.print("\n");
            }
        }
    }

    public Client(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
