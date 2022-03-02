package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Discounter {
    public BigDecimal calculateDiscount(List<Item> items) {
        BigDecimal totalDiscount = BigDecimal.ZERO;
        for (Item item : items) {
            totalDiscount = totalDiscount.add(getBiggestDiscount(item));
        }
        return totalDiscount;
    }

    private BigDecimal getBiggestDiscount(Item item) {
        BigDecimal biggestDiscount = BigDecimal.ZERO;
        for (Discount discount : item.discounts()) {
            BigDecimal newDiscount = discount.apply(item);
            if (biggestDiscount.compareTo(newDiscount) < 0) {
                biggestDiscount = newDiscount;
            }
        }
        return biggestDiscount;
    }
}
