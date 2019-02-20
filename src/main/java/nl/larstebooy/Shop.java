package nl.larstebooy;

import nl.larstebooy.model.Cart;
import nl.larstebooy.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Shop {
    private static Logger logger = LoggerFactory.getLogger(Shop.class);

    private Map<String, Product> stock = SupermarketStock.getStock();
    private String productToBuy = "";
    private int quantity = 0;

    Cart cart = new Cart();

    public void startShopping() {

        //Customer looks for a specific product
        searchForProduct();

        //If the Supermarket has the product the customer can specify how many he wants
        if(stock.containsKey(productToBuy)){
            howMany();
        }

        buyProduct(stock, productToBuy, quantity);

    }

    private void searchForProduct() {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);

            String input = br.readLine();
            productToBuy = input.substring(0, 1).toUpperCase() + input.substring(1);

            if (!stock.containsKey(productToBuy)) {
                System.out.println(String.format("Sorry, but we don't have %s", productToBuy));
            }

        } catch (Exception e) {
            logger.error("Exception has occured ", e);
        }
    }

    private void howMany() {
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);

            System.out.println(String.format("How many %s would you like to buy?", productToBuy));

            String input = br.readLine();
            quantity = Integer.valueOf(input);

            if(stock.get(productToBuy).getQuantity() < quantity){
                System.out.println(String.format("Sorry but we dont have this many %s", productToBuy));
            }

        } catch (Exception e) {
            logger.error("");
        }
    }

    private void buyProduct(final Map<String, Product> stock, final String productName, final int quantity) {
        Product productInStock = stock.get(productName);

        productInStock.setQuantity((productInStock.getQuantity() - quantity));

        cart.getCart().add(productInStock);
    }
}
