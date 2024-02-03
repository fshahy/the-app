package com.fshahy.app.orders.repositories;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fshahy.app.orders.dto.ProductDto;
import com.fshahy.app.orders.models.Product;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProductRepository {
    
    @PersistenceContext(unitName = "the-app-pu")
    private EntityManager entityManager;

    @Inject
    private ModelMapper modelMapper;

    public ProductDto save(ProductDto productDto) {
        System.out.println(productDto.getName());
        Product product = this.modelMapper.map(productDto, Product.class);
        entityManager.persist(product);
        return this.modelMapper.map(product, ProductDto.class);
        
    }

    public List<ProductDto> getAll() {
        return entityManager
                .createNamedQuery("Product.All", Product.class)
                .getResultStream()
                .map(product -> this.modelMapper.map(product,ProductDto.class))
                .collect(Collectors.toList());
    }

}
