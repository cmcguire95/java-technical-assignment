package kata.supermarket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BogofDiscountTest {
    @Test
    void bogofDiscountApplyShouldReturnCorrectDiscount() {
        Discount bogofDiscount = new BogofDiscount();
        BigDecimal actualDiscount = bogofDiscount.apply(new Product(BigDecimal.ONE, Collections.singletonList(bogofDiscount)).multipleOf(2));
        assertEquals(BigDecimal.valueOf(1.00).setScale(2, RoundingMode.HALF_UP), actualDiscount);
    }

    @Test
    void bogofDiscountApplyShouldReturnCorrectDiscountForMoreThanTwoItems() {
        Discount bogofDiscount = new BogofDiscount();
        BigDecimal actualDiscount = bogofDiscount.apply(new Product(BigDecimal.valueOf(1.5), Collections.singletonList(bogofDiscount)).multipleOf(5));
        assertEquals(BigDecimal.valueOf(3.00).setScale(2, RoundingMode.HALF_UP), actualDiscount);
    }

    @Test
    void bogofDiscountApplyShouldReturnCorrectDiscountForLessThanTwoItems() {
        Discount bogofDiscount = new BogofDiscount();
        BigDecimal actualDiscount = bogofDiscount.apply(new Product(BigDecimal.ONE, Collections.singletonList(bogofDiscount)).oneOf());
        assertEquals(BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_UP), actualDiscount);
    }
}