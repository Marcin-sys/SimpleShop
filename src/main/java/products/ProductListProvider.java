package products;


import java.util.ArrayList;
import java.util.List;

public class ProductListProvider {
    public List<Product> makeProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(0,"Pear",12));
        productList.add(new Product(1,"Apple",15));
        productList.add(new Product(2,"Banana",17));
        productList.add(new Product(3,"Orange",21));

        return productList;
    }
}
