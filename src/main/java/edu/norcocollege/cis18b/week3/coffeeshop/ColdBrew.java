package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public class ColdBrew extends Beverage
{
    private static BigDecimal basePrice = new BigDecimal("4.00");

    public ColdBrew(Size size) {
        super("COLD_BREW", "Cold Brew", basePrice, size);
    }

     @Override
    public BigDecimal getPrice() {
        return basePrice.multiply(sizeMultiplier());
    }
}