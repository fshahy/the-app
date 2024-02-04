package com.fshahy.app.orders.repositories;

import com.fshahy.app.orders.dto.CustomerDto;
import java.util.List;

import com.fshahy.app.orders.models.Customer;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@RequestScoped
public class CustomerRepository {
    
    @PersistenceContext(unitName = "the-app-pu")
    private EntityManager entityManager;
    
    @Inject
    private ModelMapper modelMapper;

    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        entityManager.persist(customer);
        entityManager.flush(); // because I need to load the id generated for entity
        return this.modelMapper.map(customer, CustomerDto.class);
    }

    public List<CustomerDto> getAll() {
        return entityManager
                .createNamedQuery("Customer.All", Customer.class)
                .getResultStream()
                .map(customer -> this.modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toUnmodifiableList());
    }

    public CustomerDto findById(long id) {
        Customer customer = entityManager.find(Customer.class, id);
        return this.modelMapper.map(customer, CustomerDto.class);
    }
}
