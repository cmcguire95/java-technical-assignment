package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfPriceKilo implements Discount {
    @Override
    public BigDecimal apply(Item item) {
        return halfKiloPrice(item.pricePerUnitOrKg())
                .multiply(numberOfDiscountsToApply(item.quantityWeightOrUnits()));
    }

    private BigDecimal halfKiloPrice(BigDecimal pricePerKg) {
        return pricePerKg.setScale(2, RoundingMode.HALF_DOWN)
                .divide(BigDecimal.valueOf(2), RoundingMode.HALF_DOWN);
    }

    private BigDecimal numberOfDiscountsToApply(BigDecimal weight) {
        return weight
                .setScale(0, RoundingMode.DOWN)
                .divide(BigDecimal.ONE, RoundingMode.DOWN);
    }
}
