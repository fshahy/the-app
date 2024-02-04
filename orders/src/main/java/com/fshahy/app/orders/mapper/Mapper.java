package com.fshahy.app.orders.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import java.io.Serializable;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class Mapper implements Serializable {

    @Produces
    private ModelMapper mapper;
    
    public Mapper() {
        this.mapper = new ModelMapper();
    }

}