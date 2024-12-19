package com.dieng.spring_crud.service;

import com.dieng.spring_crud.Exception.UserNotFoundException;
import com.dieng.spring_crud.entity.Customer;
import com.dieng.spring_crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
       return customerRepository.findById(id)
               .orElseThrow(() -> new UserNotFoundException("User by id :"+id+" not found"));
    }

    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
