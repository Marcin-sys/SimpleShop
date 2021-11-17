package products;

import java.util.*;

public class Products {
    HashMap <String, Integer> map = new HashMap<>();
    private void makeListOfProducts() {
        map.put("Jablko", 25);
        map.put("Grozka", 20);
        map.put("Czekolada", 55);
        map.put("Ciastko", 120);
        map.put("Mleko", 10);
    }
    public void showProductList(){
        makeListOfProducts();
        System.out.println(map);
    }
}
