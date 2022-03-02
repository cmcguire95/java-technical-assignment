package kata.supermarket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DiscounterTest {

    private Discounter discounter;
    private BogofDiscount bogofDiscount;
    private ThreeForTwoDiscount threeForTwoDiscount;
    private Item item;

    @BeforeEach
    void setUp() {
        bogofDiscount = Mockito.mock(BogofDiscount.class);
        threeForTwoDiscount = Mockito.mock(ThreeForTwoDiscount.class);
        item = new Product(BigDecimal.ONE, Arrays.asList(bogofDiscount, threeForTwoDiscount)).oneOf();
        discounter = new Discounter();

        when(bogofDiscount.apply(any())).thenReturn(BigDecimal.valueOf(2));
        when(threeForTwoDiscount.apply(any())).thenReturn(BigDecimal.valueOf(1));
    }

    @Test
    void discounterShouldApplyDiscounts() {
        discounter.calculateDiscount(Collections.singletonList(item));

        verify(bogofDiscount).apply(item);
        verify(threeForTwoDiscount).apply(item);
    }

    @Test
    void discounterShouldReturnTheBiggestDiscount() {
        BigDecimal actualDiscount = discounter.calculateDiscount(Collections.singletonList(item));
        assertEquals(BigDecimal.valueOf(2), actualDiscount);
    }
}