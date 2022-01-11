package basket.factory;

import products.Product;
import products.ProductMapProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShopService {
    Map<Integer, Product> productHashMap =
            new ProductMapProvider().makeProductMap();
    int productId;
    int productListSize = productHashMap.size() - 1;
    UserInputProvider input = new UserInputProvider();
    List<Product> basketList = new ArrayList<>();

    public void printAllProductsInShop() {
        for (Map.Entry<Integer, Product> p : productHashMap.entrySet()) {
            System.out.println(p.getKey() + " = "
                    + p.getValue());
        }
    }

    public void addNewProductToBasket(Scanner sc) {
        System.out.println("Choose product id to be added to basket");
        productId = input.getValidIntInput(0, productListSize, sc);
        basketList.add(productHashMap.get(productId));
    }

    public void removeProductFromBasket(Scanner sc) {
        System.out.println("Choose product id to be removed from basket");
        productId = input.getValidIntInput(0, productListSize, sc);
        basketList.remove(productHashMap.get(productId));
    }

    public void showWhatInsideBasket() {
        for (Product product : basketList) {
            System.out.println(product.name());
        }
    }

    public void payForBasket() {
        double sumBasketPrice = basketList.stream().mapToDouble(Product::price).sum();

        System.out.println("Total price is: "
                + sumBasketPrice + " PLN");
    }
}