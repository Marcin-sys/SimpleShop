package factory;

import products.Products;

import java.util.Scanner;

public class Factory {

    public void chooseNumberFromMenu(){
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer==1){  //list of products
            new Products().showProductList();
        } if (answer==2){ // add new product
            new AddNewProduct().addNewProduct();
        } if (answer==3){ //remove product
            new RemoveProduct().removeProductFromBasket();
        }if (answer==4){//what is inside basket
            new Basket().showWhatInsideBasket();
        }if (answer==5){//pay for basket
            new Basket().payForBasket();
        }if (answer==6){} else {
            System.out.println("You chose bad number Cya");
        }
    }
}
