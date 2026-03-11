package edu.norcocollege.cis18b.week3.coffeeshop;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Order
{
    String orderId;
    List<MenuItem> items;

    public Order (String orderId, List<MenuItem> items)
    {
        if(orderId==null || orderId.isBlank())
        {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        this.orderId = orderId;
        this.items = items;
    }

    public void addItem(MenuItem item)
    {
        if(item == null)
        {
            throw new IllegalArgumentException("Menu item cannot be null");
        }
        items.add(item);
    }

    public List<MenuItem> getItems()
    {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total()
    {
        BigDecimal total = BigDecimal.ZERO;
        for(MenuItem item : items)
        {
            total= total.add(item.getPrice());
        }
        return total;
    }

    public String getOrderId()
    {
        return orderId;
    }
}