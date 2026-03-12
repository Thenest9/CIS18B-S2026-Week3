import java.math.BigDecimal;

public class Latte extends Beverage {

      private static BigDecimal BasePrice = new BigDecimal("4.50");
    public Latte(Size size) {
        super("LATTE", "Latte", BasePrice, size);
    }

    @Override
    public BigDecimal getPrice() {
        return BasePrice.multiply(sizeMultiplier());
    }

    public String toString()
    {
        return "Latte: " + getSize() + ", price= $" + getPrice();
    }
}