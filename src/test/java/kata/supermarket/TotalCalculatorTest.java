package kata.supermarket;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TotalCalculatorTest {

    private final BigDecimal TWO = BigDecimal.valueOf(2).setScale(2, RoundingMode.HALF_UP);

    @Test
    void totalCalculatorShouldSubtractTheDicountsFromDiscounter() {
        List<Item> items = new ArrayList<>();
        Discounter discounter = mock(Discounter.class);
        Mockito.when(discounter.calculateDiscount(any())).thenReturn(TWO);
        TotalCalculator totalCalculator = new TotalCalculator(items, discounter);

        BigDecimal total = totalCalculator.calculate();

        verify(discounter).calculateDiscount(items);
        assertEquals(TWO.negate(), total);
    }
}