package com.fshahy.app.orders.resources;

import java.util.List;

import com.fshahy.app.orders.dto.SaleOrderDto;
import com.fshahy.app.orders.dto.SaleOrderLineDto;
import com.fshahy.app.orders.repositories.SaleOrderRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("sale_orders")
public class SaleOrderResource {
    
    @Inject
    private SaleOrderRepository saleOrders;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SaleOrderDto create(SaleOrderDto saleOrderDto) {
        return saleOrders.save(saleOrderDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaleOrderDto> getAll() {
        return saleOrders.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SaleOrderDto getById(@PathParam("id") Long id) {
        SaleOrderDto saleOrderDto = saleOrders.findById(id);
        return saleOrderDto;
    }

    @Path("{id}")
    @DELETE
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        saleOrders.delete(id);
        return Response.status(204).build();
    }

    @POST
    @Path("{orderId}/lines")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrderLine(@PathParam("orderIf") Long orderId, SaleOrderLineDto lineDto) {
        saleOrders.saveLine(lineDto);
        return Response.status(201).build();
        
    }

    @GET
    @Path("{orderId}/lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaleOrderLineDto> getOrderLines(@PathParam("orderId") Long orderId) {
        return saleOrders.findOrderLines(orderId);
    }

}
