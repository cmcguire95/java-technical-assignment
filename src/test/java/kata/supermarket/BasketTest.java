package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                multipleUnitsOfASingleItemPricedPerUnit(),
                multipleUnitsOfASingleItemPricedPerUnitWithDiscounts(),
                aWeighedItemWithHalfPriceKiloDiscount()
        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }
    private static Arguments multipleUnitsOfASingleItemPricedPerUnit() {
        return Arguments.of("multiple units of a single item priced per unit", "3.10", Collections.singleton(twoPacksOfDigestives()));
    }
    private static Arguments multipleUnitsOfASingleItemPricedPerUnitWithDiscounts() {
        return Arguments.of("multiple units of a single item priced per unit with discounts", "3.10", Collections.singleton(threePacksOfDigestivesWithDiscounts()));
    }

    private static Arguments aWeighedItemWithHalfPriceKiloDiscount() {
        return Arguments.of("a weighed item with half price kilo discount", "2.50", Collections.singleton(aKiloOfAmericanSweetsWithHalfPriceKilo()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49"), Collections.emptyList()).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55"), Collections.emptyList()).oneOf();
    }

    private static Item twoPacksOfDigestives() {
        return new Product(new BigDecimal("1.55"), Collections.emptyList()).multipleOf(2);
    }

    private static Item threePacksOfDigestivesWithDiscounts() {
        return new Product(new BigDecimal("1.55"), Arrays.asList(new BogofDiscount(), new ThreeForTwoDiscount())).multipleOf(3);
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"), Collections.emptyList());
    }

    private static Item aKiloOfAmericanSweetsWithHalfPriceKilo() {
        return new WeighedProduct(new BigDecimal("5"), Collections.singletonList(new HalfPriceKilo())).weighing(BigDecimal.ONE);
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"), Collections.emptyList());
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }
}