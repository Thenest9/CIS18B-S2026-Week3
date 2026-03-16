

package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Latte extends Beverage {

      private static BigDecimal BasePrice = new BigDecimal("4.50");
    public Latte(Size size) {
        super("LATTE", "Latte", BasePrice, size);
    }

    @Override
    public BigDecimal getPrice() {
        return BasePrice.multiply(sizeMultiplier()).setScale(2, RoundingMode.HALF_UP);
    }

    public String toString()
    {
        return "Latte: " + getSize() + ", price= $" + getPrice();
    }
}