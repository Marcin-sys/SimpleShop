package products;

public class Products {
    private final Integer id;
    private final float price;
    private final String name;

    public Products(final Integer productIdentifier, String productName, float productPrice) {
        id = productIdentifier;
        price = productPrice;
        name = productName;
    }

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void print() {
        System.out.println("Lp: "+id+" - Name of product: " + name +" - Price: "+ price + " PLN");
    }
}
