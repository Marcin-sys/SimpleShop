import Basket.factory.Factory;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome. Please choose number " +
                "from menu below:");
        System.out.println("1. Check all product's");
        System.out.println("2. Add new product to basket");
        System.out.println("3. Remove product from basket");
        System.out.println("4. Check what is inside basket");
        System.out.println("5. Pay for all product inside basket");
        System.out.println("6. End shopping");
        new Factory().chooseNumberFromMenu();

        System.out.println("End of shopping. See you again");
    }
}
