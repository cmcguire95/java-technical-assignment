package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Product {

    private final BigDecimal pricePerUnit;
    private final List<Discount> discounts;

    public Product(final BigDecimal pricePerUnit, List<Discount> discounts) {
        this.pricePerUnit = pricePerUnit;
        this.discounts = discounts;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this, 1);
    }

    public Item multipleOf(int quantity) {
        return new ItemByUnit(this, quantity);
    }

    public List<Discount> getAvailableDiscounts() {
        return Collections.unmodifiableList(discounts);
    }
}
