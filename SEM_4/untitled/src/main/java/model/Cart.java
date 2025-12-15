package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public void addProduct(Product product) {
        if (items.containsKey(product.getId())) {
            CartItem item = items.get(product.getId());
            item.setQuantity(item.getQuantity() + 1);
        } else {
            items.put(product.getId(), new CartItem(product, 1));
        }
    }

    public void removeProduct(int id) {
        items.remove(id);
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public double getTotal() {
        return items.values()
                .stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
