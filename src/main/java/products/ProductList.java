package products;


import java.util.ArrayList;
import java.util.List;

public class ProductList {
    public List<Product> makeProductList(){
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product(0,"gruszka",12));
        productList.add(new Product(1,"jablko",15));
        productList.add(new Product(2,"banan",17));
        productList.add(new Product(3,"pomarancza",21));

        return productList;
    }
}
