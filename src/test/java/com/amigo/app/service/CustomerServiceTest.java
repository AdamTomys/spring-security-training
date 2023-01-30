//package com.amigo.app.service;
//
//import com.amigo.app.Application;
//import com.amigo.app.dao.CustomerEntity;
//import com.amigo.app.dto.Customer;
//import com.amigo.app.mapper.CustomerMapper;
//import com.amigo.app.mapper.CustomerMapperImpl;
//import com.amigo.app.repository.CustomerRepository;
//import lombok.experimental.FieldDefaults;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@ContextConfiguration(classes = {CustomerMapperImpl.class, Application.class})
//@FieldDefaults(makeFinal = false)
//class CustomerServiceTest {
//
//    CustomerService underTest;
//    @Autowired
//    CustomerRepository customerRepository;
//    @Autowired
//    CustomerMapper customerMapper;
//
//    @BeforeEach
//    void setUp() {
//        underTest = new CustomerService(customerRepository, customerMapper);
//    }
//
//    @AfterEach
//    void tearDown() {
//        customerRepository.deleteAll();
//    }
//
//    @Test
//    void getCustomers() {
//        //Given
//        CustomerEntity customer1 = new CustomerEntity(1L, "Jan", "pass1", "jan@email.pl");
//        CustomerEntity customer2 = new CustomerEntity(2L, "Marek", "pass2", "marek@email.pl");
//        customerRepository.saveAll(Arrays.asList(customer1, customer2));
//        //When
//        List<Customer> customers = underTest.getCustomers();
//        //Then
//        assertEquals(2, customers.size());
//        assertEquals("Jan", customers.get(0).getName());
//    }
//}