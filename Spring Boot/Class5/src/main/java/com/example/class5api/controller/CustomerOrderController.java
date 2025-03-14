package com.example.class5api.controller;

import com.example.class5api.dto.CustomerOrderDTO;
import com.example.class5api.model.Customer;
import com.example.class5api.model.Order;
import com.example.class5api.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customerorder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/{id}/orders")
    public CustomerOrderDTO getCustomerOrders(@PathVariable Long id) {
        return customerOrderService.getCustomerOrders(id);
    }

    // Create a new customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerOrderService.createCustomer(customer);
    }

    // Update an existing customer
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        return customerOrderService.updateCustomer(id, customerDetails);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerOrderService.deleteCustomer(id);
    }

    // Create a new order for a customer
    @PostMapping("/{id}/orders")
    public Order createOrder(@PathVariable Long id, @RequestBody Order order) {
        return customerOrderService.createOrder(id, order);
    }

    // Update an existing order
    @PutMapping("/orders/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order orderDetails) {
        return customerOrderService.updateOrder(orderId, orderDetails);
    }

    // Delete an order
    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        customerOrderService.deleteOrder(orderId);
    }
}
