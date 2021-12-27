package basket.factory;

import basket.AddNewProduct;
import basket.PayForBasket;
import basket.RemoveProduct;
import menu.Menu;
import products.ProductList;
import products.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShopManager {

    List<Products> productsArrayList = new ProductList().makeProductList();
    String menu = new Menu().returnMenuListInString();
//    new AddNewProduct().addNewProductToBasket();
//    new RemoveProduct().removeProductFromBasket();
//    new PayForBasket().showWhatInsideBasket();
//    new PayForBasket().payForBasket();

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
                        for (Products products : productsArrayList) System.out.println(products.name()
                                +" price: "+ products.price());

                        System.out.println(menu);
                        break;
                    case 2:  //Add new product to basket
                        new AddNewProduct().addNewProductToBasket();
                        System.out.println(menu);
                        break;
                    case 3: //Remove product from basket
                        new RemoveProduct().removeProductFromBasket();
                        System.out.println(menu);
                        break;
                    case 4: //Check what is inside basket
                        new PayForBasket().showWhatInsideBasket();
                        System.out.println(menu);
                        break;
                    case 5: // Pay for all product inside basket
                        new PayForBasket().payForBasket();
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
