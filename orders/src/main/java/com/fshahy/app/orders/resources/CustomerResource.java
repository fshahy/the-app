package com.fshahy.app.orders.resources;

import java.util.List;

import com.fshahy.app.orders.dto.CustomerDto;
import com.fshahy.app.orders.repositories.CustomerRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("customers")
public class CustomerResource {

    @Inject
    private CustomerRepository customers;;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDto create(CustomerDto customerDto) {
        return customers.save(customerDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getAll() {
        return customers.getAll();
    }

}