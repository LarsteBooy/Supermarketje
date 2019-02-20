package nl.larstebooy;

import nl.larstebooy.model.Product;

import java.util.HashMap;
import java.util.Map;

public class SupermarketStock {

    private static Map<String, Product> stock = new HashMap<>();

    public static Map<String, Product> getStock() {
        return stock;
    }

    public static void setStock(Map<String, Product> stock) {
        SupermarketStock.stock = stock;
    }

    public static void setupStock() {
        stock.clear();

        Product robijn = new Product("Robijn", 3.0, 20);
        Product brinta = new Product("Brinta", 2.5, 25);
        Product chineseGroenten = new Product("Chinese Groenten", 5.0, 85);
        Product kwark = new Product("Kwark", 2.0, 16);
        Product luiers = new Product("Luiers", 10.0, 12);

        stock.put("Robijn", robijn);
        stock.put("Brinta", brinta);
        stock.put("Chinese Groenten", chineseGroenten);
        stock.put("Kwark", kwark);
        stock.put("Luiers", luiers);

    }

}
