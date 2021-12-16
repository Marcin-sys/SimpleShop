package products;

public record Products(int id, String name, float price) {

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
