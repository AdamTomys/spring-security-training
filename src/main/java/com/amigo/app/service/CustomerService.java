package com.amigo.app.service;

import com.amigo.app.dao.CustomerEntity;
import com.amigo.app.dto.Customer;
import com.amigo.app.exception.NotFoundException;
import com.amigo.app.mapper.CustomerMapper;
import com.amigo.app.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<Customer> getCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            log.warn("Baza danych jest pusta");
            throw new NotFoundException("Baza danych jest pusta");
        } else {
            return customerMapper.mapToDtoList(customers);
        }
    }
}
