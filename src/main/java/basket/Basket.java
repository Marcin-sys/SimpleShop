package basket;


import products.ProductList;
import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Product> basketList = new ArrayList<>();
    List<Product> listOfProducts = new ProductList().makeProductList();

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
        int sumBasketPrice = 0;
        for (Product product : basketList) {
            sumBasketPrice += product.price();
        }
        System.out.println("Total price is: "
                + sumBasketPrice + " PLN");
    }
}
