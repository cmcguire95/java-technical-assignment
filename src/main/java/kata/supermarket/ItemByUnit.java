package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class ItemByUnit implements Item {

    private final Product product;
    private final int quantity;

    ItemByUnit(final Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal price() {
        return product.pricePerUnit().multiply(BigDecimal.valueOf(quantity));
    }

    public List<Discount> discounts() {
        return product.getAvailableDiscounts();
    }

    public BigDecimal quantityWeightOrUnits() {
        return BigDecimal.valueOf(quantity);
    }
}
