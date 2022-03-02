package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class Discounter {
    public BigDecimal calculateDiscount(List<Item> items) {
        for (Item item : items) {
            for (Discount discount : item.discounts()) {
                discount.apply(item);
            }
        }
        return BigDecimal.ZERO;
    }
}
