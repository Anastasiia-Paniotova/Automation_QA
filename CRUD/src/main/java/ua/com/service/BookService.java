package ua.com.service;

import ua.com.entity.Customer;

import java.util.List;

public interface CustomerService {

    void create(Customer customer);
    void update(Customer customer);
    void delete(String id);
    Customer findById(String id);
    List<Customer> findAll();
}