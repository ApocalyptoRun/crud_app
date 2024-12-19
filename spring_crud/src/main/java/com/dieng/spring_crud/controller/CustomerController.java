package com.dieng.spring_crud.controller;

import com.dieng.spring_crud.entity.Customer;
import com.dieng.spring_crud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        Customer existingCustomer = customerService.findCustomerById(id);
        if (existingCustomer == null)
            return ResponseEntity.notFound().build();
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());

        Customer updatedCustomer = customerService.updateCustomer(existingCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> customers = customerService.findAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/findCustomer/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
