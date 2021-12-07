import basket.factory.FactoryMenageShopping;
import menu.Menu;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome. Please choose number " +
                "from menu below:");
        new Menu().MenuPrinter();
        new FactoryMenageShopping().chooseNumberFromMenu();

        System.out.println("End of shopping. See you again");
    }
}
