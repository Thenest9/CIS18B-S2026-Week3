package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;

public abstract class Beverage extends MenuItem{
    public enum Size {SMALL, MEDIUM, LARGE}

    private Size size;

    public Beverage(String sku, String name, BigDecimal basePrice, Size size)
    {
        super(sku, name, basePrice);
        this.size = size;
    }

    public BigDecimal sizeMultiplier()
    {
        return switch (size)
        {
            case SMALL -> new BigDecimal("1.00");
            case MEDIUM -> new BigDecimal("1.20");
            case LARGE -> new BigDecimal("1.40");
        };
    }

    public Size getSize() 
    { return size; 
        
    }

    }