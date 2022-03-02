package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class TotalCalculator {

    private final List<Item> items;
    private final Discounter discounter;

    TotalCalculator(List<Item> items, Discounter discounter) {
        this.items = items;
        this.discounter = discounter;
    }

    public BigDecimal calculate() {
        return subtotal().subtract(discounter.calculateDiscount(items));
    }

    private BigDecimal subtotal() {
        return items.stream().map(Item::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
