package edu.norcocollege.cis18b.week3.coffeeshop;

import java.math.BigDecimal;
import java.util.Map;

public class PricingCatalog
{
    private static final PricingCatalog INSTANCE = new PricingCatalog();

    private PricingCatalog() {}

    public static PricingCatalog getInstance() {
        return INSTANCE;
    }

    public static final Map<String, BigDecimal> PRICES = Map.of(
        "LATTE",   new BigDecimal("4.50"),
        "COLD_BREW", new BigDecimal("4.00"),
        "CUSTOM", new BigDecimal("4.25")
    );
    public BigDecimal getBasePrice(String productKey)
    {
        BigDecimal price = PRICES.get(productKey);
        if(price == null) {
            throw new IllegalArgumentException("No price found for product key: " + productKey);
        }
        return price;

    }
}