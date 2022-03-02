package kata.supermarket;

import java.math.BigDecimal;

public class ThreeForTwoDiscount implements Discount {

    public BigDecimal apply(Item item) {
        return BigDecimal.ZERO;
    }
}
