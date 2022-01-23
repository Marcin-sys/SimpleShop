package basket.factory;

import menu.MenuProvider;

import java.util.Scanner;


public class ShoppingJourney {
    private ShopService shopService = new ShopService();
    private UserInputProvider input = new UserInputProvider();
    private final String menu = new MenuProvider().menu();


    public ShoppingJourney(ShopService shopService, UserInputProvider input) {
        this.shopService = shopService;
        this.input = input;
    }
    public ShoppingJourney (){}

    public void shopManagerMenu() {
        int choiceEntry;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println(menu); //+
                choiceEntry = input.getValidIntInput(1, 6, sc);//min and max case

                switch (choiceEntry) {
                    case 1:  //1. Check all product's
                        shopService.printAllProductsInShop();
                        break;
                    case 2:  //Add new product to basket
                        shopService.addNewProductToBasket(sc);
                        break;
                    case 3: //Remove product from basket ;
                        shopService.removeProductFromBasket(sc);
                        break;
                    case 4: //Check what is inside basket
                        shopService.showWhatInsideBasket();
                        break;
                    case 5: // Pay for all product inside basket
                        shopService.payForBasket();
                        break;
                    case 6:  //End shopping
                        break;
                    default:
                        System.out.println(" You chose bad number, " +
                                "must be value between 1 and 6.");
                }
            } while (choiceEntry != 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}