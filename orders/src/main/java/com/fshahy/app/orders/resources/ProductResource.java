package com.fshahy.app.orders.resources;

import java.util.List;

import com.fshahy.app.orders.dto.ProductDto;
import com.fshahy.app.orders.models.Product;
import com.fshahy.app.orders.repositories.ProductRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("products")
public class ProductResource {

    @Inject
    private ProductRepository products;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDto create(ProductDto productDto) {
        return products.save(productDto);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getAll() {
        return products.getAll();
    }

}
