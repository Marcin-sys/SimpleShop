package basket;


import products.ProductList;
import products.Products;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Products> basketList = new ArrayList<>();
    List<Products> listOfProducts = new ProductList().makeProductList();

    public void addNewItemToBasket(int idProduct) {
        basketList.add(listOfProducts.get(idProduct));
    }

    public void removeProductFromBasket(int idProduct) {
        basketList.remove(listOfProducts.get(idProduct));
    }

    public void showWhatInsideBasket() {
        for (Products products : basketList) {
            System.out.println(products.name());
        }
    }

    public void payForBasket() {
        int sumBasketPrice = 0;
        for (Products products : basketList) {
            sumBasketPrice += products.price();
        }
        System.out.println("Total price is: "
                + sumBasketPrice + " PLN");
    }
}
