package kata.supermarket;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

class DiscounterTest {

    @Test
    void DiscounterShouldApplyDiscounts() {
        BogofDiscount bogofDiscount = Mockito.mock(BogofDiscount.class);
        ThreeForTwoDiscount threeForTwoDiscount = Mockito.mock(ThreeForTwoDiscount.class);
        Item item = new Product(BigDecimal.ONE, Arrays.asList(bogofDiscount, threeForTwoDiscount)).oneOf();
        Discounter discounter = new Discounter();

        discounter.calculateDiscount(Collections.singletonList(item));

        Mockito.verify(bogofDiscount).apply(item);
        Mockito.verify(threeForTwoDiscount).apply(item);
    }
}