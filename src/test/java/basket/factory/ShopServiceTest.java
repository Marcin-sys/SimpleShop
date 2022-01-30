package basket.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import products.Product;
import products.ProductMapProvider;

import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

class ShopServiceTest {

    Map<Integer, Product> productHashMap =
            new ProductMapProvider().makeProductMap();
    ShopService testList = new ShopService();
    int max = productHashMap.size() - 1;
    int min = 0;
    UserInputProvider input = Mockito.mock(UserInputProvider.class);
    ShopService shopService = new ShopService(input);

    @BeforeEach
    public void init() {
        testList.basketList.add(productHashMap.get(2));
    }

    @Test
    void printAllProductsInShop() {
        SystemPrinter printer = Mockito.mock(SystemPrinter.class);
        String expectedResult = "0 = Product[id=45, name=Pear, price=12.0]";
        ShopService shopService = new ShopService(printer);

        shopService.printAllProductsInShop();

        Mockito.verify(printer).printString(expectedResult);

    }

    @Test
    void addNewProductToBasket() {
        try (Scanner sc = new Scanner(System.in)) {
            Mockito.when(input.getValidIntInput(eq(min),
                    eq(max), Mockito.any())).thenReturn(2);
            shopService.addNewProductToBasket(sc);
            assertEquals(testList.basketList, shopService.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeProductFromBasket() {
        try (Scanner sc = new Scanner(System.in)) {
            Mockito.when(input.getValidIntInput(eq(min),
                    eq(max), Mockito.any())).thenReturn(2);
            shopService.basketList.add(productHashMap.get(2));
            shopService.basketList.add(productHashMap.get(2));
            shopService.removeProductFromBasket(sc);
            assertEquals(testList.basketList, shopService.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void showWhatInsideBasket() {
        SystemPrinter printer = Mockito.mock(SystemPrinter.class);
        String expectedResult = "Banana";

        ShopService shopService = new ShopService(printer);

        shopService.basketList.add(productHashMap.get(2));
        shopService.showWhatInsideBasket();

        Mockito.verify(printer).printString(expectedResult);
    }

    @Test
    void payForBasket() {
        SystemPrinter printer = Mockito.mock(SystemPrinter.class);
        String expectedResult = "Total price is: 17.0 PLN";

        ShopService shopService = new ShopService(printer);

        shopService.basketList.add(productHashMap.get(2));
        shopService.payForBasket();

        Mockito.verify(printer).printString(expectedResult);
    }
}