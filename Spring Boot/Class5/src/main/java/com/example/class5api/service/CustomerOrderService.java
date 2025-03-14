package com.example.class5api.service;

import com.example.class5api.dto.CustomerOrderDTO;
import com.example.class5api.model.Customer;
import com.example.class5api.model.Order;
import com.example.class5api.repository.CustomerRepository;
import com.example.class5api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    public CustomerOrderDTO getCustomerOrders(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()
                -> new RuntimeException("Customer not found"));

        List<String> products = customer.getOrders().stream()
                .map(Order::getProduct)
                .collect(Collectors.toList());

        //GROUP BY ---> total of Order

        return new CustomerOrderDTO(customer.getId(), customer.getName(), customer.getEmail(), products);
    }

    // Create a new customer
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long customerId, Customer customerDetails) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(customerDetails.getName());
        return customerRepository.save(customer);
    }

    // Delete a customer
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customerRepository.delete(customer);
    }

    // Create a new order for a customer
    public Order createOrder(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        order.setCustomer(customer);
        return orderRepository.save(order);
    }

    // Update an existing order
    public Order updateOrder(Long orderId, Order orderDetails) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setProduct(orderDetails.getProduct());
        return orderRepository.save(order);
    }

    // Delete an order
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        orderRepository.delete(order);
    }
}
