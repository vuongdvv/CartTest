package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
    }

    @Test
    void testAddItem() {
        Item item = new Item("Apple", 1.5);
        cart.addItem(item);
        assertEquals(1, cart.getItems().size());
        assertEquals("Apple", cart.getItems().get(0).getName());
    }

    @Test
    void testRemoveItem() {
        Item item = new Item("Banana", 1.0);
        cart.addItem(item);
        cart.removeItem(item);
        assertEquals(0, cart.getItems().size());
    }

    @Test
    void testEmptyCart() {
        assertEquals(0, cart.getItems().size());
    }

    @Test
    void testGetTotalPrice() {
        cart.addItem(new Item("Apple", 1.5));
        cart.addItem(new Item("Banana", 2.0));
        assertEquals(3.5, cart.getTotalPrice());
    }
    // Trường hợp test lỗi
    @Test
    void testGetTotalPriceWithError() {
        cart.addItem(new Item("Apple", 1.5));
        cart.addItem(new Item("Banana", 2.0));
        // Giả sử chúng ta kiểm tra tổng giá là 4.0, sẽ gây lỗi
        assertEquals(4.0, cart.getTotalPrice());
    }
}
