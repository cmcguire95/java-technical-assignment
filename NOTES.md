# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

# Dependencies

Added Mockito, widely used testing dependency. Allowed me to mock the functionality of calculating discounts so the
creation of discounter could be test driven and logic would not be needed straight away.

# Future work
-Parameterise BOGOF test
-Have a method in Item to return unit/perKG price instead of working it out in discounts
-Add in more discounts
-Make Discount into ProductDiscount and then add BasketDiscount for other offers like flat 10% on basked?
    Could also be compared to total of ProductDiscounts to find the best discount. E.g. flat 10% or multiple bogof