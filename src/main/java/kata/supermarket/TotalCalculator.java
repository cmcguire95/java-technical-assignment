package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class TotalCalculator {

    private final List<Item> items;

    TotalCalculator(List<Item> items) {
        this.items = items;
    }

    public BigDecimal calculate() {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
