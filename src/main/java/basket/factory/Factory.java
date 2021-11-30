package basket.factory;

import basket.AddNewProduct;
import basket.PayForBasket;
import basket.RemoveProduct;
import menu.Menu;
import products.ProductList;
import products.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class Factory {
    int choiceEntry = -1;
    ArrayList<Products> productsArrayList =  new ProductList().makeProductList();
    public Factory() {


    }
    public void chooseNumberFromMenu(){
        Scanner sc = new Scanner(System.in);
        do {
            choiceEntry = sc.nextInt();
            switch (choiceEntry) {
                case 1:  //1. Check all product's
                    for (Products products : productsArrayList) products.print();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 2:  //Add new product to basket
                    new AddNewProduct().addNewProductToBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 3: //Remove product from basket
                    new RemoveProduct().removeProductFromBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 4: //Check what is inside basket
                    new PayForBasket().showWhatInsideBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 5: // Pay for all product inside basket
                    new PayForBasket().payForBasket();
                    System.out.println("Please choose number from menu again.");
                    new Menu().menu();
                    break;
                case 6:  //End shopping
                    break;
                default:
                    System.out.println("You chose bad number, must be value between 1 and 6.");
            }
        }while (choiceEntry!=6);
    }
}
