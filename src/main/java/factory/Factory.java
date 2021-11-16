package factory;

import products.Products;

import java.util.Scanner;

public class Factory {
    public void chooseNumberFromMenu(){
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        if (answer==1){  //list of products
            var list = new Products().showProductList();
        } if (answer==2){ // add new product
//            var s = new
        } if (answer==3){ //remove product
        }if (answer==4){//what is inside basket
        }if (answer==5){//pay for basket
        }if (answer==6){//end shopping
        }
        else {
            System.out.println("You chose bad number Cya");
        }
    }
}
