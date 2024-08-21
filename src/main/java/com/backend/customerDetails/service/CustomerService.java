package com.backend.customerDetails.service;

import com.backend.customerDetails.model.Customer;
import com.backend.customerDetails.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return Optional.ofNullable(customerRepository.getCustomerById(id));
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteCustomerById(id);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return customerRepository.updateCustomer(id, customer);
    }

    public Map<Long, Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
