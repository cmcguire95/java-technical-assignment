package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BogofDiscount implements Discount {

    public BigDecimal apply(Item item) {
        return item.pricePerUnitOrKg()
                .multiply(
                        numberOfDiscountsToApply(item))
                .setScale(2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal numberOfDiscountsToApply(Item item) {
        return item.quantityWeightOrUnits()
                .divide(BigDecimal.valueOf(2), RoundingMode.DOWN);
    }
}
