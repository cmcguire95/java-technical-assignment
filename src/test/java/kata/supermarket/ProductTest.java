package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    public static final BigDecimal PRICE = new BigDecimal("2.49");

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        assertEquals(PRICE, new Product(PRICE).oneOf().price());
    }

    @Test
    void multipleOfItemHasExpectedTotalUnitPriceFromProduct() {
        BigDecimal expected = PRICE.multiply(BigDecimal.valueOf(2));
        assertEquals(expected, new Product(PRICE).multipleOf(2).price());
    }
}