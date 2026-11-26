package com.craft.customer_service.service;

import com.craft.customer_service.model.Customer;
import com.craft.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Long id, Customer updated) {
        return repository.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            return repository.save(existing);
        }).orElse(null);
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}