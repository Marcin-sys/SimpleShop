package basket;


import products.ProductListProvider;
import products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Basket {

    List<Product> basketList = new ArrayList<>();
    List<Product> listOfProducts = new ProductListProvider().makeProductList();
//    Map<Integer,Product> mapOfProducts  = new

    public void addNewItemToBasket(int idProduct) {
        basketList.add(listOfProducts.get(idProduct));
    }

    public void removeProductFromBasket(int idProduct) {
        basketList.remove(listOfProducts.get(idProduct));
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
