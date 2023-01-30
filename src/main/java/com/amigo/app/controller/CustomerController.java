package com.amigo.app.controller;

import com.amigo.app.dto.Customer;
import com.amigo.app.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers")
@Log4j2
public class CustomerController {

    final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping(value = "save")
    @ResponseStatus(code = HttpStatus.CREATED)
    void saveCustomer(@RequestBody @Valid Customer customer) {
        log.info("Saving customer");
        log.info(customer);
    }
}
