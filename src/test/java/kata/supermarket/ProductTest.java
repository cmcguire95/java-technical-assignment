package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {

    public static final BigDecimal PRICE = new BigDecimal("2.49");

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        assertEquals(PRICE, new Product(PRICE, Collections.emptyList()).oneOf().price());
    }

    @Test
    void multipleOfItemHasExpectedTotalUnitPriceFromProduct() {
        BigDecimal expected = PRICE.multiply(BigDecimal.valueOf(2));
        assertEquals(expected, new Product(PRICE, Collections.emptyList()).multipleOf(2).price());
    }

    @Test
    void productsCanStoreAndReturnDiscounts() {
        List<Discount> discounts = Arrays.asList(new BogofDiscount(), new ThreeForTwoDiscount());
        List<Discount> availableDiscounts = new Product(PRICE, discounts).getAvailableDiscounts();
        assertEquals(2, availableDiscounts.size());
        assertTrue(availableDiscounts.get(0) instanceof BogofDiscount);
        assertTrue(availableDiscounts.get(1) instanceof ThreeForTwoDiscount);
    }
}