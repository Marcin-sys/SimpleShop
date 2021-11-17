package basket.factory;

import basket.AddNewProduct;
import basket.PayForBasket;
import basket.RemoveProduct;
import menu.Menu;
import products.Products;

import java.util.Scanner;

public class Factory {
    int choiceEntry = -1;
    public Factory() {
        new Products().makeListOfProducts();
    }
    public void chooseNumberFromMenu(){
        Scanner sc = new Scanner(System.in);
        do {
            choiceEntry = sc.nextInt();
            switch (choiceEntry) {
                case 1:
                    new Products().showProductList();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 2:
                    new AddNewProduct().addNewProductToBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 3:
                    new RemoveProduct().removeProductFromBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 4:
                    new PayForBasket().showWhatInsideBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 5:
                    new PayForBasket().payForBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("You chose bad number, must be value between 1 and 6.");
            }
        }while (choiceEntry!=6);
    }
}
