package basket.factory;

import basket.Basket;
import menu.Menu;
import products.ProductList;
import products.Product;

import java.util.List;
import java.util.Scanner;


public class ShopManager {
    List<Product> listOfProducts = new ProductList().makeProductList();
    String menu = new Menu().printMainMenu();
    Basket basket = new Basket();
    int productId;
    int productListSize = listOfProducts.size() - 1;

    public void shopManagerMenu() {
        int choiceEntry = -1;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println(menu);
            do {
                choiceEntry = getValidIntInput(1,6,sc); //min and max case
                switch (choiceEntry) {
                    case 1:  //1. Check all product's
                        for (Product product : listOfProducts)
                            System.out.println("ID " + product.id() + " name:" + product.name()
                                    + " price: " + product.price());
                        System.out.println(menu);
                        break;
                    case 2:  //Add new product to basket
                        System.out.println("Choose product id to be added to basket");
                        productId = getValidIntInput(0, productListSize, sc);
                        basket.addNewItemToBasket(productId);
                        System.out.println(menu);
                        break;

                    case 3: //Remove product from basket
                        System.out.println("Choose product id to be removed from basket");
                        productId = getValidIntInput(0, productListSize, sc);
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

    private int getValidIntInput(int min, int max, Scanner scanner) {
        Integer result = null;
        do {
            if (result != null) {
                System.out.println("Invalid value, must be an integer value between " + min + " and " + max);
            }
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid value, must be an integer value between " + min + " and " + max);
                scanner.next();
            }
            result = scanner.nextInt();
        } while (result < min || result > max);
        return result;
    }
}
