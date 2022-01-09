package basket.factory;

import basket.Basket;
import menu.Menu;
import products.Product;
import products.ProductListProvider;

import java.util.List;
import java.util.Scanner;


public class ShoppingJourney {
    ShopService shopService = new ShopService();
    Basket basket = new Basket();
    UserInputProvider input = new UserInputProvider();

    String menu = new Menu().mainMenuProvider();
    List<Product> listOfProducts = new ProductListProvider().makeProductList();


    int productId;
    int productListSize = listOfProducts.size() - 1;

    public void shopManagerMenu() {
        int choiceEntry = -1;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println(menu); //+
                choiceEntry = input.getValidIntInput(1, 6, sc); //min and max case
                switch (choiceEntry) {
                    case 1:  //1. Check all product's
                        basket.printAllProductsInShop();
                        break;
                    case 2:  //Add new product to basket
                        System.out.println("Choose product id to be added to basket");
                        productId = input.getValidIntInput(0, productListSize, sc);
                        basket = shopService.addNewProductToBasket(basket, productId);
                        break;
                    case 3: //Remove product from basket
                        System.out.println("Choose product id to be removed from basket");
                        productId = input.getValidIntInput(0, productListSize, sc);
                        basket = shopService.removeProductFromBasket(basket, productId);
                        break;
                    case 4: //Check what is inside basket
                        basket.showWhatInsideBasket();
                        break;
                    case 5: // Pay for all product inside basket
                        basket.payForBasket();
                        break;
                    case 6:  //End shopping
                        break;
                    default:
                        System.out.println("You chose bad number, " +
                                "must be value between 1 and 6.");
                }
            } while (choiceEntry != 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
