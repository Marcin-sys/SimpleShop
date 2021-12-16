package products;

public class Products {

    private final int id;
    private final float price;
    private final String name;

    public Products(int id, String name, float price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public record Product(int id, String name, float price) {
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
}
