package products;

import java.util.ArrayList;

public class ProductList {
    public ArrayList<Products> makeProductList(){
        ArrayList<Products> productList = new ArrayList<>();
        productList.add(new Products(1,"gruszka",12));
        productList.add(new Products(2,"jablko",15));
        productList.add(new Products(3,"banan",17));
        productList.add(new Products(4,"pomarancza",21));

        return productList;
    }
}
