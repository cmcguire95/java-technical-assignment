package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;
    private final List<Discount> discounts;

    public WeighedProduct(final BigDecimal pricePerKilo, List<Discount> discounts) {
        this.pricePerKilo = pricePerKilo;
        this.discounts = discounts;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    public List<Discount> getAvailableDiscounts() {
        return discounts;
    }
}
