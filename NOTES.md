# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

# Assumptions/ Design Decisions
Discounts sit at the product level where a product is defined
Products can have multiple applicable discounts and the best one should be used
Products would be created with the correct discounts. E.g. Bogof would not be used on WeighedProducts

# Dependencies

Added Mockito, widely used testing dependency. Allowed me to mock the functionality of calculating discounts so the
creation of discounter could be test driven and logic would not be needed straight away.

# Future work
-Parameterise BOGOF test
-Have a method in Item to return unit/perKG price instead of working it out in discounts
-Add in more discounts
-Make Discount into ProductDiscount and then add BasketDiscount for other offers like flat 10% on basked?
    Could also be compared to total of ProductDiscounts to find the best discount. E.g. flat 10% or multiple bogof
-Validation on discounts added to products so only applicable discounts can be added. E.g. no BOGOF on WeighedProduct