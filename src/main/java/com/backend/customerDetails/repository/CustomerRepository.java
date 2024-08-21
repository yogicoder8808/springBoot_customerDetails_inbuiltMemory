package com.backend.customerDetails.repository;

import com.backend.customerDetails.model.Customer;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {

    private final Map<Long, Customer> customerMap = new HashMap<>();
    private long nextId = 1;

    @PostConstruct
    public void init() {
        createCustomer(Customer.builder()
                .name("John Doe")
                .role("Admin")
                .fax("1234567890")
                .address("123 Elm St")
                .locality("Downtown")
                .city("Metropolis")
                .number("12345")
                .build());

        createCustomer(Customer.builder()
                .name("Jane Smith")
                .role("User")
                .fax("0987654321")
                .address("456 Oak St")
                .locality("Uptown")
                .city("Gotham")
                .number("54321")
                .build());
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(nextId++);
        }
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    public Map<Long, Customer> getAllCustomers() {
        return customerMap;
    }

    public Customer getCustomerById(Long id) {
        return customerMap.get(id);
    }

    public void deleteCustomerById(Long id) {
        customerMap.remove(id);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        if (!customerMap.containsKey(id)) {
            return null;
        }
        customer.setId(id);
        customerMap.put(id, customer);
        return customer;
    }
}
