package nl.larstebooy;

import nl.larstebooy.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SupermarketStock.setupStock();
        Shop shop = new Shop();

        System.out.println("Welcome to our supermarket, this is our stock: ");
        System.out.println("");
        SupermarketStock.getStock().forEach((key, product) ->
            System.out.println(String.format("%s: price = €%.2f, quantity = %d", product.getName(), product.getPrice(), product.getQuantity())));

        System.out.println("");
        System.out.println("What do you want to buy?");

        shop.startShopping();

        SupermarketStock.getStock().forEach((key, product) ->
                System.out.println(String.format("%s: price = €%.2f, quantity = %d", product.getName(), product.getPrice(), product.getQuantity())));

    }


}
