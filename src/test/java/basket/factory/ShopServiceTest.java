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
    public void init(){
        testList.basketList.add(productHashMap.get(2));
    }

//    @Test
//    void printAllProductsInShop() {
//            ShopService shopService = Mockito.mock(ShopService.class);
//            shopService.printAllProductsInShop();
//
//    }

    @Test
    void addNewProductToBasket() {
        try (Scanner sc = new Scanner(System.in)){
            Mockito.when(input.getValidIntInput(eq(min),
                    eq(max), Mockito.any())).thenReturn(2);
            shopService.addNewProductToBasket(sc);
            assertEquals(testList.basketList,shopService.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeProductFromBasket() {
        try (Scanner sc = new Scanner(System.in)){
            Mockito.when(input.getValidIntInput(eq(min),
                eq(max), Mockito.any())).thenReturn(2);
            shopService.basketList.add(productHashMap.get(2));
            shopService.basketList.add(productHashMap.get(2));
            shopService.removeProductFromBasket(sc);
            assertEquals(testList.basketList,shopService.basketList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void showWhatInsideBasket() {
        int min = 0;
        int max = productHashMap.size() - 1;
        UserInputProvider input = Mockito.mock(UserInputProvider.class);

        Mockito.when(input.getValidIntInput(eq(min),
                eq(max), Mockito.any())).thenReturn(2);

        shopService.showWhatInsideBasket();
//        assertEquals("");
    }

    @Test
    void payForBasket() {
    }
}