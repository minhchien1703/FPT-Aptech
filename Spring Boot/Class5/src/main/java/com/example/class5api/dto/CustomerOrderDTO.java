package com.example.class5api.dto;

import java.util.List;

public class CustomerOrderDTO {

    private Long customerId;
    private String customerName;
    private String customerEmail;
    private double total;
    private List<String> products;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(Long customerId, String customerName, String customerEmail, List<String> products) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.products = products;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
