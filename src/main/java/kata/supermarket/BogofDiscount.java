package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BogofDiscount implements Discount {

    public BigDecimal apply(Item item) {
        return item.price()
                .setScale(2, RoundingMode.HALF_UP)
                .divide(item.quantityWeightOrUnits(), RoundingMode.HALF_UP)
                .multiply(
                        item.quantityWeightOrUnits()
                                .divide(BigDecimal.valueOf(2), RoundingMode.DOWN));
    }
}
