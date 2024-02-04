package com.fshahy.app.orders.repositories;

import com.fshahy.app.orders.dto.ProductDto;
import java.util.List;


import com.fshahy.app.orders.models.Product;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

@RequestScoped
public class ProductRepository {
    
    @PersistenceContext(unitName = "the-app-pu")
    private EntityManager entityManager;
    
    @Inject
    private ModelMapper modelMapper;

    public ProductDto save(ProductDto productDto) {
        Product product = this.modelMapper.map(productDto, Product.class);
        entityManager.persist(product);
        entityManager.flush(); // because I need to load the id generated for entity
//        return product;
        return this.modelMapper.map(product, ProductDto.class);
        
    }

    public List<ProductDto> getAll() {
        return entityManager
                .createNamedQuery("Product.All", Product.class)
                .getResultStream()
                .map(product -> this.modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public ProductDto findbyId(long id) {
        Product product = entityManager.find(Product.class, id);
//        return product;
        return this.modelMapper.map(product, ProductDto.class);
    }

}
