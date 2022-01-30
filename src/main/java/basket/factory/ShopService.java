package basket.factory;

import products.Product;
import products.ProductMapProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShopService {
    public ShopService() {
    }

    public ShopService(UserInputProvider input) {
        this.input = input;
    }

    public ShopService(SystemPrinter systemPrinter) {
        this.systemPrinter = systemPrinter;
    }

    SystemPrinter systemPrinter = new TextPrinter();
    Map<Integer, Product> productHashMap =
            new ProductMapProvider().makeProductMap();
    UserInputProvider input = new UserInputProvider();
    List<Product> basketList = new ArrayList<>();

    private int productId;
    private final int productMapSize = productHashMap.size();


    public void printAllProductsInShop() {
        for (Map.Entry<Integer, Product> p : productHashMap.entrySet()) {
            systemPrinter.printString(p.getKey() + " = "
                    + p.getValue());
        }
    }

    public void addNewProductToBasket(Scanner sc) {
        System.out.println("Choose product number to be added to basket");
        productId = input.getValidIntInput(0, productMapSize - 1, sc);
        basketList.add(productHashMap.get(productId));

    }

    public void removeProductFromBasket(Scanner sc) {
        System.out.println("Choose product number  to be removed from basket");
        productId = input.getValidIntInput(0, productMapSize - 1, sc);
        basketList.remove(productHashMap.get(productId));
    }

    public void showWhatInsideBasket() {
        for (Product product : basketList) {
            systemPrinter.printString(product.name());
        }
    }

    public void payForBasket() {
        double sumBasketPrice = basketList.stream().mapToDouble(Product::price).sum();
        systemPrinter.printString("Total price is: "
                + sumBasketPrice + " PLN");
    }
}