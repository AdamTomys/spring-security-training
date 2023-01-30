package com.amigo.app.mapper;

import com.amigo.app.dao.CustomerEntity;
import com.amigo.app.dto.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
        Customer mapToDto(CustomerEntity customerEntity);

        List<Customer> mapToDtoList(List<CustomerEntity> customerEntities);

        CustomerEntity mapToDao(Customer customer);

        List<CustomerEntity> mapToDaoList(List<Customer> customers);
}
