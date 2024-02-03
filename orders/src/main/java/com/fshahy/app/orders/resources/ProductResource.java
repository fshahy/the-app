package com.fshahy.app.orders.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.fshahy.app.orders.dto.ProductDto;
import com.fshahy.app.orders.http.ProductReponse;
import com.fshahy.app.orders.repositories.ProductRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
    public ProductReponse create(ProductDto productDto) {
        productDto = products.save(productDto);
        ProductReponse res = new ProductReponse(productDto);
        return res;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductReponse> getAll() {
        return products.getAll()
                        .stream()
                        .map(dto -> new ProductReponse(dto))
                        .collect(Collectors.toUnmodifiableList());
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductReponse getById(@PathParam("id") long id) {
        ProductDto productDto = products.findbyId(id);
        ProductReponse res = new ProductReponse(productDto);
        return res;
    }

}
