package Basket.factory;

import Basket.AddNewProduct;
import Basket.Basket;
import Basket.RemoveProduct;
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
                    break;
                case 2:
                    new AddNewProduct().addNewProduct();
                    break;
                case 3:
                    new RemoveProduct().removeProductFromBasket();
                    break;
                case 4:
                    new Basket().showWhatInsideBasket();
                    break;
                case 5:
                    new Basket().payForBasket();
                    break;
                default:
                    System.out.println("You chose bad number, must be value between 1 and 5.");
            }
        }while (choiceEntry!=5);
    }
}
