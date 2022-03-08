package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HalfPriceKiloTest {

    @Test
    void applyShouldReturnCorrectDiscountForOneKilo() {
        HalfPriceKilo halfPriceKilo = new HalfPriceKilo();
        Item item = new WeighedProduct(BigDecimal.valueOf(5), Collections.singletonList(halfPriceKilo)).weighing(BigDecimal.ONE);
        BigDecimal actualDiscount = halfPriceKilo.apply(item);
        assertEquals(BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_DOWN), actualDiscount);
    }

    @Test
    void applyShouldReturnCorrectDiscountForLessThanOneKilo() {
        HalfPriceKilo halfPriceKilo = new HalfPriceKilo();
        Item item = new WeighedProduct(BigDecimal.valueOf(5), Collections.singletonList(halfPriceKilo)).weighing(BigDecimal.valueOf(0.75));
        BigDecimal actualDiscount = halfPriceKilo.apply(item);
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN), actualDiscount);
    }

    @Test
    void applyShouldReturnCorrectDiscountForOnePointFiveKilo() {
        HalfPriceKilo halfPriceKilo = new HalfPriceKilo();
        Item item = new WeighedProduct(BigDecimal.valueOf(5), Collections.singletonList(halfPriceKilo)).weighing(BigDecimal.valueOf(1.5));
        BigDecimal actualDiscount = halfPriceKilo.apply(item);
        assertEquals(BigDecimal.valueOf(2.5).setScale(2, RoundingMode.HALF_DOWN), actualDiscount);
    }
}