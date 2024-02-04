package com.fshahy.app.orders.resources;

import com.fshahy.app.orders.dto.CustomerDto;
import java.util.List;

import com.fshahy.app.orders.http.CustomerResponse;
import com.fshahy.app.orders.models.Customer;
import com.fshahy.app.orders.repositories.CustomerRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.stream.Collectors;

@Path("customers")
public class CustomerResource {

    @Inject
    private CustomerRepository customers;;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponse create(CustomerDto customerDto) {
        customerDto = customers.save(customerDto);
        CustomerResponse res = new CustomerResponse(customerDto);
        return res;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerResponse> getAll() {
        return customers.getAll()
                    .stream()
                    .map(c -> new CustomerResponse(c))
                    .collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerResponse getById(@PathParam("id") long id) {
        CustomerDto customerDto = customers.findById(id);
        CustomerResponse res = new CustomerResponse(customerDto);
        return res;
    }

}