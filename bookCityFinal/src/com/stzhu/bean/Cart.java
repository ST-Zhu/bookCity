package com.stzhu.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    public Cart() {
    }

    public int getTotalCount() {
        int totalCount = 0;
        for (Map.Entry<Integer, CartItem> item : items.entrySet()) {
            totalCount += item.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> item : items.entrySet()) {
            totalPrice = totalPrice.add(item.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public void addItem(CartItem item) {
        if (getItems().containsKey(item.getId())) {
            items.get(item.getId()).setCount(items.get(item.getId()).getCount() + 1);
            items.get(item.getId()).setTotalPrice();
        } else {
            items.put(item.getId(), item);
        }
    }

    public void deleteItem(int id) {
        if (getItems().containsKey(id)) {
            getItems().remove(id);
        }
    }

    public void clear() {
        getItems().clear();
    }

    public void updateCount(int id, int count) {
        if (getItems().containsKey(id)) {
            items.get(id).setCount(count);
            items.get(id).setTotalPrice();
        }
    }
}
