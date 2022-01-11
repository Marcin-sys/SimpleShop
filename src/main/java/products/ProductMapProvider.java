package products;


import java.util.*;

public class  ProductMapProvider {
    public Map<Integer, Product> makeProductMap() {
        Map<Integer, Product> productHashMap = new HashMap<>();
        productHashMap.put(0, new Product(45, "Pear", 12));
        productHashMap.put(1, new Product(68, "Apple", 15));
        productHashMap.put(2, new Product(20, "Banana", 17));
        productHashMap.put(3, new Product(38, "Orange", 21));
        productHashMap.put(4, new Product(15, "Kiwi", 7));

        return productHashMap;
    }
}
