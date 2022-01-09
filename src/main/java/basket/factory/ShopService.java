package basket.factory;

import basket.Basket;
public class ShopService {

    public Basket addNewProductToBasket(Basket basket, int productId) {
        basket.addNewItemToBasket(productId);
        return basket;
    }

    public Basket removeProductFromBasket(Basket basket, int productId) {
        basket.removeProductFromBasket(productId);
        return basket;
    }
}
