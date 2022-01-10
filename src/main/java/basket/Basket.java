package basket;


import products.ProductMapProvider;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Basket {

    List<Product> basketList = new ArrayList<>();
    Map<Integer, Product> productMap =
            new ProductMapProvider().makeProductMap();

    public void printAllProductsInShop() {
        for (Map.Entry<Integer, Product> p : productMap.entrySet()) {
            System.out.println(p.getKey() + " = "
                    + p.getValue());
        }
    }

    public void addNewItemToBasket(int idProduct) {
        basketList.add(productMap.get(idProduct));
    }

    public void removeProductFromBasket(int idProduct) {
        basketList.remove(productMap.get(idProduct));
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
