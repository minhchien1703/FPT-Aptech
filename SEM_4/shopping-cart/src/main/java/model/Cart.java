package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Cart implements Serializable {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product p) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == p.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        items.add(new CartItem(p, 1));
    }
}
