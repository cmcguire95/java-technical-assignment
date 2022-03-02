package kata.supermarket;

import java.math.BigDecimal;

public class BogofDiscount implements Discount {

    public BigDecimal apply(Item item) {
        return BigDecimal.ZERO;
    }
}
