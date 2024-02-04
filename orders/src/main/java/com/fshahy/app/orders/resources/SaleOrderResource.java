package com.fshahy.app.orders.resources;

import com.fshahy.app.orders.dto.SaleOrderDto;
import com.fshahy.app.orders.dto.SaleOrderLineDto;
import java.util.List;
import java.util.stream.Collectors;

import com.fshahy.app.orders.http.SaleOrderLineResponse;
import com.fshahy.app.orders.http.SaleOrderResponse;
import com.fshahy.app.orders.models.SaleOrder;
import com.fshahy.app.orders.models.SaleOrderLine;
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
    public List<SaleOrderResponse> getAll() {
        return saleOrders.getAll()
                    .stream()
                    .map(dto -> new SaleOrderResponse(dto))
                    .collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SaleOrderResponse getById(@PathParam("id") long id) {
        SaleOrderDto saleOrderDto = saleOrders.findById(id);
        SaleOrderResponse res = new SaleOrderResponse(saleOrderDto);
        return res;
    }

    @Path("{id}")
    @DELETE
    @Transactional
    public Response delete(@PathParam("id") long id) {
        saleOrders.delete(id);
        return Response.status(204).build();
    }

    @POST
    @Path("{orderId}/lines")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrderLine(@PathParam("orderId") long orderId, SaleOrderLineDto solDto) {
        saleOrders.saveLine(orderId, solDto);
        return Response.status(201).build();
        
    }

    @GET
    @Path("{orderId}/lines")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SaleOrderLineResponse> getOrderLines(@PathParam("orderId") long orderId) {
        return saleOrders.findOrderLines(orderId)
                    .stream()
                    .map(dto -> new SaleOrderLineResponse(dto))
                    .collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{orderId}/lines/{lineId}")
    @Produces(MediaType.APPLICATION_JSON)
    public SaleOrderLineResponse getOrderLines(@PathParam("orderId") long orderId, @PathParam("lineId") long lineId) {
        return saleOrders.findOrderLines(orderId)
                .stream()
                .filter(lineDto -> lineDto.getId() == lineId)
                .map(dto -> new SaleOrderLineResponse(dto))
                .findFirst()
                .orElse(null);
    }

}
