package basket.factory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.mockito.ArgumentMatchers.eq;


class ShoppingJourneyTest {

    @Test
    void shopManagerMenuTesT() {
        int min = 1;
        int max = 6;

        ShopService shopService = Mockito.mock(ShopService.class);
        UserInputProvider input = Mockito.mock(UserInputProvider.class);

        Mockito.when(input.getValidIntInput(eq(min),
                        eq(max),Mockito.any()))
                .thenReturn(1,6);

        ShoppingJourney shoppingJourney = new ShoppingJourney(shopService, input);

        shoppingJourney.shopManagerMenu();

        Mockito.verify(shopService).printAllProductsInShop();
    }
}