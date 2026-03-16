package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomDrink extends Beverage
{
    public enum Milk
    {
        WHOLE, OAT, ALMOND, SKIM;
    }
    public enum Syrup
    {
        VANILLA, CARAMEL, HAZELNUT, NONE;
    }
    public enum Temperature
    {
        HOT, ICED;
    }
    private static final BigDecimal BASE_PRICE = new BigDecimal("4.25");
    private static final BigDecimal EXTRA_SHOT = new BigDecimal("0.75");
    private static final BigDecimal SYRUP_PRICE = new BigDecimal("0.50");
    private static final BigDecimal Extra_PRICE = new BigDecimal("0.25");

    private final Milk milk;
    private final Syrup syrup;
    private final Temperature temperature;
    private final int espressoShots;
    private final List<String> extras;


    private CustomDrink(Builder builder){
        super("CUSTOM", "custom drink", BASE_PRICE, builder.size);
        this.milk = builder.milk;
        this.syrup = builder.syrup;
        this.temperature = builder.temperature;
        this.extras = List.copyOf(builder.extras);
        this.espressoShots = builder.espressoShots;
    }

    public BigDecimal getPrice()
    {
        BigDecimal price = BASE_PRICE;
        if(espressoShots >1)
        {
            price = price.add(EXTRA_SHOT.multiply(new BigDecimal(espressoShots -1)));
        }
        if(syrup != Syrup.NONE)
        {
            price = price.add(SYRUP_PRICE);
        }
        price = price.add(Extra_PRICE.multiply(new BigDecimal(extras.size())));

        return price;
    }

    public static class Builder
    {
        private Size size = Size.MEDIUM;
        private Milk milk = Milk.WHOLE;
        private Syrup syrup = Syrup.NONE;
        private Temperature temperature = Temperature.HOT;
        private int espressoShots = 1;
        private List<String> extras = new ArrayList<>();

        public Builder espressoShots(int shots)
        {
            if(shots<1)
            {
                throw new IllegalArgumentException("Espresso shots must be at least 1");
            }
            this.espressoShots = shots;
            return this;
        }
        public Builder addExtra(String extra)
        {
            if(extra ==null || extra.isBlank())
            {
                throw new IllegalArgumentException("Extra cannot be null or blank");
            }
            this.extras.add(extra);
            return this;

        }
        public Builder size(Size size)
        {
            this.size = size;
            return this;
        }
        public Builder milk(Milk milk)
        {
            this.milk = milk;
            return this;
        }
        public Builder syrup(Syrup syrup)
        {
            this.syrup = syrup;
            return this;
        }
        public Builder temperature(Temperature temperature)
        {
            this.temperature = temperature;
            return this;
        }

        public CustomDrink build()
        {
            return new CustomDrink(this);
        }
    }
}