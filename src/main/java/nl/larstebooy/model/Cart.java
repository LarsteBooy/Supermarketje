package nl.larstebooy.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }
}
