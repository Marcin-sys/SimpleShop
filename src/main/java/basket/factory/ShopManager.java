package basket.factory;

import basket.Basket;
import menu.Menu;
import products.ProductList;
import products.Products;

import java.util.List;
import java.util.Scanner;


public class ShopManager {
    List<Products> listOfProducts = new ProductList().makeProductList();
    String menu = new Menu().returnMenuListInString();
    Basket basket = new Basket();
    int productId;
    int productListSize = listOfProducts.size() - 1;

    public void chooseNumberFromMenu() {
        int choiceEntry = -1;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(menu);
            do {
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid value!, must be number between 1 and 6.");
                    sc.next();
                }
                choiceEntry = sc.nextInt();
                switch (choiceEntry) {
                    case 1:  //1. Check all product's
                        for (Products products : listOfProducts)
                            System.out.println("ID " + products.id() + " name:" + products.name()
                                    + " price: " + products.price());
                        System.out.println(menu);
                        break;
                    case 2:  //Add new product to basket
                        System.out.println("Choose product id to be added to basket");
                        while (!sc.hasNextInt() || sc.nextInt()>productListSize) {
                            System.out.println("Invalid value!, must be number between 0 and " + productListSize);
                            sc.next();
                        }
                        productId = sc.nextInt();
                        basket.addNewItemToBasket(productId);
                        System.out.println(menu);
                        break;

                    case 3: //Remove product from basket
                        System.out.println("Choose product id to be removed from basket");
                        while (!sc.hasNextInt() && sc.nextInt()>productListSize) {
                            System.out.println("Invalid value!, must be number between 0 and " + productListSize);
                            sc.next();
                        }
                        productId = sc.nextInt();
                        basket.removeProductFromBasket(productId);
                        System.out.println(menu);
                        break;
                    case 4: //Check what is inside basket
                        basket.showWhatInsideBasket();
                        System.out.println(menu);
                        break;
                    case 5: // Pay for all product inside basket
                        basket.payForBasket();
                        System.out.println(menu);
                        break;
                    case 6:  //End shopping
                        break;
                    default:
                        System.out.println("You chose bad number, must be value between 1 and 6.");
                }
            } while (choiceEntry != 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
