package edu.norcocollege.cis18b.week3.coffeeshop;
import java.math.BigDecimal;

public class MenuItem{
    String sku;
    String name;
    BigDecimal price;

    public MenuItem(String sku, String name, BigDecimal price){
        if(sku == null || sku.trim().isEmpty() || name == null || name.trim().isEmpty() || price == null ){
            throw new IllegalArgumentException("SKU, name, or price cannot be null or blank");
        }
        if(price.compareTo(BigDecimal.ZERO)<0)
        {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String toString(){
        return "MenuItem[SKU: " + sku + ", Name: " + name + ", Price: $" + price + "]";
    }
}