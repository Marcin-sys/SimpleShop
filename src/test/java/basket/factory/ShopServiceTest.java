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
    int max = productHashMap.size() - 1;
    int min = 0;
    UserInputProvider input = Mockito.mock(UserInputProvider.class);
    SystemPrinter printer = Mockito.mock(SystemPrinter.class);
    ShopService basket1 = new ShopService(input,printer);
    ShopService basket2 = new ShopService(input,printer);

    @BeforeEach
    public void init() {
        basket2.basketList.add(productHashMap.get(2));
    }

    @Test
    void printAllProductsInShop() {
        String expectedResult = "0 = Product[id=45, name=Pear, price=12.0]";
        ShopService shopService = new ShopService(input,printer);

        shopService.printAllProductsInShop();

        Mockito.verify(printer).printString(expectedResult);

    }

    @Test
    void addNewProductToBasket() {
        try (Scanner sc = new Scanner(System.in)) {
            Mockito.when(input.getValidIntInput(eq(min),
                    eq(max), Mockito.any())).thenReturn(2);
            basket1.addNewProductToBasket(sc);
            assertEquals(basket2.basketList, basket1.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeProductFromBasket() {
        try (Scanner sc = new Scanner(System.in)) {
            Mockito.when(input.getValidIntInput(eq(min),
                    eq(max), Mockito.any())).thenReturn(1);
            basket1.basketList.add(productHashMap.get(1));
            basket1.basketList.add(productHashMap.get(2));
            basket1.removeProductFromBasket(sc);
            assertEquals(basket2.basketList, basket1.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void showWhatInsideBasket() {
        String expectedResult = "Banana";

        ShopService shopService = new ShopService(input,printer);

        shopService.basketList.add(productHashMap.get(2));
        shopService.showWhatInsideBasket();

        Mockito.verify(printer).printString(expectedResult);
    }

    @Test
    void payForBasket() {
        String expectedResult = "Total price is: 17.0 PLN";

        ShopService shopService = new ShopService(input,printer);

        shopService.basketList.add(productHashMap.get(2));
        shopService.payForBasket();

        Mockito.verify(printer).printString(expectedResult);
    }
}